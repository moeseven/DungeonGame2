package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class manaEffect extends CardEffect{

	public manaEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		self.setMana(self.getMana()+Integer.parseInt(pars.get(1)));
		self.getPlayer().getGame().log.addLine(self.getName()+" gain "+pars.get(1)+" mana");
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "gain "+pars.get(1)+" mana";
	}

}
