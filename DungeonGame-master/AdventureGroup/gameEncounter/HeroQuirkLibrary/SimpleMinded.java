package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class SimpleMinded extends HeroQuirk{

	public SimpleMinded(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
		name="simple minded";
		stats.getStats()[ModableHeroStats.nameResolveStat("draw")]=-1;
		stats.getStats()[ModableHeroStats.nameResolveStat("resistSpell")]=25;
		stats.getStats()[ModableHeroStats.nameResolveStat("speed")]=1;
	}
	
}
