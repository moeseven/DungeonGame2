package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Weak extends HeroQuirk{

	public Weak(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="weak";
		stats.getStats()[ModableHeroStats.nameResolveStat("strength")]=-3;
	}
	
}
