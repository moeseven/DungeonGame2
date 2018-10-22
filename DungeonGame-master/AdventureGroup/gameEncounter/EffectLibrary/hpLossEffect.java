package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class hpLossEffect extends CardEffect{

	public hpLossEffect(LinkedList<String> pars) {
		super(pars);
	}
	@Override//hp loss based on vitality
	public boolean applyEffect(Hero self, Card card) {
		self.finalDamage((int) (Integer.parseInt(pars.get(1))*(1+self.getVitality()/20.0)));
		return true;
	}


	@Override
	public String generateCardText(Hero self, Card card) {
		return "loose "+(int) (Integer.parseInt(pars.get(1))*(1+self.getVitality()/20.0))+" health.";
	}

}
