package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class attackEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		if(self.attackHero(self.getTarget(),card)) {
			damageTarget(self, self.getTarget(), card);
			return true;
		}else {
			return false;
		}
	}
	protected void damageTarget(Hero self, Hero target, Card_new card) {	
		self.dealAttackDamage(target,GameEquations.rollForCrit(self, card, GameEquations.calculateAttackDamage(card.getAttackDamage(), self)));
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateAttackDamage(card.getAttackDamage(), self)+" attack damage";
	}

}
