package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Hasty extends HeroQuirk{

	public Hasty(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="hasty";
		stats.getStats()[ModableHeroStats.nameResolveStat("accuracy")]=-3;
		stats.getStats()[ModableHeroStats.nameResolveStat("spell")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("speed")]=+2;
	}
	
}
