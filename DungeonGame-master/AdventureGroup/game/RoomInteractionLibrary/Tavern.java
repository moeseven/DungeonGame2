package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.RoomInteraction;
import gameEncounter.Hero;


public class Tavern extends RoomInteraction{
	private LinkedList<Hero> heroes=new LinkedList<Hero>();
	public Tavern() {
		super();
		name="tavern";

	}

	@Override
	public void onEnter(Game game) {
		// TODO Auto-generated method stub
		heroes=game.getPlayer().getAvailableHeroes();
	}

	@Override
	public void onInteraction(Hero hero) {
		// TODO Auto-generated method stub
		//setup tavern here
		hero.getPlayer().getGame().getRoom().setTavern(this);
		hero.getPlayer().getGame().getRoom().setTavernOpen(true);
	}

	public LinkedList<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(LinkedList<Hero> heroes) {
		this.heroes = heroes;
	}

}
