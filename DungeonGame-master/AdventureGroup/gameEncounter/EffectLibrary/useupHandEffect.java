package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class useupHandEffect extends CardEffect{

	public useupHandEffect(LinkedList<String> pars) {
		super(pars);
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		self.useupHand();
		self.getPlayer().getGame().log.addLine(self.getName()+" consumes Hand");
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "consumes hand";
	}

}
