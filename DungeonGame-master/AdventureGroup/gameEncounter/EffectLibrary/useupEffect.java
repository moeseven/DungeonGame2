package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class useupEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.getDiscardPile().remove(card);
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return "useup";
	}

}
