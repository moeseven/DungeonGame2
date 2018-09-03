package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class cleaveAttackEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		boolean success=false;
		if(self.attackHero(self.getTarget(),card)) {
			damageTarget(self, self.getTarget(), card);
			success = true;
		}
		if(self.getTarget().getPlayer().getHeroes().size()>self.getTarget().getPlayer().getHeroes().indexOf(self.getTarget())+1) {
			Hero secondTarget=self.getTarget().getPlayer().getHeroes().get(self.getTarget().getPlayer().getHeroes().indexOf(self.getTarget())+1);
			self.setTarget(secondTarget);
			if(self.attackHero(self.getTarget(),card)) {				
				damageTarget(self, self.getTarget(), card);
				success=true;
			}
		}
		return success;
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
