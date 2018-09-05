package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class poisonEffect extends CardEffect{
	
	@Override
	public boolean applyEffect(Hero self, Card_new card) {	
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			if (self.getTargets().get(i).poison(card.getSpellDamage())) {
				nextTargets.add(self.getTargets().get(i));
			}	
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
		return card.getSpellDamage()+" poison";
	}

}
