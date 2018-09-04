package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class penetrateBlockAttackEffect extends attackEffect{

	protected void damageTarget(Hero self, Hero target, Card_new card) {
		int damage=GameEquations.rollForCrit(self, card, GameEquations.calculateAttackDamage(card, self));			
		int afterArmor = GameEquations.damageReducedByArmor(damage, target.armor);
		target.takeDamage(self, afterArmor, false);
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateAttackDamage(card, self)+" unblockable attack damage";
	}

}
