package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Chest extends RoomInteraction{
	private int charges=1;
	private int gold=100;
	public Chest() {
		super();
		name="chest";
		gold=(int) (Math.random()*120);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		if(charges>0) {
			charges+=-1;
			hero.getPlayer().setGold(hero.getPlayer().getGold()+gold);
			hero.getPlayer().getGame().log.addLine(hero.getName()+" finds "+gold+" gold");
		}else {			
			hero.getPlayer().getGame().log.addLine("the chest is empty");
		}
		
	}
	
}
