package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class cardDrawEffect extends CardEffect{

	public cardDrawEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		int draws;
		if (pars.get(1).equals("x")) {
			draws=card.getX();
		}else {
			draws= Integer.parseInt(pars.get(1));
		}
		for(int i=0; i<draws; i++) {
			self.drawCard();
		}
		self.getPlayer().getGame().log.addLine(self.getName()+" draws "+draws+" cards");
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "Draw "+pars.get(1)+" cards";
	}

}
