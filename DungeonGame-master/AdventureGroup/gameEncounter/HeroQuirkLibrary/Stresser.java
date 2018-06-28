package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Stresser extends HeroQuirk{

	public Stresser() {
		super();
		// TODO Auto-generated constructor stub
		name="stresser";
		stats.getStats()[ModableHeroStats.nameResolveStat("resistStress")]=-10;
	}
	
}
