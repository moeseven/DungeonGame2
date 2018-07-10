package gameEncounter.buffLibrary;

import gameEncounter.Buff;
import gameEncounter.Hero;

public class Blazing extends Buff{
	int burnDamage=3;
	@Override
	public void onTick(Hero hero) {
		// TODO Auto-generated method stub
		hero.getPlayer().getGame().log.addLine(hero.getName()+" is blazing!");
		if(hero.getPlayer().getGame().dungeonMaster.getHeroes().size()>0&&hero.getPlayer().getGame().getPlayer().getHeroes().size()>0) {
			for(int i=0;i<hero.getPlayer().getGame().dungeonMaster.getHeroes().size();i++) {
			hero.getPlayer().getGame().dungeonMaster.getHeroes().get(i).takeFireDamage(hero, burnDamage);
			}
			for(int i=0;i<hero.getPlayer().getGame().getPlayer().getHeroes().size();i++) {
				hero.getPlayer().getGame().getPlayer().getHeroes().get(i).takeFireDamage(hero, burnDamage);
			}	
		}
	}

	@Override
	public void mod(Hero hero) {
		// TODO Auto-generated method stub
		duration=5;
		burnDamage=(int) (hero.computeSpellPower()/3.0)+3;
		hero.setResistFire(hero.getResistFire()+50);
	}

	@Override
	public void demod(Hero hero) {
		// TODO Auto-generated method stub
		hero.setResistFire(hero.getResistFire()-50);
	}

}
