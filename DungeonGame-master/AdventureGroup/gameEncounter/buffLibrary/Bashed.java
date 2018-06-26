package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class Bashed extends Buff{

	@Override
	public void onTick(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setManaPower(hero.getManaPower()-1);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setManaPower(hero.getManaPower()+1);
	}

}
