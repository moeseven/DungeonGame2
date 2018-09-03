package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class fireSpellEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		if(self.castMissileSpellOnHero(self.getTarget(),card)) {	
			damageTarget(self, self.getTarget(), card);
			return true;
		}else {
			return false;
		}
	}
	protected void damageTarget(Hero self, Hero target, Card_new card) {
		self.getTarget().takeFireDamage(self, GameEquations.calculateSpellDamage(card.getSpellDamage(), self));
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateSpellDamage(card.getSpellDamage(), self)+" fire damage";
	}

}
