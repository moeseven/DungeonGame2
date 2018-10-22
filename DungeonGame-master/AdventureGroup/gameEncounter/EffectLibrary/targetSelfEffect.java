package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class targetSelfEffect extends CardEffect{

	public targetSelfEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		//switches target to self
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		nextTargets.add(self);
		self.setTargets(nextTargets);
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "self";
	}

}
