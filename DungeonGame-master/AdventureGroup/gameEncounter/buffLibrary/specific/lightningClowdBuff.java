package gameEncounter.buffLibrary.specific;

import java.util.LinkedList;

import gameEncounter.Buff;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class lightningClowdBuff extends Buff{
	private int value;

	public lightningClowdBuff(Hero hero, int value,int duration) {
		this.value=value;
		this.duration=duration;
	}
	@Override
	public void onTick(Hero hero) {
		LinkedList<Hero> targets;
		if (hero.getPlayer()==hero.getPlayer().getGame().getPlayer()) {
			targets=hero.getFight().getMonsters();
		}else {
			targets=hero.getFight().getHeroes();
		}
		int random= (int) (Math.random()*targets.size()); 
		hero.doLightningDamage(value, targets.get(random));
	}

	@Override
	public void mod(Hero hero) {
	}

	@Override
	public void demod(Hero hero) {
		hero.getPlayer().getGame().log.addLine("lightning clowd buff ended");
	}
	@Override
	public Hero onBeeingTargeted(Hero hero) {
		// TODO Auto-generated method stub
		return hero;
	}

}
