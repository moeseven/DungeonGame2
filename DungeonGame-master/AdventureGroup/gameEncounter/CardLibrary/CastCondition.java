package gameEncounter.CardLibrary;

import java.io.Serializable;

import gameEncounter.Hero;

public abstract class CastCondition implements Serializable{
	public String explanation;
	public abstract boolean checkCondition(Hero hero);
}
