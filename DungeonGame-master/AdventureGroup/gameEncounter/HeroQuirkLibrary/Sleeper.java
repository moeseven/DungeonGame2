package gameEncounter.HeroQuirkLibrary;

import game.Game;
import gameEncounter.Card;
import gameEncounter.Card_new;
import gameEncounter.Hero;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;

public class Sleeper extends HeroQuirk{
	private Card card;
	public Sleeper(Game game) {
		super(game);
		card= game.cardBuilder.buildCard("sleepy");
		name="sleeper";
	}

	@Override
	public void mod(Hero hero) {
		super.mod(hero);
		hero.getDeck().addCard(card);
	}

	@Override
	public void demod(Hero hero) {
		super.demod(hero);
		hero.getDeck().getCards().remove(card);
	}
	
}
