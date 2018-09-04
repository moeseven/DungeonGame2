package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Tender extends HeroQuirk{

	public Tender(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="tender";
		stats.getStats()[ModableHeroStats.nameResolveStat("health")]=-6;
	}
	
}
