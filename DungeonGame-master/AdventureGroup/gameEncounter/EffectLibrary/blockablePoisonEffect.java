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
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			if (self.getTargets().get(i).getBlock()<=0) {
				self.doPoisonDamage(Integer.parseInt(pars.get(1)), self.getTargets().get(i));
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
		// TODO Auto-generated method stub
		return Integer.parseInt(pars.get(1))+" poison";
	}

}
