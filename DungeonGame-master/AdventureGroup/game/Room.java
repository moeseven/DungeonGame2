package game;

import java.util.LinkedList;

import gameEncounter.Fight;
import gameEncounter.Hero;

public abstract class Room {
	protected boolean hasFight;
	protected Fight fight;
	protected boolean readyToLeave;
	protected LinkedList<Hero> heroes;
	public Room(LinkedList<Hero> heroes) {
		this.heroes=heroes;
	}
	public void initialize() {
		readyToLeave=false;
	}
	public abstract void enterRoom();
	//here the room is set up//food consumption//torch level
	
	public Fight getFight() {
		if(hasFight) {
			return fight;
		}else {return null;}
	}
}
