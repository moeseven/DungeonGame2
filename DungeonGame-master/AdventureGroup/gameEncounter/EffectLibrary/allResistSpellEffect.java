package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.allResistBuff;

public class allResistSpellEffect extends CardEffect{

	public allResistSpellEffect(LinkedList<String> pars) {
		super(pars);
		// 1:resistence reduction
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.getTarget().buffHero(new allResistBuff(self.getTarget(),GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(1)), self)));
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(1)), self)+" to all resistances";
	}

}
