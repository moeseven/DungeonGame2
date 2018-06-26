package game;

import java.io.Serializable;
import java.util.LinkedList;

import com.sun.xml.internal.ws.api.client.ThrowableInPacketCompletionFeature;

import game.RoomInteractionLibrary.Chest;
import game.RoomInteractionLibrary.SpikeTrap;
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
	private LinkedList<CharacterRace> monsterRacePool;
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
		monsterRacePool=new LinkedList<CharacterRace>();
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
	public Hero generateRandomMonster(Game game) {
		//adjust this to difficulty and progression day
		return new Hero("", game.dungeonMaster,new RaceGoblin(), new TypeWarrior());
	}
	public Room generateRandomRoom(Game game) {
		//return a randomly generated room here
		Room room= new EmptyRoom(game);
		
		//fill room with random interactions		
		for(int i=0; i<Math.random()*3; i++) {//random amount of interactions
			room.getInteractions().add(interactionPool.get((int)(Math.min(interactionPool.size()-1, Math.random()*interactionPool.size()))));
			newInteractionPool();//so there are no multiple interaction that are actually the same instance
		}
		//
		boolean roomHasFight;
		if (Math.random()<0.3) {//chance that a room has a fight
			roomHasFight=true;
			for(int i=0; i<(int)(2+Math.min(Math.random()*2, 1)); i++) {
				room.monsters.add(new Hero("", game.dungeonMaster,monsterRacePool.get((int)(Math.min(monsterRacePool.size()-1, Math.random()*monsterRacePool.size()))), monsterClassPool.get((int)(Math.min(monsterClassPool.size()-1, Math.random()*monsterClassPool.size())))));
			}
		}
		return room;
	}
}
