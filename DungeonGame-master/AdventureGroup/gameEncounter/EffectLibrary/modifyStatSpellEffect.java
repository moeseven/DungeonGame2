package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.statModifyBuff;

public class modifyStatSpellEffect extends CardEffect{

	public modifyStatSpellEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new statModifyBuff(self.getTargets().get(i),pars.get(1), GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(2)), self), self.getSpellDuration()));	
			self.getPlayer().getGame().log.addLine(self.getTargets().get(i).getName()+" "+GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(2)), self)+" "+pars.get(1)+" for "+self.getSpellDuration()+" rounds");
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(2)), self)+" "+pars.get(1)+"for "+self.getSpellDuration()+" rounds";
	}

}
