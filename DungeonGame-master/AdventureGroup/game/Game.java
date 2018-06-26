package game;

import java.io.Serializable;
import java.util.LinkedList;

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
private LinkedList<Room> roomChain;
private LinkedList<Quest> availableQuests;
public Game() {
	super();
	day=1;
	log=new MyLog();
	this.availableQuests=new LinkedList<Quest>();
	this.roomChain=new LinkedList<Room>();
	town=new Town(this);
	room=town;
	player=new Player(this);
	dungeonMaster=new DungeonMaster(this);
}
public void enterRoom(Room room) {
	this.room=room;
	log=new MyLog();
	for(int i=0; i<player.getHeroes().size();i++) {
		player.getHeroes().get(i).applyNegativeTurnEffects();
	}	
	room.prepareRoomAndEnter(this);
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
		if(roomChain.size()>roomChain.indexOf(room)+1) {
			return roomChain.get(roomChain.indexOf(room)+1);
		}else {
			return town;
		}
	}else {
		return roomChain.getFirst();
	}		
}
public void enterNextRoom() {
	room=getNextRoom();
	//check here if all heroes are dead
	int deadCount=0;
	for(int i=0; i<this.getPlayer().getHeroes().size();i++) {
		if(getPlayer().getHeroes().get(i).isDead()) {
			deadCount+=1;
		}
	}
	if(deadCount==getPlayer().getHeroes().size()) {
		//TODO return to town here -- Quest over!
		room=town;
	}	
	log.clear();
	if(room!=town) {
		log.addLine("||||같같같같같같같�"+"ROOM "+roomChain.indexOf(room)+"같같같같같같같�||||");
	}	
	room.prepareRoomAndEnter(this);
	
}
public void retreatHeroes() {
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
public LinkedList<Room> getRoomChain() {
	return roomChain;
}
public void setRoomChain(LinkedList<Room> roomChain) {
	this.roomChain = roomChain;
}

}
