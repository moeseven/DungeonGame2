package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class healEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			//heals scale with vitality
			self.getTargets().get(i).heal((int)(card.getSpellDamage()*self.getVitality()/20.0));		
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return "heal "+(int)(card.getSpellDamage()*self.getVitality()/20.0)+" health.";
	}

}
