package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Tender extends HeroQuirk{

	public Tender() {
		super();
		// TODO Auto-generated constructor stub
		name="tender";
		stats.getStats()[ModableHeroStats.nameResolveStat("health")]=-6;
	}
	
}
