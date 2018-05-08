package game;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Player {
	private Hero selectedHero;
	private LinkedList<Hero> heroes;
	public Player(Game game) {
		selectedHero=game.getHeroes().getFirst();
		heroes=game.getHeroes();
	}
	public Hero getSelectedHero() {
		return selectedHero;
	}
	public void setSelectedHero(Hero selectedHero) {
		this.selectedHero = selectedHero;
	}
	public LinkedList<Hero> getHeroes() {
		return heroes;
	}
	public void setHeroes(LinkedList<Hero> heroes) {
		this.heroes = heroes;
	}
	
}
