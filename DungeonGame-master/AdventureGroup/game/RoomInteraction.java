package game;

import gameEncounter.Hero;

public abstract class RoomInteraction {
	protected String name;
	public RoomInteraction() {
		super();
		name="room interaction";
		// TODO Auto-generated constructor stub
	}

	public abstract void onEnter();//triggered on entering the room (traps)

	public abstract void onInteraction(Hero hero);//triggered when interacted with
		

	//getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
