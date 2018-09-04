package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class SubstanceAbuser extends HeroQuirk{

	public SubstanceAbuser(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="substance abuser";
		stats.getStats()[ModableHeroStats.nameResolveStat("resistPoison")]=10;
		stats.getStats()[ModableHeroStats.nameResolveStat("resistStress")]=-7;
		stats.getStats()[ModableHeroStats.nameResolveStat("health")]=-10;
	}
	
}
