package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class penetrateBlockAttackEffect extends attackEffect{

	public penetrateBlockAttackEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	protected void damageTarget(Hero self, Hero target, Card card) {
		int damage=GameEquations.calculateAttackDamage(card, self);			
		int afterArmor = GameEquations.damageReducedByArmor(damage, target.armor);
		target.takeDamage(self, afterArmor, false);
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateAttackDamage(card, self)+" unblockable attack damage";
	}

}
