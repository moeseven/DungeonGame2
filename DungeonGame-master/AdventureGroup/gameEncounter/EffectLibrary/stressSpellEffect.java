package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class stressSpellEffect extends CardEffect{

	public stressSpellEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).becomeStressed(GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(1)), self));
		}		
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return "stress target for "+GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(1)),self)+" stress";
	}

}
