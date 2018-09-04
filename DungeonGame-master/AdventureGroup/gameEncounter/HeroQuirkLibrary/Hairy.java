package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Hairy extends HeroQuirk{

	public Hairy(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="hairy";
		stats.getStats()[ModableHeroStats.nameResolveStat("resistCold")]=10;
		stats.getStats()[ModableHeroStats.nameResolveStat("resistFire")]=-5;
	}
	
}
