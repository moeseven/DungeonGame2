package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.*;

public class Shop extends RoomInteraction{
	private LinkedList<Item> items;
	public Shop() {
		super();
		name="merchant";
		items=new LinkedList<Item>();
		items.add(new ShortSword());
		items.add(new Buckler());
		items.add(new Speer());
		items.add(new ShortBow());
		items.add(new ArmorThinLeather());
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
		hero.getPlayer().getGame().getRoom().setShop(this);
		hero.getPlayer().getGame().getRoom().setShopOpen(true);
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
}
