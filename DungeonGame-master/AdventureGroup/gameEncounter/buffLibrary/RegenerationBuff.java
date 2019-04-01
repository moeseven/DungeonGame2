package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class RegenerationBuff extends Buff{
	private int regen;
	public RegenerationBuff(int regen, int duration) {
		this.regen=regen;
		this.duration=duration;
	}
	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demod(Hero hero) {
		hero.getPlayer().getGame().log.addLine("regeneration buff ended");
		
	}

	@Override
	public void onTick(Hero hero) {
		hero.heal(regen);
	}
	@Override
	public Hero onBeeingTargeted(Hero hero) {
		// TODO Auto-generated method stub
		return hero;
	}
	

}
