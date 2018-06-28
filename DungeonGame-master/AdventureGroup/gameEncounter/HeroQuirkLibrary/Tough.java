package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Tough extends HeroQuirk{

	public Tough() {
		super();
		// TODO Auto-generated constructor stub
		name="tough";
		stats.getStats()[ModableHeroStats.nameResolveStat("health")]=5;
	}
	
}
