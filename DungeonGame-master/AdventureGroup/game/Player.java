package game;

import java.io.Serializable;
import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Player implements Serializable{
	private Hero selectedHero;
	private LinkedList<Hero> heroes;
	private LinkedList<Item> inventory;
	private LinkedList<Hero> availableHeroes;
	private Game game;
	private int gold;
	public Player(Game game) {
		this.game=game;
		heroes=new LinkedList<Hero>();
		availableHeroes=new LinkedList<Hero>();
		inventory=new LinkedList<Item>();
		gold=0;
	}
	public void addHero(Hero hero) {// do not exeed maximum size
		if(heroes.size()<4) {
			heroes.add(hero);
			hero.setInventory(inventory);
			hero.setPlayer(this);
			selectedHero=hero;
		}
	}
	public void removeHero(Hero hero) {
		if(heroes.size()>=1&&heroes.contains(hero)) {
			heroes.remove(hero);
			hero.setPlayer(null);
			hero.setInventory(new LinkedList<Item>());
		}
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
	public LinkedList<Hero> getAvailableHeroes() {
		return availableHeroes;
	}
	public void setAvailableHeroes(LinkedList<Hero> availableHeroes) {
		this.availableHeroes = availableHeroes;
	}
	
}
