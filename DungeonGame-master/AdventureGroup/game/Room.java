package game;

import java.io.Serializable;
import java.util.LinkedList;

import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Tavern;
import gameEncounter.Fight;
import gameEncounter.Hero;

public abstract class Room implements Serializable{
	protected boolean hasFight;
	protected boolean shopOpen;
	protected boolean tavernOpen;
	protected Shop shop;
	protected Tavern tavern;
	protected Fight fight;
	protected boolean readyToLeave;
	protected LinkedList<Hero> heroes;
	private LinkedList<RoomInteraction> interactions;
	public Room() {
		interactions=new LinkedList<RoomInteraction>();
	}
	public void initialize() {
		readyToLeave=false;
	}
	public void prepareRoomAndEnter(Game game) {
		
		for(int i=0; i<interactions.size();i++) {
			interactions.get(i).onEnter(game);
		}
		enterRoom(game);
	}
	public abstract void enterRoom(Game game);
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
	
}
