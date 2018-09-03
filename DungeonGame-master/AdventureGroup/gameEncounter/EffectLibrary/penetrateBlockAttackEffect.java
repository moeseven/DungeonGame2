package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class penetrateBlockAttackEffect extends attackEffect{

	protected void damageTarget(Hero self, Hero target, Card_new card) {
		target.takeArmorDamage(self,GameEquations.calculateAttackDamage(card.getAttackDamage(), self),false);
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateAttackDamage(card.getAttackDamage(), self)+" unblockable attack damage";
	}

}