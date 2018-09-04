package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Strong extends HeroQuirk{

	public Strong(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="strong";
		stats.getStats()[ModableHeroStats.nameResolveStat("strength")]=2;
	}
	
}
