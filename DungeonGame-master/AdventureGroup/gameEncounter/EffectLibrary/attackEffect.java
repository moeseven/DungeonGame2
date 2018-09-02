package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.Hero;

public class attackEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		if(self.attackHero(self.getTarget())) {
			self.dealAttackDamage(self.getTarget(),card.getAttackDamage());
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return "attack damage";
	}

}
