package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.*;
import gameEncounter.ItemLibrary.usables.ExperienceBook;
import gameEncounter.ItemLibrary.usables.HealingPotion;

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
		items.add(new ShortSword());
		items.add(new Buckler());
		items.add(new Dagger());
		items.add(new CrownOfThorns());
		items.add(new HeavySword());
		items.add(new PlateArmor());
		items.add(new ArmorThinLeather());
		items.add(new ExperienceBook());
		items.add(new HealingPotion());
		items.add(new HealingPotion());
		items.add(new HealingPotion());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		//setup shop here
		if(!hero.isDead()) {
			hero.getPlayer().getGame().log.addLine("entering shop");
			hero.getPlayer().getGame().getRoom().setShop(this);
			hero.getPlayer().getGame().getRoom().setShopOpen(true);
		}
		
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
}
