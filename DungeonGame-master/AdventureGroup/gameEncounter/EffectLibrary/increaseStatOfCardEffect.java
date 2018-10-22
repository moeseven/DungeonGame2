package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class increaseStatOfCardEffect extends CardEffect{

	public increaseStatOfCardEffect(LinkedList<String> pars) {
		super(pars);
		//1: cardname , 2: amount
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {		
		Card  newCard = self.getPlayer().getGame().cardBuilder.buildCard(card.getName());	
		self.getDiscardPile().add(newCard);	
		if (pars.get(1).equals("spell")) {
			newCard.setSpellDamage(card.getSpellDamage()+Integer.parseInt(pars.get(2)));
		}else if (pars.get(1).equals("attack")) {
			newCard.setAttackDamage(card.getAttackDamage()+Integer.parseInt(pars.get(2)));
		}else if (pars.get(1).equals("block")) {
			newCard.setBlock(card.getBlock()+Integer.parseInt(pars.get(2)));
		}else {
			System.out.println("increaseStatOfCardEffect received wrong stat name!");
		}
		self.getPlayer().getGame().log.addLine("increased "+pars.get(1)+" by "+(int)GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(2)),self)+" of "+newCard.getName());			
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "increases its "+pars.get(1)+" by "+(int)GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(2)),self);
	}

}
