package gameEncounter.CardLibrary;

import java.util.LinkedList;

import gameEncounter.EffectLibrary.addCardToTargetDeckEffect;

public class CastConditionBuilder {
public static CastCondition buildCastCondition(String name) {
	if (name.equals("requiresBow")) {
		return new requiresBow();
	}
	return new requiresBow();
}
}