package gameEncounter.HeroQuirkLibrary;

import java.util.LinkedList;

import game.Game;
import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.Hero;
import gameEncounter.HeroQuirk;
import gameEncounter.ModableHeroStats;
import gameEncounter.CardLibrary.EffectParameters;
import gameEncounter.EffectLibrary.EffectBuilder;

public class Sleeper extends HeroQuirk{
	CardEffect effect;
	public Sleeper(Game game) {
		super(game);
		EffectParameters pars = new EffectParameters("addCardToTargetDeck,sleepy,2");		
		effect = EffectBuilder.buildEffect(pars);
		name="sleeper";
	}

	@Override
	public void mod(Hero hero) {
		super.mod(hero);
		hero.addStartOfFightEffect(effect);
	}

	@Override
	public void demod(Hero hero) {
		super.demod(hero);
		hero.removeStartOfFightEffect(effect);
	}
	
}
