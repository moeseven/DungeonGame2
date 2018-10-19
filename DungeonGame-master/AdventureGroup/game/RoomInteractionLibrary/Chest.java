package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.usables.ItemConsumable;

public class Chest extends RoomInteraction{
	private int charges=1;
	private int gold=100;
	private LinkedList<Item> items= new LinkedList<Item>();
	public Chest(Game game) {
		super(game);
		//image=game.imageLoader.getImage(82);
		setImageNumber(82);
		name="chest";
		gold=(int) (Math.random()*120);
		
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		setImageNumber(90);
		if(charges>0) {
			if(Math.random()<0.18) {
				items.add(game.generator.generateRandomItem(1.5));
			}
			if (Math.random()<0.4) {
				items.add(ItemConsumable.generateRandomConsumable());
			}
			charges+=-1;
			hero.getPlayer().gainGold(gold);
			for(int i=0; i<items.size();i++) {
				hero.getPlayer().addItemtoInventory(items.get(i));
			}			
		}else {		
			
			hero.getPlayer().getGame().log.addLine("the chest is empty");
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

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
}
