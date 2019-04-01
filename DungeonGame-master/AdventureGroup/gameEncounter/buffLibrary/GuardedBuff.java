package gameEncounter.buffLibrary;

import java.util.LinkedList;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class GuardedBuff extends Buff{
	//redirect attacks against the protector
	private Hero protector;
	public GuardedBuff(Hero hero, int duration) {
		this.protector=hero;
		this.duration=duration;
	}
	@Override
	public void onTick(Hero hero) {
		// TODO Auto-generated method stub
		
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
	public Hero onBeeingTargeted(Hero targeter) {
		return protector;
	}

}
