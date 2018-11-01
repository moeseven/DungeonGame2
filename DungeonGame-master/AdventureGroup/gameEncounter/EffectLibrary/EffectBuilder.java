package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.CardLibrary.EffectParameters;

public class EffectBuilder {

	public static CardEffect buildEffect(EffectParameters pars) {
		String name = pars.parameters.get(0);
		LinkedList<String> p = pars.parameters;
		switch (name) {
        case "addCardToHandBuff":
        	return new addCardToHandBuffEffect(p);
        case "addCardToHand":
        	return new addCardToHandEffect(p);
        case "addCardToTargetDeck":
        	return new addCardToTargetDeckEffect(p);
        case "addCardToTargetDeckSpell":
        	return new addCardToTargetDeckSpellEffect(p);  
        case "allResistSpell":
        	return new allResistSpellEffect(p);      
        case "attack":
        	return new attackEffect(p);   
        case "bash":
        	return new bashEffect(p); 
        case "blockableBleed":
        	return new blockableBleedEffect(p);
        case "blockablePoison":
        	return new blockablePoisonEffect(p);
        case "block":
        	return new blockEffect(p);
        case "cardDraw":
        	return new cardDrawEffect(p);
        case "chargeAttack":
        	return new chargeAttackEffect(p);
        case "cleaveAttack":
        	return new cleaveAttackEffect(p);
        case "compositeCold":
        	return new compositeColdEffect(p);
        case "compositeFire":
        	return new compositeFireEffect(p);
        case "cureBleed":
        	return new cureBleedEffect(p);
        case "delayedCombustion":
        	return new delayedCombustionEffect(p);
        case "discardHand":
        	return new discardHandEffect(p);
        case "fireSpell":
        	return new fireSpellEffect(p);
        case "growingStatSpell":
        	return new growingStatSpellEffect(p);
        case "heal":
        	return new healEffect(p);
        case "hpLoss":
        	return new hpLossEffect(p);
        case "increaseStatOfCard":
        	return new increaseStatOfCardEffect(p);
        case "lightningClowd":
        	return new lightningClowdEffect(p);
        case "mana":
        	return new manaEffect(p);
        case "missileSpell":
        	return new missileSpellEffect(p);
        case "modifyStat":
        	return new modifyStatEffect(p);
        case "modifyStatOneTurn":
        	return new modifyStatOneTurnEffect(p);        	
        case "modifyStatOneTurnSpell":
        	return new modifyStatOneTurnSpellEffect(p);
        case "modifyStatPercentile":
        	return new modifyStatPercentileEffect(p);
        case "modifyStatSpell":
        	return new modifyStatSpellEffect(p);
        case "move":
        	return new moveEffect(p);
        case "penetrateArmorAttack":
        	return new penetrateArmorAttackEffect(p);
        case "penetrateBlockAttack":
        	return new penetrateBlockAttackEffect(p);
        case "poison":
        	return new poisonEffect(p);
        case "ram":
        	return new ramEffect(p);
        case "regenerationSpell":
        	return new regenerationSpellEffect(p);
        case "resistableSpell":
        	return new resistableSpellEffect(p);
        case "setX":
        	return new setXEffect(p);
        case "spellDamage":
        	return new spellDamageEffect(p);
        case "stressSpell":
        	return new stressSpellEffect(p);
        case "summon":
        	return new summonEffect(p);
        case "targetAllAlliesOfTarget":
        	return new targetAllAlliesOfTargetEffect(p);
        case "targetRandomAllyOfTarget":
        	return new targetRandomAllyOfTargetEffect(p);
        case "targetSelf":
        	return new targetSelfEffect(p);
        case "useup":
        	return new useupEffect(p);
        case "useupHand":
        	return new useupHandEffect(p);
        default:
        	throw new IllegalArgumentException("Invalid argument: "+name+", no such effect!");		
		}
	}
}
