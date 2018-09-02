package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Bandage extends Spell{
	public Bandage() {
		// TODO Auto-generated constructor stub
		manaCost =1;		
	}
	public boolean applyEffect(Hero self) {
		self.getTarget().heal((int)(1+(self.computeSpellPower()/2.2)));
		self.getTarget().setBleed(0);
		self.getDiscardPile().remove(this);
		return true;
	}
	@Override
	public String getName() {
		return "bandage";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"heals and removes bleed (single use)";
	}
	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return true;
	}
}