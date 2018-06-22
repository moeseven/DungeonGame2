package game;

import java.io.Serializable;
import java.util.LinkedList;

import gameEncounter.Fight;
import gameEncounter.Hero;

public class Game implements Serializable{
private Player player; //change this for multiplayer
public Player dungeonMaster;
private Room room;
private LinkedList<Room> roomChain;
public Game(LinkedList<Room> roomChain) {
	super();
	this.roomChain=roomChain;
	room=roomChain.getFirst();
	player=new Player(this);
	dungeonMaster=new DungeonMaster(this);
}
public void enterRoom(Room room) {
	this.room=room;
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
	if(roomChain.size()>roomChain.indexOf(room)+1) {
		return roomChain.get(roomChain.indexOf(room)+1);
	}else {
		return null;
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
	}
	room.prepareRoomAndEnter(this);
	System.out.println("roomNr: "+roomChain.indexOf(room));
}

}
