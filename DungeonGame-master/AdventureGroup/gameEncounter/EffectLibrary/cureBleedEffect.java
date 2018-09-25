package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class cureBleedEffect extends CardEffect{

	public cureBleedEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).setBleed(0);
		}		
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return "cures bleed";
	}

}
