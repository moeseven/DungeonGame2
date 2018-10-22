package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.ManaBonusBuff;
import gameEncounter.buffLibrary.RegenerationBuff;

public class regenerationSpellEffect extends CardEffect{

	public regenerationSpellEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>1;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new RegenerationBuff(GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(1)),self),self.getSpellDuration()));
			self.getPlayer().getGame().log.addLine(self.getTargets().get(i).getName()+" gets +"+GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(1)), self)+" regeneration");
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return  GameEquations.calculateSpellMagicDamage(Integer.parseInt(pars.get(1)), self)+" regeneration";
	}

}
