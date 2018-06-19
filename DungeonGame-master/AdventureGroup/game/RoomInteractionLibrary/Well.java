package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Well extends RoomInteraction{
	private int charges=3;
	public Well() {
		super();
		name="well";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		if(charges>0) {
			hero.heal(hero.computeMaxHp()/3);
			charges+=-1;
			System.out.println(hero.getName()+" receives a refreshment");
		}else {
			System.out.println("the well is empty");
		}
		
	}
	
}
