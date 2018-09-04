package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class ArmorBuff extends Buff{
	private int armor;
	private int duration=5;
	public ArmorBuff(Hero hero, int armor) {
		this.armor=armor;
	}
	@Override
	public void onTick(Hero hero) {
		
	}

	@Override
	public void mod(Hero hero) {
		hero.setArmor(hero.getArmor()+armor);
	}

	@Override
	public void demod(Hero hero) {
		hero.setArmor(hero.getArmor()-armor);
	}

}
