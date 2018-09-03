package gameEncounter.CardLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class Bandage extends Spell{
	public Bandage() {
		// TODO Auto-generated constructor stub
		manaCost =1;		
	}
	public boolean applyEffect(Hero self) {
		self.getTarget().heal((int)(1+(GameEquations.spellPowerCalc(self)/2.2)));
		self.getTarget().setBleed(0);
		self.getDiscardPile().remove(this);
		return true;
	}
	@Override
	public String getName() {
		return "bandage";
	}
	public LinkedList<String> getCardText(Hero hero) {
		LinkedList<String> textList= super.getCardText(hero);
		textList.add("heals and removes bleed (single use)");
		return textList;
	}
	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return true;
	}
}
