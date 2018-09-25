package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class addCardToTargetDeckEffect extends CardEffect{

	public addCardToTargetDeckEffect(LinkedList<String> pars) {
		super(pars);
		//1: cardname , 2: amount
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {			
			nextTargets.add(self.getTargets().get(i));
			for (int j = 0; j < Integer.parseInt(pars.get(2)); j++) {
				self.getTargets().get(i).getDiscardPile().add(self.getPlayer().getGame().cardBuilder.buildCard(pars.get(1)));
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
	public String generateCardText(Hero self, Card_new card) {
		return "adds "+pars.get(2)+" "+pars.get(1)+" to the targets discard pile";
	}

}
