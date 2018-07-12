package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Thoughtfull extends HeroQuirk{

	public Thoughtfull() {
		super();
		// TODO Auto-generated constructor stub
		name="thoughtfull";
		stats.getStats()[ModableHeroStats.nameResolveStat("spell")]=+1;
		stats.getStats()[ModableHeroStats.nameResolveStat("speed")]=-1;
	}
	
}
