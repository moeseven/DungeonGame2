package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;

public class EffectBuilder {

	public static CardEffect buildEffect(String name) {
		CardEffect retVal;
		if (name.equals("attack")) {
			return new attackEffect();
		}else {
			return null;
		}
	}
}
