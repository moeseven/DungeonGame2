package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Hasty extends HeroQuirk{

	public Hasty() {
		super();
		// TODO Auto-generated constructor stub
		name="hasty";
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=-3;
		stats.getStats()[ModableHeroStats.nameResolveStat("spell")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("speed")]=+2;
	}
	
}
