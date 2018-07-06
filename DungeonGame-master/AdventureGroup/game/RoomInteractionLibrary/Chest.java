package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Chest extends RoomInteraction{
	private int charges=1;
	private int gold=100;
	private LinkedList<Item> items= new LinkedList<Item>();
	public Chest() {
		super();
		name="chest";
		gold=(int) (Math.random()*120);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		if(Math.random()<0.18) {
			items.add(game.generator.generateRandomItem(0));
		}
	}

	@Override
	public void onInteraction(Hero hero) {
		if(charges>0) {
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
	
}
