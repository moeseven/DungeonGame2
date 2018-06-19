package game;

import java.util.LinkedList;

import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ModableHeroStats;

public abstract class CharacterType {
	protected String name;
	protected LinkedList<Item> items= new LinkedList<Item>();
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
