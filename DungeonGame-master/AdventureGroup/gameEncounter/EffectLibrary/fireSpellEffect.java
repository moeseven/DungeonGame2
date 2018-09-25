package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class fireSpellEffect extends CardEffect{

	public fireSpellEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			nextTargets.add(self.getTargets().get(i));
			//roll cirts for every target
			self.doFireDamage(GameEquations.rollForCrit(self, card, GameEquations.calculateSpellDamage(card.getSpellDamage(), self)), self.getTargets().get(i));
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
		return GameEquations.calculateSpellDamage(card.getSpellDamage(), self)+" fire damage";
	}

}
