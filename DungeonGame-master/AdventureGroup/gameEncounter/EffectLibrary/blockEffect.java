package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class blockEffect extends CardEffect{

	public blockEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		int block=GameEquations.calculateBlockAmount(card.getBlock(), self);
		if (pars.size()>1&&pars.get(2).equals("x")) {
			block=Integer.parseInt(pars.get(2));
		}
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).block(block);
		}		
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		String block=""+GameEquations.calculateBlockAmount(card.getBlock(), self);
		if (pars.size()>1&&pars.get(2).equals("x")) {
			block="x";
		}
		return block+" block";
	}

}
