package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class statModifyBuff extends Buff{
	private int value;
	private String stat;
	public statModifyBuff(Hero hero, String stat, int value,int duration) {
		this.value=value;
		this.stat=stat;
		this.duration=duration;
	}
	@Override
	public void onTick(Hero hero) {
		
	}

	@Override
	public void mod(Hero hero) {
		hero.modifyStat(stat, value);
	}

	@Override
	public void demod(Hero hero) {
		hero.modifyStat(stat, -value);
	}

}
