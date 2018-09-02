package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.Hero;

public class blockEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.block(card.getBlock());
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return "gain"+"block";
	}

}
