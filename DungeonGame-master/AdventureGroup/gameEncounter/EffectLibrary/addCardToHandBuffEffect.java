package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.addCardsToHandBuff;

public class addCardToHandBuffEffect extends CardEffect{

	public addCardToHandBuffEffect(LinkedList<String> pars) {
		super(pars);
		//1: cardname , 2: amount
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {			
			nextTargets.add(self.getTargets().get(i));
			self.getTargets().get(i).buffHero(new addCardsToHandBuff(self, pars.get(1), Integer.parseInt(pars.get(2))));			
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
		return "adds "+pars.get(2)+" "+pars.get(1)+" to the targets hand for "+self.getSpellDuration()+" rounds.";
	}

}
