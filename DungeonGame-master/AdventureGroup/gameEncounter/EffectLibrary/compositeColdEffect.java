package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class compositeColdEffect extends CardEffect{
	
	public compositeColdEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {	
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.doColdDamage(card.getAttackDamage()*Integer.parseInt(pars.get(1))/100, self.getTargets().get(i));
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return Integer.parseInt(pars.get(1))/100+" cold damage";
	}

}
