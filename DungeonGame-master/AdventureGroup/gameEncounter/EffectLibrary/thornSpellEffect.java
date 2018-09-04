package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.ArmorBuff;
import gameEncounter.buffLibrary.StrengthBuff;
import gameEncounter.buffLibrary.ThornBuff;

public class thornSpellEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {					
			self.getTargets().get(i).buffHero(new ThornBuff(self.getTargets().get(i),GameEquations.calculateSpellDamage(card.getSpellDamage(), self)));
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateSpellDamage(card.getSpellDamage(), self)+" thorns";
	}

}
