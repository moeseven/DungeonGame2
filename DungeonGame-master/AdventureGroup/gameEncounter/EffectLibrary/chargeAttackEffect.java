package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class chargeAttackEffect extends CardEffect{
private int charges=0;
	public chargeAttackEffect(LinkedList<String> pars) {
		super(pars);
	}
	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		charges=0;
		while (self.moveForward()) {
			charges++;
		}
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			if(self.attackHero(self.getTargets().get(i),card)) {
				nextTargets.add(self.getTargets().get(i));
				damageTarget(self, self.getTargets().get(i), card);
			}
		}
		self.setTargets(nextTargets);
		if(nextTargets.size()>0) {
			return true;
		}else {
			return false;
		}
	}
	protected void damageTarget(Hero self, Hero target, Card_new card) {	
		int damage;
		damage= (1+charges)*GameEquations.calculateAttackDamage(card, self);
		int afterBlockDamage = GameEquations.attackIntoBlock(self, target, damage);		
		int afterArmorDamage = GameEquations.damageReducedByArmor(afterBlockDamage, target.armor);
		target.takeDamage(self, afterArmorDamage, false);
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return GameEquations.calculateAttackDamage(card, self)*(1+self.getPosition())+" physical damage (more damage with greater charge range)";
	}

}
