package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class allResistBuff extends Buff{
	private int resist;
	public allResistBuff(Hero hero, int resist, int duration) {
		this.resist=resist;
		this.duration=duration;
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
		hero.getPlayer().getGame().log.addLine("all resist modification ended");
	}

}
