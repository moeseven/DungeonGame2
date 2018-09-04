package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class blockablePoisonEffect extends CardEffect{
	
	@Override
	public boolean applyEffect(Hero self, Card_new card) {	
		//attacks only apply poison if block is down!
		if (self.getTarget().getBlock()<=0) {
			return self.getTarget().poison(card.getSpellDamage());
		}else {
			return false;
		}		
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return card.getSpellDamage()+" poison";
	}

}
