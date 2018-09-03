package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class bashEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.getTarget().takeStun();
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return "bash";
	}

}
