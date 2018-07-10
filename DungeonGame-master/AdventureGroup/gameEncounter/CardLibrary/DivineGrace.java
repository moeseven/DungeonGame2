package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class DivineGrace extends Spell{
	public DivineGrace() {
		// TODO Auto-generated constructor stub
		manaCost =2;		
	}
	public boolean applyEffect(Hero self) {
		self.getTarget().heal((int)(4+(self.computeSpellPower()/1.4)));
		return true;
	}
	@Override
	public String getName() {
		return "divine grace";
	}
	@Override
	public String getCardText() {
		return super.getCardText()+"heals target";
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
