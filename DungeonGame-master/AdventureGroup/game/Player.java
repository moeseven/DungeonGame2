package game;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Player {
	private Hero selectedHero;
	private LinkedList<Hero> heroes;
	private LinkedList<Item> inventory;
	private Game game;
	private int gold;
	public Player(Game game) {
		this.game=game;
		heroes=new LinkedList<Hero>();
		inventory=new LinkedList<Item>();
		gold=0;
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
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
}
