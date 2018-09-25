package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.statModifyBuff;

public class concentrateEffect extends CardEffect{

	public concentrateEffect(LinkedList<String> pars) {
		super(pars);
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.moveBack();
		self.buffHero(new statModifyBuff(self, "dexterity", self.getDexterity(), self.getSpellDuration()));
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return GameEquations.calculateBlockAmount(card.getBlock(), self)+" move back and double dexterity";
	}

}
