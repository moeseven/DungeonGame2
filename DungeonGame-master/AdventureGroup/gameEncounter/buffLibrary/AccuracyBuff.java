package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class AccuracyBuff extends Buff{
	private int accuracy;
	public AccuracyBuff(Hero hero, int accuracy) {
		this.accuracy=accuracy;
		duration=5;
	}
	@Override
	public void onTick(Hero hero) {
		
	}

	@Override
	public void mod(Hero hero) {
		hero.setArmor(hero.getArmor()+accuracy);
	}

	@Override
	public void demod(Hero hero) {
		hero.setArmor(hero.getArmor()-accuracy);
	}

}
