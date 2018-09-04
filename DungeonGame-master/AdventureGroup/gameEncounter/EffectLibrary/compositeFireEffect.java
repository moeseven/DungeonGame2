package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class compositeFireEffect extends CardEffect{
	
	@Override
	public boolean applyEffect(Hero self, Card_new card) {	
		for (int i = 0; i < self.getTargets().size(); i++) {
				self.getTargets().get(i).takeFireDamage(self, card.getAttackDamage()*card.getSpellDamage()/100);	
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return card.getSpellDamage()/100+" fire damage";
	}

}
