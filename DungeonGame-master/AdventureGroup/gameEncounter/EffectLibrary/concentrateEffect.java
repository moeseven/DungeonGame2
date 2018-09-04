package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.Concentrated;

public class concentrateEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.moveBack();
		self.buffHero(new Concentrated(self));
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateBlockAmount(card.getBlock(), self)+" move back and double dexterity";
	}

}
