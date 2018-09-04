package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Tough extends HeroQuirk{

	public Tough(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="tough";
		stats.getStats()[ModableHeroStats.nameResolveStat("health")]=5;
	}
	
}
