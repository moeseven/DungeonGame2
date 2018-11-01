package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class blockablePoisonEffect extends CardEffect{
	
	public blockablePoisonEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {	
		//attacks only apply poison if block is down!
		for (int i = 0; i < self.getTargets().size(); i++) {
			if (self.getTargets().get(i).getBlock()<=0) {
				self.doPoisonDamage(GameEquations.calculatePoisonDamage(Integer.parseInt(pars.get(1)), self), self.getTargets().get(i),Integer.parseInt(pars.get(2)));
			}
		}
		return true;	
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		int poisonChance= Integer.parseInt(pars.get(2))+self.getPoisonDmg();
		return poisonChance+"% chance for "+GameEquations.calculatePoisonDamage(Integer.parseInt(pars.get(1)), self)+" poison if block is down";
	}

}
