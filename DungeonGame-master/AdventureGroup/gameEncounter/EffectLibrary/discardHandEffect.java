package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class discardHandEffect extends CardEffect{

	public discardHandEffect(LinkedList<String> pars) {
		super(pars);
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		self.discardHand();
		self.getPlayer().getGame().log.addLine(self.getName()+" discards Hand");
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "discard hand";
	}

}
