package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class RegenerationBuff extends Buff{
	private int regen;
	public RegenerationBuff(int regen) {
		this.regen=regen;
		duration=5;
	}
	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTick(Hero hero) {
		hero.heal(regen);
	}
	

}
