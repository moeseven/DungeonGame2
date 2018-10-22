package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class cardsPlayedThisRoundAttackEffect extends CardEffect{
	private int attackDamagePerCardPlayed;
	public cardsPlayedThisRoundAttackEffect(LinkedList<String> pars) {
		super(pars);
		attackDamagePerCardPlayed=Integer.parseInt(pars.get(1));
	}
	@Override
	public boolean applyEffect(Hero self, Card card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		card.setAttackDamage(attackDamagePerCardPlayed*self.getCardsPlayedThisRound());
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
	protected void damageTarget(Hero self, Hero target, Card card) {	
		self.dealAttackDamage(target, card, false);
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return attackDamagePerCardPlayed+" damage for every card played ("+(int) (attackDamagePerCardPlayed*self.getCardsPlayedThisRound()*(1+(GameEquations.attackSkillCalc(self))/100.0))+")";
	}

}
