package game;

import java.util.LinkedList;

import gameEncounter.Fight;
import gameEncounter.Hero;

public abstract class Room {
	protected boolean hasFight;
	protected Fight fight;
	protected boolean readyToLeave;
	protected LinkedList<Hero> heroes;
	protected Game game;
	public Room(Game game) {
		this.game=game;
	}
	public void initialize() {
		readyToLeave=false;
	}
	public abstract void enterRoom(LinkedList<Hero> heroes);
	//here the room is set up//food consumption//torch level
	
	public Fight getFight() {
		if(hasFight) {
			return fight;
		}else {return null;}
	}
}
