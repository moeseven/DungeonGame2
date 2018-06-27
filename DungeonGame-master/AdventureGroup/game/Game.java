package game;

import java.io.Serializable;
import java.util.LinkedList;

import game.QuestLibrary.QuestReturnRelic;
import game.RoomInteractionLibrary.Tavern;
import game.RoomLibrary.Town;
import gameEncounter.Fight;
import gameEncounter.Hero;
import gameEncounter.Item;
import tools.MyLog;

public class Game implements Serializable{
private Player player; //change this for multiplayer
public Player dungeonMaster;
public GeneratorRandom generator=new GeneratorRandom();
public int day;
public MyLog log;
private Room room;
private Room town;
private LinkedList<Quest> availableQuests;
private Quest activeQuest;
public Game() {
	super();
	dungeonMaster=new DungeonMaster(this);
	day=1;
	log=new MyLog();
	this.availableQuests=new LinkedList<Quest>();
	newQuest();
	town=new Town(this);
	room=town;
	player=new Player(this);
	
}
public void enterRoom(Room room) {
	this.room=room;
	log=new MyLog();
	for(int i=0; i<player.getHeroes().size();i++) {
		player.getHeroes().get(i).applyNegativeTurnEffects();
	}	
	room.prepareRoomAndEnter(this);
}
public void newQuest() {
	activeQuest=generator.generateRandomQuest(this);
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
public Room getNextRoom() {
	if(room!=town) {
		if(activeQuest.getRooms().size()>activeQuest.getRooms().indexOf(room)+1) {
			return activeQuest.getRooms().get(activeQuest.getRooms().indexOf(room)+1);
		}else {
			return town;
		}
	}else {
		return activeQuest.getRooms().getFirst();
	}		
}
public void enterNextRoom() {
	room=getNextRoom();
	//check here if all heroes are dead
    LinkedList<Hero> stressedOutHeroes= new LinkedList<Hero>();
	for(int i=0; i<this.getPlayer().getHeroes().size();i++) {
		if(!getPlayer().getHeroes().get(i).isDead()) {
			if(player.getHeroes().get(i).getStress()==player.getHeroes().get(i).getStressCap()) {
				stressedOutHeroes.add(getPlayer().getHeroes().get(i));
			}
		}		
		player.getHeroes().get(i).becomeStressed(2);
	}
	player.removeDeadHeroesFromRoster();
	for(int i=0; i<stressedOutHeroes.size();i++) {
		if(!stressedOutHeroes.get(i).isDead()){
			player.getHeroes().remove(stressedOutHeroes.get(i));
			player.getAvailableHeroes().add(stressedOutHeroes.get(i));
		}		
	}
	if(player.getHeroes().size()==0) {
		//TODO return to town here -- Quest over!
		room=town;
	}	
	log.clear();
	
	if(room!=town) {
		log.addLine("||||같같같같같같같�"+"ROOM "+activeQuest.getRooms().indexOf(room)+"같같같같같같같�||||");
	}	
	room.prepareRoomAndEnter(this);
	
}
public void retreatHeroes() {
	player.removeDeadHeroesFromRoster();
	if(player.getHeroes().size()==0) {
		player.setInventory(new LinkedList<Item>());
	}
	this.enterRoom(town);
	day+=1;
	log.addLine("Day: "+day);
	if(player.getAvailableHeroes().size()<10) {
		player.getAvailableHeroes().add(generator.generateRandomHero(player));
		player.getAvailableHeroes().add(generator.generateRandomHero(player));
	}	
	
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

}
