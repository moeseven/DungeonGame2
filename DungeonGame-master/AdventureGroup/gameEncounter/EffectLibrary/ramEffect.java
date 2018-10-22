package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class ramEffect extends CardEffect{

	public ramEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
			self.moveForward();
			self.moveForward();
			self.getTarget().moveBack();
			self.getTarget().moveBack();
			return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		// TODO Auto-generated method stub
		return " knocks back target, moves forward";
	}

}
