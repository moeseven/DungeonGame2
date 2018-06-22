package game;

import java.io.Serializable;
import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public abstract class CharacterType implements Serializable{
	protected String name;
	protected LinkedList<Item> items= new LinkedList<Item>();
	protected LinkedList<Card> cards= new LinkedList<Card>();
	protected ModableHeroStats stats;
	public CharacterType() {
		// TODO Auto-generated constructor stub
	}
	public abstract void modifyHero(Hero hero);
	public abstract String getInfo();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
