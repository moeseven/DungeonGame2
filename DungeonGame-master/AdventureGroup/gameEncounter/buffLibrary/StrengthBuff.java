package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class StrengthBuff extends Buff{
	private int strength;
	private int duration=5;
	public StrengthBuff(Hero hero, int strength) {
		this.strength=strength;
	}
	@Override
	public void onTick(Hero hero) {
		
	}

	@Override
	public void mod(Hero hero) {
		hero.setStrength(hero.getStrength()+strength);
	}

	@Override
	public void demod(Hero hero) {
		hero.setStrength(hero.getStrength()-strength);
	}

}
