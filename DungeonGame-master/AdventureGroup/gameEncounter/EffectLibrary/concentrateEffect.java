package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.statModifyBuff;

public class concentrateEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.moveBack();
		self.buffHero(new statModifyBuff(self, "dexterity", self.getDexterity(), 4));
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return GameEquations.calculateBlockAmount(card.getBlock(), self)+" move back and double dexterity";
	}

}
