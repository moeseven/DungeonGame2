package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.statModifyBuff;

public class concentrateEffect extends CardEffect{

	public concentrateEffect(LinkedList<String> pars) {
		super(pars);
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		self.buffHero(new statModifyBuff(self, "dexterity", self.getDexterity(), self.getSpellDuration()));
		self.getPlayer().getGame().log.addLine(self.getName()+" doubles dexterity");
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "double dexterity";
	}

}
