package gameEncounter.EffectLibrary;

import java.util.LinkedList;

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
	public boolean applyEffect(Hero self, Card_new card) {
		for(int i=0; i<Integer.parseInt(pars.get(1)); i++) {
			self.drawCard();
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return "Draw "+pars.get(1)+" cards";
	}

}
