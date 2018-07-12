package gameEncounter.HeroQuirkLibrary;

import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class SimpleMinded extends HeroQuirk{

	public SimpleMinded() {
		super();
		// TODO Auto-generated constructor stub
		name="simple minded";
		stats.getStats()[ModableHeroStats.nameResolveStat("draw")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("resistSpell")]=1;
		stats.getStats()[ModableHeroStats.nameResolveStat("speed")]=1;
	}
	
}
