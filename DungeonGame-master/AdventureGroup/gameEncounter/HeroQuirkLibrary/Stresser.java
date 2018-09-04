package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Stresser extends HeroQuirk{

	public Stresser(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="stresser";
		stats.getStats()[ModableHeroStats.nameResolveStat("resistStress")]=-10;
	}
	
}
