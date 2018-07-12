package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.*;
import gameEncounter.ItemLibrary.usables.ExperienceBook;
import gameEncounter.ItemLibrary.usables.HealingPotion;

public class Altar extends RoomInteraction{
	public int prayers=3;
	public int sacrefices=2;
	public Altar() {
		super();
		name="altar";
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		//setup shop here
		if(!hero.isDead()) {
			hero.getPlayer().getGame().log.addLine("visiting altar");
			hero.getPlayer().getGame().getRoom().setAltar(this);
			hero.getPlayer().getGame().getRoom().setAltarOpen(true);
		}
		
	}
}
