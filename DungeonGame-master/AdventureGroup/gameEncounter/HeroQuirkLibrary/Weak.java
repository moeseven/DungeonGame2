package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Weak extends HeroQuirk{

	public Weak() {
		super();
		// TODO Auto-generated constructor stub
		name="weak";
		stats.getStats()[ModableHeroStats.nameResolveStat("strength")]=-3;
	}
	
}
