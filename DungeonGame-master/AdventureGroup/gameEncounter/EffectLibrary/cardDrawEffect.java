package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class cardDrawEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for(int i=0; i<card.getSpellDamage(); i++) {
			self.drawCard();
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return "Draw "+card.getSpellDamage()+" cards";
	}

}
