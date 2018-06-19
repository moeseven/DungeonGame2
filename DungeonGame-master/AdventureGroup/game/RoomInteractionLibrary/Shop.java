package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Shop extends RoomInteraction{
	private LinkedList<Item> items;
	private Item selectedItem;
	
	public Shop() {
		super();
		name="merchant";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		//setup shop here
	}
	
}
