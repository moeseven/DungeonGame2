package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Strong extends HeroQuirk{

	public Strong() {
		super();
		// TODO Auto-generated constructor stub
		name="strong";
		stats.getStats()[ModableHeroStats.nameResolveStat("strength")]=2;
	}
	
}
