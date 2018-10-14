package game;

import java.io.Serializable;
import java.util.LinkedList;

import GUI.grafics.MyImageLoader;
import game.ActLibrary.Act1;
import game.QuestLibrary.QuestReturnRelic;
import game.RoomInteractionLibrary.Tavern;
import game.RoomLibrary.Town;
import gameEncounter.Fight;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.CardLibrary.CardBuilder;
import gameEncounter.ItemLibrary.ItemBuilder;
import gameEncounter.ItemLibrary.ItemSuffixBuilder;
import tools.MyLog;

public class Game implements Serializable{
private Player player; //change this for multiplayer
public Player dungeonMaster;
public GeneratorRandom generator;
//public MyImageLoader imageLoader;
public CardBuilder cardBuilder;
public ItemBuilder itemBuilder;
public ItemSuffixBuilder itemSuffixBuilder;
public int turn=0;
public int points=0;
public MyLog log;
private Room room;
private Room town;
private LinkedList<Quest> availableQuests;
private Quest activeQuest;
private Act activeAct;
private int idleStressRelief=10;
public Game() {
	super();	
	cardBuilder = new CardBuilder();
	itemBuilder = new ItemBuilder(this);
	itemSuffixBuilder= new ItemSuffixBuilder();
	dungeonMaster=new DungeonMaster(this);
	generator=new GeneratorRandom(this);
	log=new MyLog();
	this.availableQuests=new LinkedList<Quest>();
	town=new Town(this);
	room=town;
	activeAct= new Act1(this);
	activeQuest= activeAct.getMainQuest();
	player=new Player(this);
	//cardBuilder.printMap();
}
public void enterRoom(Room room) {
	this.room=room;
	log=new MyLog();
	for(int i=0; i<player.getHeroes().size();i++) {
		player.getHeroes().get(i).applyNegativeTurnEffects();
	}	
	room.prepareRoomAndEnter(this);
}
public void increaseGameTurn() {
	//increment turns for final score
	//do time related stuff here
	if (turn % 4==0) {
		for(int i=0; i<getPlayer().getAvailableHeroes().size();i++) {
		getPlayer().getAvailableHeroes().get(i).setStress(getPlayer().getAvailableHeroes().get(i).getStress()-idleStressRelief);
		if (getPlayer().getAvailableHeroes().get(i).getStress()<0) {
			getPlayer().getAvailableHeroes().get(i).setStress(0);
		}
		getPlayer().getAvailableHeroes().get(i).setHp(GameEquations.maxHealthCalc(getPlayer().getAvailableHeroes().get(i)));
		}	
		if(getPlayer().getAvailableHeroes().size()<10) {
			getPlayer().getAvailableHeroes().add(generator.generateRandomHero(getPlayer()));
		}
	}	
	turn++;
}
//getters and setters
public Room getRoom() {
	return room;
}
public void setRoom(Room room) {
	this.room = room;
}
public Player getPlayer() {
	return player;
}
public void setPlayer(Player player) {
	this.player = player;
}
//public Room getNextRoom() {
//	if(room!=town) {
//		if(activeQuest.getRooms().size()>activeQuest.getRooms().indexOf(room)+1) {
//			return activeQuest.getRooms().get(activeQuest.getRooms().indexOf(room)+1);
//		}else {
//			return town;
//		}
//	}else {
//		return activeQuest.getRooms().getFirst();
//	}		
//}
//public void enterNextRoom() {
//	room=getNextRoom();
//	//check here if all heroes are dead
//    LinkedList<Hero> stressedOutHeroes= new LinkedList<Hero>();
//	for(int i=0; i<this.getPlayer().getHeroes().size();i++) {
//		if(!getPlayer().getHeroes().get(i).isDead()) {
//			if(player.getHeroes().get(i).getStress()==player.getHeroes().get(i).getStressCap()) {
//				stressedOutHeroes.add(getPlayer().getHeroes().get(i));
//			}
//		}		
//		//player.getHeroes().get(i).becomeStressed(2); find other ways to stress
//	}
//	player.removeDeadHeroesFromRoster();
//	for(int i=0; i<stressedOutHeroes.size();i++) {
//		if(!stressedOutHeroes.get(i).isDead()){
//			player.getHeroes().remove(stressedOutHeroes.get(i));
//			player.getAvailableHeroes().add(stressedOutHeroes.get(i));
//		}		
//	}
//	if(player.getHeroes().size()==0) {
//		//TODO return to town here -- Quest over!
//		room=town;
//	}	
//	log.clear();
//	
//	if(room!=town) {
//		log.addLine("||||같같같같같같같�"+"ROOM "+activeQuest.getRooms().indexOf(room)+"같같같같같같같�||||");
//	}	
//	room.prepareRoomAndEnter(this);
//	
//}

public void tpHeroes() {
	player.removeDeadHeroesFromRoster();
	if(player.getHeroes().size()==0) {
		player.setInventory(new LinkedList<Item>());
	}else {
		for(int i=0; i<player.getHeroes().size();i++) {
			player.getHeroes().get(i).setUpDrawPile();
			player.getHeroes().get(i).turnBegin();
		}
	}	
	player.setTpLocation(room);
	this.enterRoom(town);		
}
public void retreatHeroes() {
	player.removeDeadHeroesFromRoster();
	if(player.getHeroes().size()==0) {
		player.setInventory(new LinkedList<Item>());
	}else {
		for(int i=0; i<player.getHeroes().size();i++) {
			player.getHeroes().get(i).setUpDrawPile();
			player.getHeroes().get(i).turnBegin();
			player.getHeroes().get(i).becomeStressed(12);
		}
	}
	Room previousRoom=town;
	if(activeQuest.getRooms().indexOf(room)>0) {
		previousRoom= activeQuest.getRooms().get(activeQuest.getRooms().indexOf(room)-1);
	}	
	this.enterRoom(previousRoom);		
}
public Room getTown() {
	return town;
}
public LinkedList<Quest> getAvailableQuests() {
	return availableQuests;
}
public void setAvailableQuests(LinkedList<Quest> availableQuests) {
	this.availableQuests = availableQuests;
}
public Quest getActiveQuest() {
	return activeQuest;
}
public void setActiveQuest(Quest activeQuest) {
	this.activeQuest = activeQuest;
}
public Act getActiveAct() {
	return activeAct;
}
public void setActiveAct(Act activeAct) {
	this.activeAct = activeAct;
}

}
