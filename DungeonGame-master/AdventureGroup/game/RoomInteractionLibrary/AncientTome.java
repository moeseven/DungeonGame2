package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class AncientTome extends RoomInteraction{
	private int charges=1;
	private LinkedList<Item> items= new LinkedList<Item>();
	public AncientTome(Game game) {
		super(game);
		setImageNumber(82);
		name="ancient tome";		
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		setImageNumber(90);
		if(charges>0) {
			charges+=-1;			
			if (Math.random()<0.3) {
				hero.becomeStressed(15);
				hero.gainExp(10);
			}else {
				hero.gainExp(55);
			}
		}else {		
			
			hero.getPlayer().getGame().log.addLine("the tome is read");
		}
		
	}

	public LinkedList<Item> getItems() {
		return items;
	}

	public void setItems(LinkedList<Item> items) {
		this.items = items;
	}
	
}
