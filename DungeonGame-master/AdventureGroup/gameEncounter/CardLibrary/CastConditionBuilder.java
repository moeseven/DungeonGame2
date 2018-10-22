package gameEncounter.CardLibrary;

import java.util.LinkedList;

import gameEncounter.EffectLibrary.addCardToTargetDeckEffect;

public class CastConditionBuilder {
public static CastCondition buildCastCondition(String name) {
	if (name.equals("requiresBow")) {
		return new requiresBow();
	}
	if (name.equals("requiresShield")) {
		return new requiresShield();
	}
	if (name.equals("requiresSpaceForSummon")) {
		return new requiresSpaceForSummon();
	}
	return new requiresBow();
}
}
