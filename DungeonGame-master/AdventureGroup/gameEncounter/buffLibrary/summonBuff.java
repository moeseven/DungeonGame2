package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class summonBuff extends Buff{

	public summonBuff(Hero hero,int duration) {
		this.duration=duration;
		
		hero.setSummon(true);
	}
	@Override
	public void onTick(Hero hero) {

	}

	@Override
	public void mod(Hero hero) {

	}

	@Override
	public void demod(Hero hero) {
		hero.getPlayer().getGame().log.addLine(hero.getName()+" dissipates.");
		hero.setDead(true);
		hero.getPlayer().removeHero(hero);		
	}

}
