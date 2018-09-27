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
	public Shop(Game game) {
		super(game);
		//image=game.imageLoader.getImage(108);
		setImageNumber(108);
		name="merchant";
		items=new LinkedList<Item>();
		items.add(new HealingPotion());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		items.add(game.generator.generateRandomItem(1));
		items.add(game.generator.generateRandomItem(1));
		items.add(game.generator.generateRandomItem(1));
		items.add(game.generator.generateRandomItem(1));
		items.add(game.generator.generateRandomItem(1));
		items.add(game.generator.generateRandomItem(1));
		items.add(game.generator.generateRandomItem(1));
		items.add(game.generator.generateRandomItem(1));
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
