package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class SlugBrained extends HeroQuirk{

	public SlugBrained(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="slug brained";
		stats.getStats()[ModableHeroStats.nameResolveStat("speed")]=-4;
		stats.getStats()[ModableHeroStats.nameResolveStat("intelligence")]=-4;
	}
	
}
