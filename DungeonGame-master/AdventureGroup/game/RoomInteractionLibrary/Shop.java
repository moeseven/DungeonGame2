package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.*;
import gameEncounter.ItemLibrary.usables.*;

public class Shop extends RoomInteraction{
	private LinkedList<Item> items;
	public Shop(Game game) {
		super(game);
		setImageNumber(108);
		name="merchant";
		items=new LinkedList<Item>();
		
	}

	@Override
	public void onEnter(Game game) {
		items=new LinkedList<Item>();
		items.add(game.generator.generateRandomItem(3.6));
		items.add(game.generator.generateRandomItem(3.5));
		items.add(game.generator.generateRandomItem(3.4));
		items.add(game.generator.generateRandomItem(3));
		items.add(game.generator.generateRandomItem(2.4));
		items.add(game.generator.generateRandomItem(2.3));
		items.add(game.generator.generateRandomItem(2.2));
		items.add(game.generator.generateRandomItem(2.1));
		items.add(game.generator.generateRandomItem(2));
		items.add(game.generator.generateRandomItem(1.6));	
		items.add(ItemConsumable.generateRandomConsumable());
		items.add(ItemConsumable.generateRandomConsumable());
		items.add(new HealingPotion());
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		//setup shop here
		if(!hero.isDead()) {
			hero.getPlayer().getGame().log.addLine("entering shop");
			hero.getPlayer().getGame().getRoom().setShop(this);
			hero.getPlayer().getGame().getRoom().setShopOpen(true);
			hero.setSelectedItem(items.getLast());
		}
		
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
}
