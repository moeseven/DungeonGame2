package gameEncounter.CardLibrary.Status;

import gameEncounter.Hero;
import gameEncounter.CardLibrary.SpellnoTarget;

public class Wound extends SpellnoTarget{
	public Wound() {
		// TODO Auto-generated constructor stub
		manaCost =0;
		legalPositions[0]=false;
		legalPositions[1]=false;
		legalPositions[2]=false;
		legalPositions[3]=false;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
		return true;
	}
	@Override
	public String getName() {
		return "wound";
	}
	@Override
	public String getCardText() {
		return super.getCardText()+" wound";
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
