package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.Quest;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Portal extends RoomInteraction{
	public Portal(Game game) {
		super(game);
		setImageNumber(1);
		name="portal";
		hidden = true;
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		if (game.getActiveAct().isFinished()) {
			hidden=false;
		}
	}

	@Override
	public void onInteraction(Hero hero) {
		if (game.getActList().size()-1>game.getActList().indexOf(game.getActiveAct())) {
			game.setActiveAct(game.getActList().get(game.getActList().indexOf(game.getActiveAct())+1));
		}
		hidden=false;
	}
	
}
