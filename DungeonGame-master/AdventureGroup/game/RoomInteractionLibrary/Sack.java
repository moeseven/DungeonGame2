package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Sack extends RoomInteraction{
	private int charges=1;
	private int gold=20;
	private LinkedList<Item> items= new LinkedList<Item>();
	public Sack(Game game) {
		super(game);
		//image=game.imageLoader.getImage(83);
		setImageNumber(83);
		name="sack";
		gold=(int) (Math.random()*15);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		//image=game.imageLoader.getImage(91);
		setImageNumber(91);
		if(charges>0) {
			charges+=-1;
			if(Math.random()>0.4) {
				hero.getPlayer().gainGold(gold);
				for(int i=0; i<items.size();i++) {
					hero.getPlayer().addItemtoInventory(items.get(i));
				}
			}else {
				hero.getPlayer().getGame().log.addLine("rotten remains");
				hero.becomeStressed((int) (Math.random()*12));
			}
						
		}else {			
			hero.getPlayer().getGame().log.addLine("the "+name+" is empty");
		}
		
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
}
