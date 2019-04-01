package gameEncounter;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class GeneralEffect implements Serializable{
	protected LinkedList<String> pars;
	public GeneralEffect(LinkedList<String> pars) {
		super();
		this.pars=pars;
	}
	public abstract boolean applyEffect(Hero self);
}
