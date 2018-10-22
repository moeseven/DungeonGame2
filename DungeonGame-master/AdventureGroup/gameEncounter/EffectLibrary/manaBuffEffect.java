package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.ManaBonusBuff;

public class manaBuffEffect extends CardEffect{

	public manaBuffEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		self.buffHero(new ManaBonusBuff(Integer.parseInt(pars.get(1)), Integer.parseInt(pars.get(2))));
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		// TODO Auto-generated method stub
		return  pars.get(1)+" mana for"+pars.get(2)+"turns";
	}

}
