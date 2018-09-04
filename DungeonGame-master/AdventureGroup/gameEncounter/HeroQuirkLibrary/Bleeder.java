package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Bleeder extends HeroQuirk{

	public Bleeder(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="bleeder";
		stats.getStats()[ModableHeroStats.nameResolveStat("resistBleed")]=-10;
	}
	
}
