package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.*;
import gameEncounter.ItemLibrary.usables.ExperienceBook;
import gameEncounter.ItemLibrary.usables.HealingPotion;

public class TeleportStone extends RoomInteraction{
	public TeleportStone(Game game) {
		super(game);
		//image=game.imageLoader.getImage(109);
		setImageNumber(109);
		name="teleport stone";

	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onInteraction(Hero hero) {
		if(!hero.isDead()) {
			game.enterRoom(hero.getPlayer().getTpLocation());
		}		
	}
}
