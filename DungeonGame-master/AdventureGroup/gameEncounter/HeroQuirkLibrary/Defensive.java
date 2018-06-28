package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Defensive extends HeroQuirk{

	public Defensive() {
		super();
		// TODO Auto-generated constructor stub
		name="defensive";
		stats.getStats()[ModableHeroStats.nameResolveStat("attack")]=-3;
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=+3;
	}
	
}
