package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class minusArmor extends Buff{
	int armorReduction=0;
	public minusArmor(int armor) {
		super();
		duration=5;
		armorReduction=armor;
	}

	 
	@Override
	public void onTick(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setArmor(hero.getArmor()-armorReduction);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setArmor(hero.getArmor()+armorReduction);
	}

}
