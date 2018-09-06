package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.ManaBonusBuff;

public class manaBuffEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		self.buffHero(new ManaBonusBuff(card.getSpellDamage(), Integer.parseInt(card.getExtra())));
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return  card.getSpellDamage()+" mana for"+card.getExtra()+"turns";
	}

}
