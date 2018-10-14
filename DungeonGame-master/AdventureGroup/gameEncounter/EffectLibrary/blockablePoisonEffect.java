package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class blockablePoisonEffect extends CardEffect{
	
	public blockablePoisonEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {	
		//attacks only apply poison if block is down!
		for (int i = 0; i < self.getTargets().size(); i++) {
			if (self.getTargets().get(i).getBlock()<=0) {
				self.doPoisonDamage(GameEquations.calculatePoisonDamage(Integer.parseInt(pars.get(1)), self), self.getTargets().get(i));
			}
		}
		return true;	
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculatePoisonDamage(Integer.parseInt(pars.get(1)), self)+" poison";
	}

}
