package gameEncounter.CardLibrary;

import gameEncounter.Hero;

public abstract class CastCondition {
	public String explanation;
	public abstract boolean checkCondition(Hero hero);
}
