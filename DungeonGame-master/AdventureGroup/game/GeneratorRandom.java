package game;

import java.io.Serializable;
import java.util.LinkedList;

import game.QuestLibrary.KillANecromancer;
import game.QuestLibrary.QuestReturnRelic;
import game.QuestLibrary.TestQuest;
import game.RoomInteractionLibrary.Chest;
import game.RoomInteractionLibrary.EvilStatue;
import game.RoomInteractionLibrary.HayHeap;
import game.RoomInteractionLibrary.PoisonTrap;
import game.RoomInteractionLibrary.Sack;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.SleepingOgre;
import game.RoomInteractionLibrary.SpikeTrap;
import game.RoomInteractionLibrary.Well;
import game.RoomLibrary.EmptyRoom;
import game.characterTypeLibrary.RaceDwarf;
import game.characterTypeLibrary.RaceElf;
import game.characterTypeLibrary.RaceHalfling;
import game.characterTypeLibrary.RaceHuman;
import game.characterTypeLibrary.TypeArcher;
import game.characterTypeLibrary.TypeCleric;
import game.characterTypeLibrary.TypeMage;
import game.characterTypeLibrary.TypeThief;
import game.characterTypeLibrary.TypeWarrior;
import game.monsters.RaceGoblin;
import game.monsters.RaceZombie;
import gameEncounter.Hero;
import gameEncounter.HeroQuirk;
import gameEncounter.Item;
import gameEncounter.HeroQuirkLibrary.Aggressive;
import gameEncounter.HeroQuirkLibrary.Bleeder;
import gameEncounter.HeroQuirkLibrary.Defensive;
import gameEncounter.HeroQuirkLibrary.Hairy;
import gameEncounter.HeroQuirkLibrary.OneEyed;
import gameEncounter.HeroQuirkLibrary.SlugBrained;
import gameEncounter.HeroQuirkLibrary.Stresser;
import gameEncounter.HeroQuirkLibrary.Strong;
import gameEncounter.HeroQuirkLibrary.Tender;
import gameEncounter.HeroQuirkLibrary.Tough;
import gameEncounter.HeroQuirkLibrary.Weak;
import gameEncounter.ItemLibrary.ArmorThinLeather;
import gameEncounter.ItemLibrary.Buckler;
import gameEncounter.ItemLibrary.HeavySword;
import gameEncounter.ItemLibrary.LeatherArmor;
import gameEncounter.ItemLibrary.PlateArmor;
import gameEncounter.ItemLibrary.ShortBow;
import gameEncounter.ItemLibrary.ShortSword;
import gameEncounter.ItemLibrary.Speer;
import gameEncounter.ItemLibrary.usables.HealingPotion;

public class GeneratorRandom implements Serializable{
	private LinkedList<CharacterRace> heroRacePool;
	private LinkedList<CharacterClass> heroClassPool;
	private LinkedList<HeroQuirk> heroQuirkPool;
	private LinkedList<Item> itemPool;
	private LinkedList<Quest> questPool;
	private LinkedList<RoomInteraction> interactionPool;
	private LinkedList<MonsterRace> monsterRacePool;
	private LinkedList<CharacterClass> monsterClassPool;
	private Game game;
	public GeneratorRandom(Game game){
		this.game=game;
		//the following dont need to be cloned
		heroQuirkPool=new LinkedList<HeroQuirk>();
		heroQuirkPool.add(new Strong());
		heroQuirkPool.add(new Weak());
		heroQuirkPool.add(new Bleeder());
		heroQuirkPool.add(new Tough());
		heroQuirkPool.add(new OneEyed());
		heroQuirkPool.add(new Tender());
		heroQuirkPool.add(new Stresser());
		heroQuirkPool.add(new SlugBrained());
		heroQuirkPool.add(new Hairy());
		heroQuirkPool.add(new Defensive());
		heroQuirkPool.add(new Aggressive());
		heroRacePool=new LinkedList<CharacterRace>();
		heroRacePool.add(new RaceHuman());
		heroRacePool.add(new RaceDwarf());
		heroRacePool.add(new RaceElf());
		heroRacePool.add(new RaceHalfling());
		heroClassPool=new LinkedList<CharacterClass>();
		heroClassPool.add(new TypeWarrior());
		heroClassPool.add(new TypeMage());
		heroClassPool.add(new TypeArcher());
		heroClassPool.add(new TypeCleric());
		heroClassPool.add(new TypeThief());
		monsterRacePool=new LinkedList<MonsterRace>();
		monsterRacePool.add(new RaceGoblin());
		monsterRacePool.add(new RaceZombie());
		monsterClassPool=new LinkedList<CharacterClass>();
		monsterClassPool.add(new TypeWarrior());
		monsterClassPool.add(new TypeArcher());
		//
		//the following objects have to be cloned
		newItemPool();
		newInteractionPool();
	}
	//put up new Pools to prevent same instances of different stuff
	public void newInteractionPool() {
		interactionPool= new LinkedList<RoomInteraction>();
		interactionPool.add(new Chest());
		interactionPool.add(new EvilStatue());
		interactionPool.add(new Shop());
		interactionPool.add(new Sack());
		interactionPool.add(new Well());
		interactionPool.add(new SpikeTrap());
		interactionPool.add(new PoisonTrap());
		interactionPool.add(new SleepingOgre());
		interactionPool.add(new HayHeap());
	}
	public void newItemPool() {
		itemPool=new LinkedList<Item>();
		itemPool.add(new ShortSword());
		itemPool.add(new ArmorThinLeather());
		itemPool.add(new LeatherArmor());
		itemPool.add(new ShortBow());
		itemPool.add(new PlateArmor());
		itemPool.add(new Speer());
		itemPool.add(new HeavySword());
		itemPool.add(new HealingPotion());
		itemPool.add(new HealingPotion());
		itemPool.add(new Buckler());
	}
	public void newQuestPool() {
		questPool=new LinkedList<Quest>();
		questPool.add(new KillANecromancer(game));
		questPool.add(new QuestReturnRelic(game));
	}
	///
	public Hero generateRandomHero(Player player) {
		CharacterRace cRace=heroRacePool.get((int) Math.min(heroRacePool.size()-1, Math.random()*heroRacePool.size()));
		CharacterClass cClass=heroClassPool.get((int) Math.min(heroClassPool.size()-1, Math.random()*heroClassPool.size()));
		String randomName = cRace.getNameList().get((int) Math.min(cRace.getNameList().size()-1, Math.random()*cRace.getNameList().size()));
		Hero randomHero=new Hero(randomName, player, cRace, cClass);
		generateRandomHeroQuirk().gainQuirk(randomHero);
		return randomHero;
	}
	public LinkedList<Hero> generateRandomMonsterSet(Game game, int difficultyLevel) {
		//TODO adjust this to difficulty and progression day
		MonsterRace monsterRace= monsterRacePool.get((int) Math.min(monsterRacePool.size()-1, Math.random()*monsterRacePool.size()));
		LinkedList<Hero> monsterSet= new LinkedList<Hero>();
		monsterSet.add(new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPosition1Classes().get((int) Math.min(monsterRace.getPosition1Classes().size()-1, Math.random()*monsterRace.getPosition1Classes().size()))));
		monsterSet.add(new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPosition2Classes().get((int) Math.min(monsterRace.getPosition2Classes().size()-1, Math.random()*monsterRace.getPosition2Classes().size()))));
		if(Math.random()<0.7+difficultyLevel/10){
			monsterSet.add(new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPosition3Classes().get((int) Math.min(monsterRace.getPosition3Classes().size()-1, Math.random()*monsterRace.getPosition3Classes().size()))));
		}
		if(Math.random()<0.3+difficultyLevel/10){
			monsterSet.add(new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPosition4Classes().get((int) Math.min(monsterRace.getPosition4Classes().size()-1, Math.random()*monsterRace.getPosition4Classes().size()))));
		}
		if(Math.random()<0+difficultyLevel/15){
			monsterSet.add(new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPosition5Classes().get((int) Math.min(monsterRace.getPosition5Classes().size()-1, Math.random()*monsterRace.getPosition5Classes().size()))));
		}
		return monsterSet;
	}
	public Room generateRandomRoom(Game game, double fightChance, int difficultyLevel) {
		//return a randomly generated room here
		//TODO add difficulty parameter to adjust difficulty of random Room
		Room room= new EmptyRoom(game);
		
		//fill room with random interactions		
		for(int i=0; i<(int)(Math.random()*3); i++) {//random amount of interactions
			room.getInteractions().add(interactionPool.get((int)(Math.min(interactionPool.size()-1, Math.random()*interactionPool.size()))));
			newInteractionPool();//so there are no multiple interaction that are actually the same instance
		}
		//
		if (Math.random()<fightChance) {//chance that a room has a fight
			room.hasFight=true;
			LinkedList<Hero> monsters=generateRandomMonsterSet(game,difficultyLevel);
			for(int i=monsters.size()-1; i>=0; i--) {
				room.monsters.add(monsters.get(i));
			}
		}
		
		return room;
	}
	public Item generateRandomItem() {
		newItemPool();
		return itemPool.get((int) Math.min(itemPool.size()-1, Math.random()*itemPool.size()));
	}
	public HeroQuirk generateRandomHeroQuirk(){
		return heroQuirkPool.get((int) Math.min(heroQuirkPool.size()-1, Math.random()*heroQuirkPool.size()));
	}
	public Quest generateRandomQuest(Game game) {
		newQuestPool();
		//return new TestQuest(game);
		return questPool.get((int) Math.min(questPool.size()-1, Math.random()*questPool.size()));
	}
}
