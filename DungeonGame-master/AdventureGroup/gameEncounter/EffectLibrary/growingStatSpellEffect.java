package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.statGrowthBuff;
import gameEncounter.buffLibrary.statModifyBuff;

public class growingStatSpellEffect extends CardEffect{

	public growingStatSpellEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new statGrowthBuff(self.getTargets().get(i),pars.get(1), GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(2)), self), self.getSpellDuration()));	
			self.getPlayer().getGame().log.addLine(self.getTargets().get(i).getName()+" +"+pars.get(2)+" "+pars.get(1)+" every round for "+self.getSpellDuration()+" rounds");
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return "+"+pars.get(2)+" "+pars.get(1)+" every round for "+self.getSpellDuration()+" rounds";
	}

}
