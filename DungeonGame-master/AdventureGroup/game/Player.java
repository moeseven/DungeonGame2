package game;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Player {
	private Hero selectedHero;
	private LinkedList<Hero> heroes;
	private LinkedList<Item> inventory;
	public Player(Game game) {
		heroes=new LinkedList<Hero>();
		inventory=new LinkedList<Item>();
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
	public LinkedList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(LinkedList<Item> inventory) {
		this.inventory = inventory;
	}
	
}
