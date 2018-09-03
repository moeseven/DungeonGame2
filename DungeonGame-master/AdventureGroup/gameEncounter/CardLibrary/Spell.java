package gameEncounter.CardLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Hero;


public abstract class Spell extends Card{

	@Override
	public void buildLogEntry(Hero hero) {
		hero.getPlayer().getGame().log.addLine("casts "+getName()+" on "+hero.getTarget().getName());		
	}
	@Override
	public LinkedList<String> getCardText(Hero hero) {
		//TODO correct number display
		LinkedList<String> retVal= new LinkedList<String>();
		return retVal;
	}
	@Override
	public boolean extraCastConditions(Hero hero) {
		// TODO Auto-generated method stub
		return true;
	}

}
