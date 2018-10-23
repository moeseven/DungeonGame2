package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Enchanter extends HeroQuirk{

	public Enchanter(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="enchanter";		
		stats.getStats()[ModableHeroStats.nameResolveStat("spellDuration")]=1;
	}
	
}
