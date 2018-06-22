package game;

import java.io.Serializable;

import gameEncounter.Hero;

public abstract class RoomInteraction implements Serializable{
	protected String name;
	public RoomInteraction() {
		super();
		name="room interaction";
		// TODO Auto-generated constructor stub
	}

	public abstract void onEnter(Game game);//triggered on entering the room (traps)

	public abstract void onInteraction(Hero hero);//triggered when interacted with
		

	//getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
