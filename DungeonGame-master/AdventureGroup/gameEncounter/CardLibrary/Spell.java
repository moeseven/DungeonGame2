package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;


public abstract class Spell extends Card{

	@Override
	public void buildLogEntry(Hero hero) {
		hero.getPlayer().getGame().log.addLine("casts "+getName()+" on "+hero.getTarget().getName());		
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
