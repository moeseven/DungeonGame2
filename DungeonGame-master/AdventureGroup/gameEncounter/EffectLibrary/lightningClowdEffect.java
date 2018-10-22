package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.lightningClowdBuff;

public class lightningClowdEffect extends CardEffect{

	public lightningClowdEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		self.buffHero(new lightningClowdBuff(self,GameEquations.calculateSpellLightningDamage(card.getSpellDamage(), self),self.getSpellDuration()));
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return GameEquations.calculateSpellLightningDamage(card.getSpellDamage(), self)+" lightning damage to random enemy for "+self.getSpellDuration()+" rounds";
	}

}
