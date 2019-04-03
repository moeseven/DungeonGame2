package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Talented extends HeroQuirk{

	public Talented(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="talented";
		stats.getStats()[ModableHeroStats.nameResolveStat("learning")]=+15;
	}
	
}
