package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class bashEffect extends CardEffect{

	public bashEffect(LinkedList<String> pars) {
		super(pars);
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.getTarget().takeStun();
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return "bash";
	}

}
