package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class Concentrated extends Buff{
	private int doubleDex=0;
	public Concentrated(Hero hero) {
		doubleDex=hero.getDexterity();
		duration=5;
	}
	@Override
	public void onTick(Hero hero) {
		
	}

	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setDexterity(hero.getDexterity()+doubleDex);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setDexterity(hero.getDexterity()-doubleDex);
	}

}
