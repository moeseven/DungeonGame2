package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.usables.ItemConsumable;

public class PotionShelf extends RoomInteraction{
	private int charges=1;
	private LinkedList<Item> items= new LinkedList<Item>();
	public PotionShelf(Game game) {
		super(game);
		//image=game.imageLoader.getImage(82);
		setImageNumber(143);
		name="potion shelf";
		
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		setImageNumber(144);
		if(charges>0) {
			items.add(ItemConsumable.generateRandomConsumable());
			items.add(ItemConsumable.generateRandomConsumable());
			if(Math.random()<0.18) {
				items.add(ItemConsumable.generateRandomConsumable());
			}
			charges+=-1;
			for(int i=0; i<items.size();i++) {
				hero.getPlayer().addItemtoInventory(items.get(i));
			}			
		}else {					
			hero.getPlayer().getGame().log.addLine("the shelf is empty");
		}
		
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}

	public int getCharges() {
		return charges;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}
	
}
