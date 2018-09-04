package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class fireBallEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			nextTargets.add(self.getTargets().get(i));
			//roll cirts for every target			
			self.getTargets().get(i).takeFireDamage(self, GameEquations.rollForCrit(self, card, GameEquations.calculateSpellDamage((int)(card.getSpellDamage()*((1+self.getMana())*(1+self.getMana()/4.0))), self)));
			self.setMana(0);
		}
		self.setTargets(nextTargets);
		if(nextTargets.size()>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return "consumes all mana, " +GameEquations.calculateSpellDamage((int)(card.getSpellDamage()*((self.getMana())*(1+self.getMana()/4.0))), self)+" fire damage";
	}

}
