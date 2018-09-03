package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class minusArmor extends Buff{
	
	public minusArmor() {
		super();
		duration=5;
	}

	int armorPenalty=0;
	@Override
	public void onTick(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		armorPenalty=hero.getArmor()/2;
		hero.setArmor(hero.getArmor()-armorPenalty);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setArmor(hero.getArmor()+armorPenalty);
	}

}
