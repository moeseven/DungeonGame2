package game;

import java.util.LinkedList;

import gameEncounter.Fight;
import gameEncounter.Hero;

public class Game {
private LinkedList<Hero> heroes;
private Player player; //change this for multiplayer
private Room room;
public Game(LinkedList<Hero> heroes) {
	super();
	this.heroes = heroes;
	player=new Player(this);
	
}
public void enterRoom(Room room) {
	this.room=room;
	room.enterRoom();
}
//getters and setters
public LinkedList<Hero> getHeroes() {
	return heroes;
}
public void setHeroes(LinkedList<Hero> heroes) {
	this.heroes = heroes;
}
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

}
