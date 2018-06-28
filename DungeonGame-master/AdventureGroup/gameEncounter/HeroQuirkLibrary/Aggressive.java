package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Aggressive extends HeroQuirk{

	public Aggressive() {
		super();
		// TODO Auto-generated constructor stub
		name="aggressive";
		stats.getStats()[ModableHeroStats.nameResolveStat("attack")]=+3;
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=-3;
	}
	
}
