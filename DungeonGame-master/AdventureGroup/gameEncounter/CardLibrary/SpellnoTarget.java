package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;


public abstract class SpellnoTarget extends Card{

	@Override
	public void buildLogEntry(Hero hero) {
		hero.getPlayer().getGame().log.addLine("casts "+getName());		
	}
	@Override
	public String getCardText() {
		//TODO correct number display
		return "";
	}
	@Override
	public boolean extraCastConditions(Hero hero) {
		// TODO Auto-generated method stub
		return true;
	}

}
