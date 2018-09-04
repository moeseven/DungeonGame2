package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.ArmorBuff;

public class armorSpellEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.getTarget().buffHero(new ArmorBuff(self.getTarget(),GameEquations.calculateSpellDamage(card.getSpellDamage(), self)));
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateSpellDamage(card.getSpellDamage(), self)+" armor";
	}

}
