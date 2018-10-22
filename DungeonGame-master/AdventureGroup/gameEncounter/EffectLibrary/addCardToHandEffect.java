package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Hero;

public class addCardToHandEffect extends CardEffect{

	public addCardToHandEffect(LinkedList<String> pars) {
		super(pars);
		//1: cardname , 2: amount
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {			
			nextTargets.add(self.getTargets().get(i));
			for (int j = 0; j < Integer.parseInt(pars.get(2)); j++) {
				self.getTargets().get(i).getHand().add(self.getPlayer().getGame().cardBuilder.buildCard(pars.get(1)));				
			}
			self.getPlayer().getGame().log.addLine("added "+pars.get(2)+" "+pars.get(1)+" to "+self.getTargets().get(i).getName()+" hand");			
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
		return "adds "+pars.get(2)+" "+pars.get(1)+" to the targets hand";
	}

}
