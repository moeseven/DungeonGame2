package game;

import java.io.Serializable;
import java.util.LinkedList;

import game.QuestLibrary.QuestReturnRelic;
import game.RoomInteractionLibrary.Chest;
import game.RoomInteractionLibrary.SpikeTrap;
import game.RoomInteractionLibrary.Tavern;
import game.RoomInteractionLibrary.Well;
import game.RoomLibrary.EmptyRoom;
import game.RoomLibrary.GoblinRoom1;
import game.characterTypeLibrary.*;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.ArmorThinLeather;
import gameEncounter.ItemLibrary.ShortSword;

public class GeneratorRandom implements Serializable{
	private LinkedList<CharacterRace> heroRacePool;
	private LinkedList<CharacterClass> heroClassPool;
	private LinkedList<Item> itemPool;
	private LinkedList<RoomInteraction> interactionPool;
	private LinkedList<MonsterRace> monsterRacePool;
	private LinkedList<CharacterClass> monsterClassPool;
	public GeneratorRandom(){
		//the following dont need to be cloned
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
		monsterClassPool=new LinkedList<CharacterClass>();
		monsterClassPool.add(new TypeWarrior());
		monsterClassPool.add(new TypeArcher());
		//
		//the following objects have to be cloned
		newItemPool();
		newInteractionPool();
	}
	public void newInteractionPool() {
		interactionPool= new LinkedList<RoomInteraction>();
		interactionPool.add(new Chest());
		interactionPool.add(new Well());
		interactionPool.add(new SpikeTrap());
	}
	public void newItemPool() {
		itemPool=new LinkedList<Item>();
		itemPool.add(new ShortSword());
		itemPool.add(new ArmorThinLeather());
	}
	public Hero generateRandomHero(Player player) {
		CharacterRace cRace=heroRacePool.get((int) Math.min(heroRacePool.size()-1, Math.random()*heroRacePool.size()));
		CharacterClass cClass=heroClassPool.get((int) Math.min(heroClassPool.size()-1, Math.random()*heroClassPool.size()));
		String randomName = cRace.getNameList().get((int) Math.min(cRace.getNameList().size()-1, Math.random()*cRace.getNameList().size()));
		return new Hero(randomName, player, cRace, cClass);
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
			for(int i=0; i<monsters.size(); i++) {
				room.monsters.add(monsters.get(i));
			}
		}
		
		return room;
	}
	public Quest generateRandomQuest(Game game) {
		return new QuestReturnRelic(game);
	}
}
