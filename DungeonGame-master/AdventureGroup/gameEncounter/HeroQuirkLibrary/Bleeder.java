package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Bleeder extends HeroQuirk{

	public Bleeder() {
		super();
		// TODO Auto-generated constructor stub
		name="bleeder";
		stats.getStats()[ModableHeroStats.nameResolveStat("resistBleed")]=-10;
	}
	
}
