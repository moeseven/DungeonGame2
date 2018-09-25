package gameEncounter.CardLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.EffectLibrary.EffectBuilder;

public class EffectParameters {
	public LinkedList<String>	parameters;
	public EffectParameters(String effectString) {
		super();
		this.parameters = new LinkedList<String>();
		String[] splitted =effectString.split("\\,");
		for (int i = 0; i < splitted.length; i++) {
			parameters.add(splitted[i]);
			System.out.println(splitted[i]);
		}
		
				
	}
	

}
