package game;

import java.io.Serializable;
import java.util.LinkedList;

import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Tavern;
import game.characterTypeLibrary.TypeArcher;
import game.characterTypeLibrary.TypeWarrior;
import game.monsters.RaceGoblin;
import gameEncounter.Fight;
import gameEncounter.Hero;

public abstract class Room implements Serializable{
	protected boolean hasFight;
	protected LinkedList<Hero> monsters=new LinkedList<Hero>();
	protected boolean shopOpen;
	protected boolean tavernOpen;
	protected Shop shop;
	protected Tavern tavern;
	protected Fight fight;
	protected boolean readyToLeave;
	protected Game game;
	protected LinkedList<Hero> heroes;
	private LinkedList<RoomInteraction> interactions=new LinkedList<RoomInteraction>();
	public Room(Game game) {
		this.game=game;
	}
	public void initialize() {
		readyToLeave=false;
	}
	public void prepareRoomAndEnter(Game game) {
		
		for(int i=0; i<interactions.size();i++) {
			interactions.get(i).onEnter(game);
		}
		enterRoom();
	}
	public void enterRoom() {
		if(hasFight) {
			game.dungeonMaster.setHeroes(new LinkedList<Hero>());
			for(int i=0; i<monsters.size();i++) {
				game.dungeonMaster.addHero(monsters.get(i));
			}
			this.fight= new Fight(game,game.dungeonMaster.getHeroes(), game.getPlayer().getHeroes());
		}
	}
	//here the room is set up//food consumption//torch level
	
	public Fight getFight() {
		if(hasFight) {
			return fight;
		}else {return null;}
	}
	public boolean isHasFight() {
		return hasFight;
	}
	public void setHasFight(boolean hasFight) {
		this.hasFight = hasFight;
	}
	public LinkedList<RoomInteraction> getInteractions() {
		return interactions;
	}
	public void setInteractions(LinkedList<RoomInteraction> interactions) {
		this.interactions = interactions;
	}
	public boolean isShopOpen() {
		return shopOpen;
	}
	public void setShopOpen(boolean shopOpen) {
		this.shopOpen = shopOpen;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public boolean isTavernOpen() {
		return tavernOpen;
	}
	public void setTavernOpen(boolean tavernOpen) {
		this.tavernOpen = tavernOpen;
	}
	public Tavern getTavern() {
		return tavern;
	}
	public void setTavern(Tavern tavern) {
		this.tavern = tavern;
	}
	public LinkedList<Hero> getMonsters() {
		return monsters;
	}
	public void setMonsters(LinkedList<Hero> monsters) {
		this.monsters = monsters;
	}
	
}
