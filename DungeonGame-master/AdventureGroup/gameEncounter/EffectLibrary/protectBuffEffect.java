package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.GuardedBuff;
import gameEncounter.buffLibrary.addCardsToHandBuff;

public class protectBuffEffect extends CardEffect{

	public protectBuffEffect(LinkedList<String> pars) {
		super(pars);
		//1: duration
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {			
			nextTargets.add(self.getTargets().get(i));
			self.getTargets().get(i).buffHero(new GuardedBuff(self, Integer.parseInt(pars.get(1))));			
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
		return "Redirects attacks on the target to self for "+pars.get(1)+" rounds.";
	}

}
