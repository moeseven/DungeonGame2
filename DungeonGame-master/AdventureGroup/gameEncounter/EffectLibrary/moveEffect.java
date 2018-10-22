package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class moveEffect extends CardEffect{

	public moveEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			nextTargets.add(self.getTargets().get(i));
			if (Integer.parseInt(pars.get(1))>0) {
				for (int j = 0; j < Integer.parseInt(pars.get(1)); j++) {
					self.getTargets().get(i).moveForward();
				}
			}else {
				for (int j = 0; j < -Integer.parseInt(pars.get(1)); j++) {
					self.getTargets().get(i).moveBack();
				}			
			}
		}
		self.setTargets(nextTargets);
		if(nextTargets.size()>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		if (Integer.parseInt(pars.get(1))>0) {
			return " moves target "+pars.get(1)+ " forward.";
		}else {
			return " moves target "+(Integer.parseInt(pars.get(1))*-1)+ " backwards.";
		}
		
	}

}
