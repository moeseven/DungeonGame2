package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class allResistBuff extends Buff{
	private int resist;
	private int duration=5;
	public allResistBuff(Hero hero, int resist) {
		this.resist=resist;
	}
	@Override
	public void onTick(Hero hero) {
		
	}

	@Override
	public void mod(Hero hero) {
		hero.setResistFire(hero.getResistFire()+resist);
		hero.setResistCold(hero.getResistCold()+resist);
		hero.setResistPoison(hero.getResistPoison()+resist);
		hero.setResistLightning(hero.getResistLightning()+resist);
		hero.setResistStun(hero.getResistStun()+resist);
		hero.setResistStress(hero.getResistStress()+resist);
	}

	@Override
	public void demod(Hero hero) {
		hero.setResistFire(hero.getResistFire()-resist);
		hero.setResistCold(hero.getResistCold()-resist);
		hero.setResistPoison(hero.getResistPoison()-resist);
		hero.setResistLightning(hero.getResistLightning()-resist);
		hero.setResistStun(hero.getResistStun()-resist);
		hero.setResistStress(hero.getResistStress()-resist);
	}

}
