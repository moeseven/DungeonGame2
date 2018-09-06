package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.ManaBonusBuff;
import gameEncounter.buffLibrary.RegenerationBuff;

public class regenerationSpellEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new RegenerationBuff(GameEquations.calculateSpellDamage(Integer.parseInt(card.getExtra()), self)));
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return  card.getExtra()+" regeneration";
	}

}
