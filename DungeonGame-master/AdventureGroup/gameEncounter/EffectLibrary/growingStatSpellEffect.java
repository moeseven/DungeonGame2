package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.statGrowthBuff;
import gameEncounter.buffLibrary.statModifyBuff;

public class growingStatSpellEffect extends CardEffect{

	public growingStatSpellEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>3;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new statGrowthBuff(self.getTargets().get(i),pars.get(1), GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(2)), self,pars.get(3)), self.getSpellDuration()));	
			self.getPlayer().getGame().log.addLine(self.getTargets().get(i).getName()+" +"+GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(2)),self,pars.get(3))+" "+pars.get(1)+" every round for "+self.getSpellDuration()+" rounds");
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "+"+GameEquations.calculateSpellDamage(Integer.parseInt(pars.get(2)),self,pars.get(3))+" "+pars.get(1)+" every round for "+self.getSpellDuration()+" rounds ("+pars.get(3)+")";
	}

}
