package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class DivineGrace extends Card{
	public DivineGrace() {
		// TODO Auto-generated constructor stub
		manaCost =2;		
	}
	public void applyEffect(Hero self) {
		self.getTarget().heal((int)(2+(self.computeSpellPower()/1.1)));
		self.getDiscardPile().remove(this);
	}
	@Override
	public String getName() {
		return "divine grace";
	}
	@Override
	public String getCardText(Hero self) {
		return "heal target for "+(int)(9+(self.computeSpellPower()/1.5));
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
