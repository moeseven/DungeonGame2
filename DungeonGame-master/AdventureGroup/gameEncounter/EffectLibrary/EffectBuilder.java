package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;

public class EffectBuilder {

	public static CardEffect buildEffect(String name) {
		CardEffect retVal=null;
		if (name.equals("attack")) {
			retVal = new attackEffect();
		}
		if (name.equals("bash")) {
			retVal = new bashEffect();
		}
		if (name.equals("block")) {
			retVal = new blockEffect();
		}
		if (name.equals("cleaveAttack")) {
			retVal = new cleaveAttackEffect();
		}
		if (name.equals("fireSpell")) {
			retVal = new fireSpellEffect();
		}
		if (name.equals("minusArmor")) {
			retVal = new minusArmorEffect();
		}
		if (name.equals("penetrateBlockAttack")) {
			retVal = new penetrateBlockAttackEffect();
		}
		if (name.equals("useup")) {
			retVal = new useupEffect();
		}
		if (retVal==null) {
			System.out.println("Effectbuilder failed to resolve effect name!!!");
		}
		return retVal;
	}
}
