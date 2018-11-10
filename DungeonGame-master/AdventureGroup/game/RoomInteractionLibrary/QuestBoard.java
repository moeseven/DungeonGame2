package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.Quest;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;

public class QuestBoard extends RoomInteraction{
	public QuestBoard(Game game) {
		super(game);
		//image=game.imageLoader.getImage(106);
		setImageNumber(106);
		name="quest board";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInteraction(Hero hero) {
		for (int i = 0; i < game.getAvailableQuests().size(); i++) {
			game.log.addLine(game.getAvailableQuests().get(i).getDescription());
		}
	}
	
}
