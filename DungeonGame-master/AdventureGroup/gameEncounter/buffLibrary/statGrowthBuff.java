package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class statGrowthBuff extends Buff{
	private int value;
	private String stat;
	private int growingStatValue;
	public statGrowthBuff(Hero hero, String stat, int value,int duration) {
		growingStatValue=0;
		this.value=value;
		this.stat=stat;
		this.duration=duration;
	}
	@Override
	public void onTick(Hero hero) {
		growingStatValue+=value;
		hero.modifyStat(stat, value);
	}

	@Override
	public void mod(Hero hero) {
		growingStatValue=0;
	}

	@Override
	public void demod(Hero hero) {
		hero.modifyStat(stat, -growingStatValue);
	}

}
