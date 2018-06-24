package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;


public abstract class SpellnoTarget extends Card{

	@Override
	public void buildLogEntry(Hero hero) {
		hero.getPlayer().getGame().log.addLine("casts "+getName());		
	}
	

}
