package game;

import java.io.Serializable;
import java.util.LinkedList;

import game.RoomLibrary.Town;
import gameEncounter.Fight;
import gameEncounter.Hero;
import tools.MyLog;

public class Game implements Serializable{
private Player player; //change this for multiplayer
public Player dungeonMaster;
public int day;
public MyLog log;
private Room room;
private Room town;
private LinkedList<Room> roomChain;
private LinkedList<Quest> availableQuests;
public Game(LinkedList<Room> roomChain) {
	super();
	day=1;
	log=new MyLog();
	this.availableQuests=new LinkedList<Quest>();
	this.roomChain=roomChain;
	town=new Town();
	room=town;
	player=new Player(this);
	dungeonMaster=new DungeonMaster(this);
}
public void enterRoom(Room room) {
	this.room=room;
	log=new MyLog();
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
	this.enterRoom(town);
	day+=1;
	log.addLine("Day: "+day);
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

}
