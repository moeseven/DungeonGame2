package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class healEffect extends CardEffect{

	public healEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).heal(GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(1)), self));		
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return "heal "+GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(1)), self)+" health.";
	}

}
