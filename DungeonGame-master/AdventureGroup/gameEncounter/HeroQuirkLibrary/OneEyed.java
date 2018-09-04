package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class OneEyed extends HeroQuirk{

	public OneEyed(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="one eyed";
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=-2;
	}
	
}
