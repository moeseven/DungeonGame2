package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.Blazing;

public class Blaze extends SpellnoTarget{
	public Blaze() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		legalPositions[0]=true;
	}
	public boolean applyEffect(Hero self) {
		self.buffHero(new Blazing());
		return true;
	}
	@Override
	public String getName() {
		return "blaze";
	}
	@Override
	public String getCardText() {
		return super.getCardText()+"deals fire damage every round to everybody";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 10;
	}
	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return true;
	}
}
