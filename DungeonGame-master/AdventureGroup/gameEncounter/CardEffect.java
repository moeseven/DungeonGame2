package gameEncounter;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class CardEffect implements Serializable{
	protected LinkedList<String> pars;
	public CardEffect(LinkedList<String> pars) {
		super();
		this.pars=pars;
	}
	public abstract boolean applyEffect(Hero self, Card card);
	public abstract String generateCardText(Hero self, Card card);
}
