package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.allResistBuff;

public class allResistSpellEffect extends CardEffect{

	public allResistSpellEffect(LinkedList<String> pars) {
		super(pars);
		// 1:resistence reduction
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new allResistBuff(self.getTarget(),GameEquations.calculateSpellColdDamage(Integer.parseInt(pars.get(1)), self),self.getSpellDuration()));
			self.getPlayer().getGame().log.addLine(self.getTargets().get(i).getName()+" gets "+GameEquations.calculateSpellColdDamage(Integer.parseInt(pars.get(1)), self)+" to all resistances for "+self.getSpellDuration()+"rounds");
			nextTargets.add(self.getTargets().get(i));
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
		return GameEquations.calculateSpellColdDamage(Integer.parseInt(pars.get(1)), self)+" to all resistances";
	}

}
