package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.statModifyBuff;

public class modifyStatEffect extends CardEffect{

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new statModifyBuff(self.getTargets().get(i),card.getExtra(), Integer.parseInt(card.getExtra2()), 5));	
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		return card.getExtra2()+" "+card.getExtra();
	}

}
