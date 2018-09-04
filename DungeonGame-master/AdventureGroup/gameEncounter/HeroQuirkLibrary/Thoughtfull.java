package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Thoughtfull extends HeroQuirk{

	public Thoughtfull(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="thoughtfull";
		stats.getStats()[ModableHeroStats.nameResolveStat("spell")]=+1;
		stats.getStats()[ModableHeroStats.nameResolveStat("speed")]=-1;
	}
	
}
