package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class blockableBleedEffect extends CardEffect{
	
	public blockableBleedEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {	
		//attacks only apply bleed if block is down!
		for (int i = 0; i < self.getTargets().size(); i++) {
			if (self.getTargets().get(i).getBlock()<=0) {
				self.doBleedDamage(GameEquations.calculateBleedDamage(Integer.parseInt(pars.get(1)), self), self.getTargets().get(i));
			}
		}
		return true;				
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return GameEquations.calculateBleedDamage(Integer.parseInt(pars.get(1)), self)+" bleed";
	}

}
