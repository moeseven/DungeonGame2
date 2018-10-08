package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class penetrateArmorAttackEffect extends attackEffect{

	public penetrateArmorAttackEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	protected void damageTarget(Hero self, Hero target, Card_new card) {
		int damage=GameEquations.calculateAttackDamage(card, self);		
		int afterBlock = GameEquations.attackIntoBlock(self, target, damage);
		target.takeDamage(self, afterBlock, false);
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateAttackDamage(card, self)+" armor penetrating attack damage";
	}

}
