package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.AccuracyBuff;
import gameEncounter.buffLibrary.ArmorBuff;
import gameEncounter.buffLibrary.StrengthBuff;

public class accuracyEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new AccuracyBuff(self.getTargets().get(i),card.getSpellDamage()));	
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return card.getSpellDamage()+" accuracy";
	}

}
