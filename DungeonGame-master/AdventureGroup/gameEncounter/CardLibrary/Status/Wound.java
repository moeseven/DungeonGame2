package gameEncounter.CardLibrary.Status;

import gameEncounter.Hero;
import gameEncounter.CardLibrary.SpellnoTarget;

public class Wound extends SpellnoTarget{
	public Wound() {
		// TODO Auto-generated constructor stub
		manaCost =0;
		legalCastPositions[0]=false;
		legalCastPositions[1]=false;
		legalCastPositions[2]=false;
		legalCastPositions[3]=false;
		legalCastPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
		return true;
	}
	@Override
	public String getName() {
		return "wound";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+" wound";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
}
