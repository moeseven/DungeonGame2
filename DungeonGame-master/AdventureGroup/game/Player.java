package game;

import java.io.Serializable;
import java.util.LinkedList;

import game.RoomInteractionLibrary.ItemOnGround;
import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Item;

public class Player implements Serializable{
	private Hero selectedHero;
	private int points=0;
	private Quest activeQuest;
	protected LinkedList<Hero> heroes;
	private LinkedList<Item> inventory;
	protected int inventoryCapacity;
	private LinkedList<Hero> availableHeroes;
	protected int groupSize;
	private Game game;
	private int gold;
	public Player(Game game) {
		this.game=game;
		heroes=new LinkedList<Hero>();
		availableHeroes=new LinkedList<Hero>();
		inventoryCapacity=100;
		inventory=new LinkedList<Item>();
		gold=200;
		groupSize=3;
	}
	public void gainGold(int g) {
		gold+=g;
		if(g>0) {
			game.log.addLine("gained "+g+" gold.");
		}else {
			game.log.addLine("lost "+(-g)+" gold.");
		}
		
	}
	public boolean addHero(Hero hero) {// do not exeed maximum size
		if(heroes.size()<groupSize) {
			for(int a=0; a<heroes.size();a++) {// prevent equal names
				for(int b=0; b<heroes.size();b++) {
					if(heroes.get(b).getName().equals(hero.getName())) {
						hero.setName(hero.getName()+" I");
					}
				}
			}
			heroes.addFirst(hero);
//			hero.setInventory(inventory);
			hero.setPlayer(this);
			selectedHero=hero;
			return true;
		}else {
			return false;
		}
	}
	public void removeHeroFromTavern(Hero hero) {
		if(availableHeroes.size()>=1&&availableHeroes.contains(hero)) {
			availableHeroes.remove(hero);
			hero.setPlayer(null);
		}
	}
	public void removeDeadHeroesFromRoster() {
		LinkedList<Hero> deadHeroes=new LinkedList<Hero>();
		for(int i=0; i<heroes.size();i++) {
			if(heroes.get(i).isDead()) {
				deadHeroes.add(heroes.get(i));
			}
		}
		for(int i=0; i<deadHeroes.size();i++) {
			heroes.remove(deadHeroes.get(i));
		}
	}
	public void removeHero(Hero hero) {
		if(heroes.size()>=1&&heroes.contains(hero)) {
			heroes.remove(hero);
			hero.setPlayer(null);
//			hero.setInventory(new LinkedList<Item>());
		}
	}
	public void addMultipleItemsToInventory(LinkedList<Item> items) {
		//remove items form source and add to player inventory if there is space
		LinkedList<Item> itemsTaken=new LinkedList<Item>();
		for(int a=0;a<items.size();a++) {
			addItemtoInventory(items.get(a));	
			itemsTaken.add(items.get(a));
		}
		for(int a=0;a<itemsTaken.size();a++) {
			items.remove(itemsTaken.get(a));
		}
	}
	public boolean addItemtoInventory(Item item) {
		boolean success;
		int totalWeight=item.getWeight();
		for(int i=0; i<inventory.size();i++) {
			totalWeight+=inventory.get(i).getWeight();
		}
		if(totalWeight>inventoryCapacity) {
			game.log.addLine("party is overburdened!");
			game.getRoom().getInteractions().add(new ItemOnGround(game,item, game.getRoom()));
			success=false;
		}else {
			game.log.addLine(item.getName()+" added to inventory.");
			inventory.add(item);
			success=true;
		}
		return success;
	}
	public void dropItemOnFloor(Item item) {
		if(inventory.contains(item)) {
			inventory.remove(item);
			game.getRoom().getInteractions().add(new ItemOnGround(game,item,game.getRoom()));
			game.log.addLine(item.getName()+" dropped!");
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Quest getActiveQuest() {
		return activeQuest;
	}
	public void setActiveQuest(Quest activeQuest) {
		this.activeQuest = activeQuest;
	}
	public int getGroupSize() {
		return groupSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	
}
