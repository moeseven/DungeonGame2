package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.ManaBonusBuff;
import gameEncounter.buffLibrary.RegenerationBuff;

public class regenerationSpellEffect extends CardEffect{

	public regenerationSpellEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new RegenerationBuff(GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(1)),self),self.getSpellDuration()));
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return  GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(1)), self)+" regeneration";
	}

}
