package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Defensive extends HeroQuirk{

	public Defensive(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="defensive";
		stats.getStats()[ModableHeroStats.nameResolveStat("attack")]=-3;
		stats.getStats()[ModableHeroStats.nameResolveStat("block")]=+3;
	}
	
}
