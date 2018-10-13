package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class addCardToTargetDeckSpellEffect extends CardEffect{

	public addCardToTargetDeckSpellEffect(LinkedList<String> pars) {
		super(pars);
		//1: cardname , 2: amount
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {			
			nextTargets.add(self.getTargets().get(i));
			for (int j = 0; j < (int)GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(2)),self); j++) {
				self.getTargets().get(i).getDiscardPile().add(self.getPlayer().getGame().cardBuilder.buildCard(pars.get(1)));				
			}
			self.getPlayer().getGame().log.addLine("added "+pars.get(2)+" "+pars.get(1)+" to "+self.getTargets().get(i).getName()+" discard pile");			
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
		return "adds "+(int)GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(2)),self)+" "+pars.get(1)+" to the targets discard pile";
	}

}