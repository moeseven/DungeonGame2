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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTick(Hero hero) {
		hero.setMana(hero.getMana()+bonus);
		hero.getPlayer().getGame().log.addLine("+"+bonus+" mana");
	}
	

}
