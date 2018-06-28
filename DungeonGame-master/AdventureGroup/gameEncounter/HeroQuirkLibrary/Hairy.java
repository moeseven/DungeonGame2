package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Hairy extends HeroQuirk{

	public Hairy() {
		super();
		// TODO Auto-generated constructor stub
		name="hairy";
		stats.getStats()[ModableHeroStats.nameResolveStat("resistCold")]=10;
		stats.getStats()[ModableHeroStats.nameResolveStat("resistFire")]=-5;
	}
	
}
