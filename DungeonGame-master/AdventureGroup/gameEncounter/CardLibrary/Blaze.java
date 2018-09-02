package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.Blazing;

public class Blaze extends SpellnoTarget{
	public Blaze() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		legalCastPositions[0]=true;
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
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"deals fire damage every round to everybody";
	}

	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return true;
	}
}
