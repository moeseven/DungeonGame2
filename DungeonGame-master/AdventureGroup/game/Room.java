package game;

import java.util.LinkedList;

import gameEncounter.Fight;
import gameEncounter.Hero;

public abstract class Room {
	protected boolean hasFight;
	protected Fight fight;
	protected boolean readyToLeave;
	protected LinkedList<Hero> heroes;
	public Room() {
	}
	public void initialize() {
		readyToLeave=false;
	}
	public abstract void enterRoom(Game game);
	//here the room is set up//food consumption//torch level
	
	public Fight getFight() {
		if(hasFight) {
			return fight;
		}else {return null;}
	}
	public boolean isHasFight() {
		return hasFight;
	}
	public void setHasFight(boolean hasFight) {
		this.hasFight = hasFight;
	}
	
}
