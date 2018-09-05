package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class ThornBuff extends Buff{
	private int thorns;
	public ThornBuff(Hero hero, int thorns) {
		this.thorns=thorns;
		duration=5;
	}
	@Override
	public void onTick(Hero hero) {
		
	}

	@Override
	public void mod(Hero hero) {
		hero.setStrength(hero.getStrength()+thorns);
	}

	@Override
	public void demod(Hero hero) {
		hero.setStrength(hero.getStrength()-thorns);
	}

}
