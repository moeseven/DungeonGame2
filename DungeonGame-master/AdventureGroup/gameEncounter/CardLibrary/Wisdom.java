package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Wisdom extends SpellnoTarget{
	public Wisdom() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		legalCastPositions[0]=false;
	}
	public boolean applyEffect(Hero self) {
		for(int i=0; i<4; i++) {
			self.drawCard();
		}
		return true;
	}
	@Override
	public String getName() {
		return "wisdom";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"draw 4 cards";
	}

	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return true;
	}
}
