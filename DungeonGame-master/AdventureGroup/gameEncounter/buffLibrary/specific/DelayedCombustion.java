package gameEncounter.buffLibrary.specific;

import game.DungeonMaster;
import gameEncounter.Buff;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class DelayedCombustion extends Buff{
	int burnDamage=0;
	int baseDamage=0;
	public DelayedCombustion(int burnDamage, int duration) {
		super();
		this.duration=duration;
		this.burnDamage=burnDamage;
		baseDamage=burnDamage;
	}

	@Override
	public void onTick(Hero hero) {
		burnDamage+=baseDamage;
		hero.getPlayer().getGame().log.addLine("..."+duration+"...");
		hero.getPlayer().getGame().log.addLine("delayed combustion damage increases");
	}

	@Override
	public void mod(Hero hero) {
		hero.getPlayer().getGame().log.addLine(hero.getName()+" prepares a delayed combustion");
	}

	@Override
	public void demod(Hero hero) {
		if(hero.getPlayer().getGame().dungeonMaster.getHeroes().size()>0&&hero.getPlayer().getGame().getPlayer().getHeroes().size()>0) {
			if (hero.getPlayer() instanceof DungeonMaster) {
				for(int i=0;i<hero.getPlayer().getGame().getPlayer().getHeroes().size();i++) {
					hero.doFireDamage(GameEquations.calculateSpellFireDamage(burnDamage, hero), hero.getPlayer().getGame().getPlayer().getHeroes().get(i));
				}
			}else {
				for(int i=0;i<hero.getPlayer().getGame().dungeonMaster.getHeroes().size();i++) {
					hero.doFireDamage(GameEquations.calculateSpellFireDamage(burnDamage, hero), hero.getPlayer().getGame().dungeonMaster.getHeroes().get(i));
				}
			}				
		}
	}

	@Override
	public Hero onBeeingTargeted(Hero hero) {
		// TODO Auto-generated method stub
		return hero;
	}

}
