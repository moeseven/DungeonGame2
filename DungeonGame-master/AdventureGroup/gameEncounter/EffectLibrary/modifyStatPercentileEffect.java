package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.Hero;
import gameEncounter.buffLibrary.statModifyBuff;

public class modifyStatPercentileEffect extends CardEffect{

	public modifyStatPercentileEffect(LinkedList<String> pars) {
		super(pars);
		assert pars.size()>2;
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		for (int i = 0; i < self.getTargets().size(); i++) {
			self.getTargets().get(i).buffHero(new statModifyBuff(self.getTargets().get(i),pars.get(1), (int) (self.getTargets().get(i).getStatValueFromString(pars.get(i))*Integer.parseInt(pars.get(2))/100.0), self.getSpellDuration()));	
			self.getPlayer().getGame().log.addLine(self.getTargets().get(i).getName()+" "+pars.get(2)+"% "+pars.get(1)+" for "+self.getSpellDuration()+" rounds");
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return pars.get(2)+"% "+pars.get(1)+" for "+self.getSpellDuration()+" rounds";
	}

}
