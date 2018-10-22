package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class fireBallEffect extends CardEffect{

	public fireBallEffect(LinkedList<String> pars) {
		super(pars);
	}
	//X card!
	@Override
	public boolean applyEffect(Hero self, Card card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			nextTargets.add(self.getTargets().get(i));
			self.doFireDamage(GameEquations.calculateSpellFireDamage((int)(card.getSpellDamage()*card.getX()),self), self.getTargets().get(i));
			//increase burn
			self.getTargets().get(i).setFire(self.getTargets().get(i).getFire()*(card.getX()));
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
		// TODO Auto-generated method stub
		return GameEquations.calculateSpellFireDamage((int)(card.getSpellDamage()*self.getMana()), self)+" fire damage and enhanced burning";
	}

}
