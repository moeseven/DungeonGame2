package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.CardLibrary.EffectParameters;

public class EffectBuilder {

	public static CardEffect buildEffect(EffectParameters pars) {
		String name = pars.parameters.get(0);
		LinkedList<String> p = pars.parameters;
		if (name.equals("addCardToTargetDeck")) {
			return new addCardToTargetDeckEffect(p);
		}
		if (name.equals("addCardToTargetDeckSpell")) {
			return new addCardToTargetDeckSpellEffect(p);
		}
		if (name.equals("allResistSpell")) {
			return new allResistSpellEffect(p);
		}
		if (name.equals("attack")) {
			return new attackEffect(p);
		}
		if (name.equals("bash")) {
			return new bashEffect(p);
		}
		if (name.equals("blockableBleed")) {
			return new blockableBleedEffect(p);
		}
		if (name.equals("blockablePoison")) {
			return new blockablePoisonEffect(p);
		}
		if (name.equals("block")) {
			return new blockEffect(p);
		}
		if (name.equals("cardDraw")) {
			return new cardDrawEffect(p);
		}
		if (name.equals("chargeAttack")) {
			return new chargeAttackEffect(p);
		}
		if (name.equals("cleaveAttack")) {
			return new cleaveAttackEffect(p);
		}
		if (name.equals("coldSpell")) {
			return new coldSpellEffect(p);
		}
		if (name.equals("compositeCold")) {
			return new compositeColdEffect(p);
		}
		if (name.equals("compositeFire")) {
			return new compositeFireEffect(p);
		}
		if (name.equals("concentrate")) {
			return new concentrateEffect(p);
		}
		if (name.equals("cureBleed")) {
			return new cureBleedEffect(p);
		}
		if (name.equals("fireBall")) {
			return new fireBallEffect(p);
		}
		if (name.equals("fireSpell")) {
			return new fireSpellEffect(p);
		}
		if (name.equals("growingStatSpell")) {
			return new growingStatSpellEffect(p);
		}
		if (name.equals("heal")) {
			return new healEffect(p);
		}
		if (name.equals("increaseStatOfCard")) {
			return new increaseStatOfCardEffect(p);
		}
		if (name.equals("lightningSpell")) {
			return new lightningSpellEffect(p);
		}
		if (name.equals("magicSpell")) {
			return new magicSpellEffect(p);
		}
		if (name.equals("mana")) {
			return new manaEffect(p);
		}
		if (name.equals("manaBuff")) {
			return new manaBuffEffect(p);
		}
		if (name.equals("missileSpell")) {
			return new missileSpellEffect(p);
		}
		if (name.equals("modifyStat")) {
			return new modifyStatEffect(p);
		}
		if (name.equals("modifyStatSpell")) {
			return new modifyStatSpellEffect(p);
		}
		if (name.equals("move")) {
			return new moveEffect(p);
		}
		if (name.equals("penetrateArmorAttack")) {
			return new penetrateArmorAttackEffect(p);
		}
		if (name.equals("penetrateBlockAttack")) {
			return new penetrateBlockAttackEffect(p);
		}
		if (name.equals("poison")) {
			return new poisonEffect(p);
		}
		if (name.equals("ram")) {
			return new ramEffect(p);
		}
		if (name.equals("regenerationSpell")) {
			return new regenerationSpellEffect(p);
		}
		if (name.equals("resistableSpell")) {
			return new resistableSpellEffect(p);
		}
		if (name.equals("stressSpell")) {
			return new stressSpellEffect(p);
		}
		if (name.equals("targetAllAlliesOfTarget")) {
			return new targetAllAlliesOfTargetEffect(p);
		}
		if (name.equals("targetSelf")) {
			return new targetSelfEffect(p);
		}
		if (name.equals("useup")) {
			return new useupEffect(p);
		}
		System.out.println("Effectbuilder failed to resolve effect name!!!");
		return null;
	}
}
