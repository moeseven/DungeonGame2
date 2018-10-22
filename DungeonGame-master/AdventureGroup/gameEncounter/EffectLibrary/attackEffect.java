package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class attackEffect extends CardEffect{

	public attackEffect(LinkedList<String> pars) {
		super(pars);
	}
	@Override
	public boolean applyEffect(Hero self, Card card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			if(self.attackHero(self.getTargets().get(i),card)) {
				nextTargets.add(self.getTargets().get(i));
				damageTarget(self, self.getTargets().get(i), card);
			}
		}
		self.setTargets(nextTargets);
		if(nextTargets.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	protected void damageTarget(Hero self, Hero target, Card card) {	
		self.dealAttackDamage(target, card, false);
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return GameEquations.calculateAttackDamage(card, self)+" attack damage";
	}

}
