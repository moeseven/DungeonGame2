package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class OneEyed extends HeroQuirk{

	public OneEyed() {
		super();
		// TODO Auto-generated constructor stub
		name="one eyed";
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=-2;
	}
	
}
