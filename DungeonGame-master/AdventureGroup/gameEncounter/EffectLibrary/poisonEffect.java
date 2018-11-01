package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class poisonEffect extends CardEffect{
	
	public poisonEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {			
		int poison;
		if (pars.get(1).equals("x")) {
			poison=card.getX();
		}else {
			poison=GameEquations.calculatePoisonDamage(Integer.parseInt(pars.get(1)), self);
		}
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.doPoisonDamage(poison, self.getTargets().get(i),Integer.parseInt(pars.get(2)));
			nextTargets.add(self.getTargets().get(i));	
		}
		self.setTargets(nextTargets);
		if(nextTargets.size()>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		String poison;
		if (pars.get(1).equals("x")) {
			poison="x";
		}else {
			poison=""+GameEquations.calculatePoisonDamage(Integer.parseInt(pars.get(1)), self);
		}
		int poisonChance= Integer.parseInt(pars.get(2))+self.getPoisonDmg();
		return poisonChance+"% chance for "+poison+" poison";
	}

}
