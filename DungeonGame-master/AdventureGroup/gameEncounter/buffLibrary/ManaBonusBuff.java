package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class ManaBonusBuff extends Buff{
	private int duration;
	private int bonus;
	public ManaBonusBuff(int bonus, int duration) {
		this.bonus=bonus;
		this.duration=duration;
	}
	@Override
	public void mod(Hero hero) {
		hero.setManaPower(hero.getManaPower()+bonus);
		
	}

	@Override
	public void demod(Hero hero) {
		hero.setManaPower(hero.getManaPower()-bonus);
		
	}

	@Override
	public void onTick(Hero hero) {

	}
	

}
