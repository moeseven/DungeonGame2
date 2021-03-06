package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class compositeFireEffect extends CardEffect{
	
	public compositeFireEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {	
		for (int i = 0; i < self.getTargets().size(); i++) {	
				self.doFireDamage(card.getAttackDamage()*Integer.parseInt(pars.get(1))/100, self.getTargets().get(i));
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "+"+Integer.parseInt(pars.get(1))+"% fire damage";
	}

}
