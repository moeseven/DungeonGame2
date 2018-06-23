package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Wisdom extends Card{
	public Wisdom() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public void applyEffect(Hero self) {
		for(int i=0; i<3; i++) {
			self.drawCard();
		}		
	}
	@Override
	public String getName() {
		return "wisdom";
	}
	@Override
	public String getCardText(Hero self) {
		return "draw 3 cards";
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
