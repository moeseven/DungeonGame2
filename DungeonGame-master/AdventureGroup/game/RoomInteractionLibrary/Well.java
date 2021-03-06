package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Well extends RoomInteraction{
	private int charges=3;
	public Well(Game game) {
		super(game);
		//image=game.imageLoader.getImage(89);
		setImageNumber(89);
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
			hero.heal(GameEquations.maxHealthCalc(hero)/3);
			hero.looseMoral(-7);
			charges+=-1;
			hero.getPlayer().getGame().log.addLine(hero.getName()+" receives a refreshment and looses 3 stress");
		}else {		
			//image=game.imageLoader.getImage(97);
			setImageNumber(97);
			hero.getPlayer().getGame().log.addLine("the well is empty");
		}
		
	}
	
}
