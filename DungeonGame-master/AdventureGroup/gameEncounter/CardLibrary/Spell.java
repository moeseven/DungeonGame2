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
		//generate legeal positions text
		String legalPos="positions(";
		for(int i=0;i<legalPositions.length;i++) {
			if(legalPositions[i]) {
				legalPos+=(i+1)+" ";
			}
		}
		legalPos+=")";
		return legalPos;
	}

}
