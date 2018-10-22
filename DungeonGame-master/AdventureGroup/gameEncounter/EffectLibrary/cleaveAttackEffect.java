package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class cleaveAttackEffect extends attackEffect{

	public cleaveAttackEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		boolean success=false;
		if(self.attackHero(self.getTarget(),card)) {
			damageTarget(self, self.getTarget(), card);
			success = true;
		}
		if(self.getTarget().getPlayer().getHeroes().size()>self.getTarget().getPlayer().getHeroes().indexOf(self.getTarget())+1) {
			Hero secondTarget=self.getTarget().getPlayer().getHeroes().get(self.getTarget().getPlayer().getHeroes().indexOf(self.getTarget())+1);
			self.setNewTarget(secondTarget);
			if(self.attackHero(self.getTarget(),card)) {				
				damageTarget(self, self.getTarget(), card);
				success=true;
			}
		}
		return success;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateAttackDamage(card, self)+" attack damage on target and behind";
	}

}
