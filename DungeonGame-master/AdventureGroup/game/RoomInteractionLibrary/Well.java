package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Well extends RoomInteraction{
	private int charges=2;
	public Well() {
		super();
		name="well";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		if(charges>0) {
			hero.heal(hero.computeMaxHp()/3);
			hero.becomeStressed(-3);
			charges+=-1;
			hero.getPlayer().getGame().log.addLine(hero.getName()+" receives a refreshment and looses 3 stress");
		}else {			
			hero.getPlayer().getGame().log.addLine("the well is empty");
		}
		
	}
	
}
