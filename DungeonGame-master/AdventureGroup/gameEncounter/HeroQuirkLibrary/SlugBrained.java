package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class SlugBrained extends HeroQuirk{

	public SlugBrained() {
		super();
		// TODO Auto-generated constructor stub
		name="slug brained";
		stats.getStats()[ModableHeroStats.nameResolveStat("speed")]=-4;
		stats.getStats()[ModableHeroStats.nameResolveStat("intelligence")]=-4;
	}
	
}
