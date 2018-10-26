package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.statModifyBuff;
import gameEncounter.buffLibrary.specific.DelayedCombustion;

public class delayedCombustionEffect extends CardEffect{

	public delayedCombustionEffect(LinkedList<String> pars) {
		super(pars);
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		self.buffHero(new DelayedCombustion(GameEquations.calculateSpellFireDamage(Integer.parseInt(pars.get(1)), self),self.getSpellDuration()));
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "increases damage by "+GameEquations.calculateSpellFireDamage(Integer.parseInt(pars.get(1)), self)+" each turn for " +self.getSpellDuration()+ "turns, then does fire damage to all enemies.";
	}

}
