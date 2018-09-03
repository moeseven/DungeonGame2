package game;

import java.io.Serializable;
import java.util.LinkedList;

import game.QuestLibrary.KillANecromancer;
import game.QuestLibrary.QuestLongReturnRelic;
import game.QuestLibrary.QuestReturnRelic;
import game.QuestLibrary.TestQuest;
import game.RoomInteractionLibrary.Altar;
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
import game.monsters.FireSpirit;
import game.monsters.RaceGoblin;
import game.monsters.RaceRat;
import game.monsters.RaceSkeletton;
import game.monsters.RaceZombie;
import game.monsters.Spectre;
import game.monsters.Thornback;
import gameEncounter.Hero;
import gameEncounter.HeroQuirk;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;
import gameEncounter.HeroQuirkLibrary.Aggressive;
import gameEncounter.HeroQuirkLibrary.Bleeder;
import gameEncounter.HeroQuirkLibrary.Defensive;
import gameEncounter.HeroQuirkLibrary.Hairy;
import gameEncounter.HeroQuirkLibrary.Hasty;
import gameEncounter.HeroQuirkLibrary.OneEyed;
import gameEncounter.HeroQuirkLibrary.SimpleMinded;
import gameEncounter.HeroQuirkLibrary.SlugBrained;
import gameEncounter.HeroQuirkLibrary.Stresser;
import gameEncounter.HeroQuirkLibrary.Strong;
import gameEncounter.HeroQuirkLibrary.SubstanceAbuser;
import gameEncounter.HeroQuirkLibrary.Tender;
import gameEncounter.HeroQuirkLibrary.Thoughtfull;
import gameEncounter.HeroQuirkLibrary.Tough;
import gameEncounter.HeroQuirkLibrary.Weak;
import gameEncounter.ItemLibrary.ArmorThinLeather;
import gameEncounter.ItemLibrary.Buckler;
import gameEncounter.ItemLibrary.CrownOfThorns;
import gameEncounter.ItemLibrary.Dagger;
import gameEncounter.ItemLibrary.HeavySword;
import gameEncounter.ItemLibrary.Helmet;
import gameEncounter.ItemLibrary.LeatherArmor;
import gameEncounter.ItemLibrary.MagicStaff;
import gameEncounter.ItemLibrary.MorningStar;
import gameEncounter.ItemLibrary.PlateArmor;
import gameEncounter.ItemLibrary.SanguineBloodletter;
import gameEncounter.ItemLibrary.ShortBow;
import gameEncounter.ItemLibrary.ShortSword;
import gameEncounter.ItemLibrary.Speer;
import gameEncounter.ItemLibrary.Spellbook;
import gameEncounter.ItemLibrary.usables.ExperienceBook;
import gameEncounter.ItemLibrary.usables.HealingPotion;
import gameEncounter.ItemLibrary.usables.ItemConsumable;
import gameEncounter.ItemLibrary.usables.PotionOfDexterity;
import gameEncounter.ItemLibrary.usables.PotionOfIntelligence;
import gameEncounter.ItemLibrary.usables.PotionOfStrength;
import gameEncounter.ItemLibrary.usables.PotionOfVitality;

public class GeneratorRandom implements Serializable{
	private LinkedList<CharacterRace> heroRacePool;
	private LinkedList<CharacterClass> heroClassPool;
	private LinkedList<HeroQuirk> heroQuirkPool;
	private LinkedList<Item> itemPool;
	private LinkedList<Quest> questPool;
	private LinkedList<RoomInteraction> interactionPool;
	private LinkedList<MonsterRace> monsterRacePool;
	LinkedList<NameValuePair> enchantments;
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
		heroQuirkPool.add(new SubstanceAbuser());
		heroQuirkPool.add(new Thoughtfull());
		heroQuirkPool.add(new Hasty());
		heroQuirkPool.add(new SimpleMinded());
		////
		heroRacePool=new LinkedList<CharacterRace>();
		heroRacePool.add(new RaceHuman(game));
		heroRacePool.add(new RaceDwarf(game));
		heroRacePool.add(new RaceElf(game));
		heroRacePool.add(new RaceHalfling(game));
		////
		heroClassPool=new LinkedList<CharacterClass>();
		heroClassPool.add(new TypeWarrior(game));
		heroClassPool.add(new TypeMage(game));
		heroClassPool.add(new TypeArcher(game));
		heroClassPool.add(new TypeCleric(game));
		heroClassPool.add(new TypeThief(game));
		monsterRacePool=new LinkedList<MonsterRace>();
		monsterRacePool.add(new RaceGoblin(game));
		monsterRacePool.add(new RaceZombie(game));
		monsterRacePool.add(new RaceSkeletton(game));
		monsterRacePool.add(new FireSpirit(game));
		monsterRacePool.add(new RaceRat(game));
		monsterRacePool.add(new Spectre(game));
		monsterRacePool.add(new Thornback(game));
		//item enchantments
		enchantments= new LinkedList<NameValuePair>();
		enchantments.add(new NameValuePair(3, "spell"));
		enchantments.add(new NameValuePair(3, "speed"));
		enchantments.add(new NameValuePair(3, "resistSpell"));
		enchantments.add(new NameValuePair(3, "accuracy"));
		enchantments.add(new NameValuePair(3, "dodge"));
		enchantments.add(new NameValuePair(1, "draw"));
		enchantments.add(new NameValuePair(3, "block"));
		enchantments.add(new NameValuePair(3, "attack"));
		enchantments.add(new NameValuePair(3, "speed"));
		enchantments.add(new NameValuePair(10, "health"));
		enchantments.add(new NameValuePair(15, "thorns"));
		enchantments.add(new NameValuePair(10, "resistBleed"));
		enchantments.add(new NameValuePair(10, "resistPoison"));
		enchantments.add(new NameValuePair(10, "resistCold"));
		enchantments.add(new NameValuePair(10, "resistFire"));
		enchantments.add(new NameValuePair(10, "resistStress"));
		enchantments.add(new NameValuePair(10, "resistStun"));
		//
		//the following objects have to be cloned
		newItemPool();
		newInteractionPool();
	}
	//
	private class NameValuePair{
		public int bonus;
		public String name;
		public NameValuePair(int bonus, String name) {
			this.bonus=bonus;
			this.name=name;
		}
	}
	//put up new Pools to prevent same instances of different stuff
	public void newInteractionPool() {
		interactionPool= new LinkedList<RoomInteraction>();
		interactionPool.add(new Chest(game));
		interactionPool.add(new EvilStatue(game));
		interactionPool.add(new Shop(game));
		interactionPool.add(new Sack(game));
		interactionPool.add(new Well(game));
		interactionPool.add(new SpikeTrap(game));
		interactionPool.add(new PoisonTrap(game));
		interactionPool.add(new SleepingOgre(game));
		interactionPool.add(new HayHeap(game));
		interactionPool.add(new Altar(game));
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
		itemPool.add(new Buckler());
		itemPool.add(new MagicStaff());		
		itemPool.add(new SanguineBloodletter());
		itemPool.add(new Dagger());
		itemPool.add(new Helmet());
		itemPool.add(new CrownOfThorns());
		itemPool.add(new MorningStar());
		itemPool.add(new Spellbook());
		//consumables
		itemPool.add(new HealingPotion());
		itemPool.add(new HealingPotion());
		itemPool.add(new HealingPotion());
		itemPool.add(new HealingPotion());
		itemPool.add(new ExperienceBook());
		itemPool.add(new PotionOfDexterity());
		itemPool.add(new PotionOfIntelligence());
		itemPool.add(new PotionOfStrength());
		itemPool.add(new PotionOfVitality());
	}
	public void newQuestPool() {
		questPool=new LinkedList<Quest>();
		questPool.add(new KillANecromancer(game));
		questPool.add(new QuestReturnRelic(game));
		questPool.add(new QuestLongReturnRelic(game));
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
		if(Math.random()<0.8+difficultyLevel/8){
			monsterSet.add(new Hero("", game.dungeonMaster,monsterRace, monsterRace.getPosition2Classes().get((int) Math.min(monsterRace.getPosition2Classes().size()-1, Math.random()*monsterRace.getPosition2Classes().size()))));
		}		
		if(Math.random()<0.7+difficultyLevel/9){
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
	//item enchantments that increase price and give random stuff to item
	public void enchant(Item item, int level) {
		//TODO
		if(item instanceof ItemConsumable) {
			
		}else {
			NameValuePair pair = enchantments.get((int) Math.min(enchantments.size()-1, Math.random()*enchantments.size()));
			int randomizedValue = (int) Math.max(1, pair.bonus*Math.random());
			item.setGoldValue((int) (item.getGoldValue()*(1.2+randomizedValue/pair.bonus)));
			item.getStats().getStats()[ModableHeroStats.nameResolveStat(pair.name)]+=randomizedValue;
		}
		
	}	
	public Item generateRandomItem(int level) {
		newItemPool();
		Item item = itemPool.get((int) Math.min(itemPool.size()-1, Math.random()*itemPool.size()));
		if(Math.random()<0.1*level) {
			enchant(item, level);
		}
		if(Math.random()<0.01*level) {
			enchant(item, level);
		}
		return item;
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
