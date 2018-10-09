package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class Blazing extends Buff{
	int burnDamage=3;
	@Override
	public void onTick(Hero hero) {
		hero.getPlayer().getGame().log.addLine(hero.getName()+" is blazing!");
		if(hero.getPlayer().getGame().dungeonMaster.getHeroes().size()>0&&hero.getPlayer().getGame().getPlayer().getHeroes().size()>0) {
			for(int i=0;i<hero.getPlayer().getGame().dungeonMaster.getHeroes().size();i++) {
			hero.doFireDamage(GameEquations.calculateSpellDamage(burnDamage, hero), hero.getPlayer().getGame().dungeonMaster.getHeroes().get(i));
			}
			for(int i=0;i<hero.getPlayer().getGame().getPlayer().getHeroes().size();i++) {
				hero.doFireDamage(GameEquations.calculateSpellDamage(burnDamage, hero), hero.getPlayer().getGame().getPlayer().getHeroes().get(i));
			}	
		}
	}

	@Override
	public void mod(Hero hero) {
		duration=5;
		burnDamage=(int) (GameEquations.spellPowerCalc(hero)/3.0)+3;
		hero.setResistFire(hero.getResistFire()+50);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setResistFire(hero.getResistFire()-50);
	}

}
