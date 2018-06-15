package game;

import gameEncounter.Hero;
import gameEncounter.ModableHeroStats;

public abstract class CharacterType {
	protected String name;
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
