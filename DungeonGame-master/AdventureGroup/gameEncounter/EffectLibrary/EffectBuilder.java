package gameEncounter.EffectLibrary;

import gameEncounter.CardEffect;

public class EffectBuilder {

	public static CardEffect buildEffect(String name) {
		if (name.equals("addCardToTargetDeck")) {
			return new addCardToTargetDeckEffect();
		}
		if (name.equals("allResistSpell")) {
			return new allResistSpellEffect();
		}
		if (name.equals("attack")) {
			return new attackEffect();
		}
		if (name.equals("bash")) {
			return new bashEffect();
		}
		if (name.equals("blockableBleed")) {
			return new blockableBleedEffect();
		}
		if (name.equals("blockablePoison")) {
			return new blockablePoisonEffect();
		}
		if (name.equals("block")) {
			return new blockEffect();
		}
		if (name.equals("cardDraw")) {
			return new cardDrawEffect();
		}
		if (name.equals("cleaveAttack")) {
			return new cleaveAttackEffect();
		}
		if (name.equals("coldSpell")) {
			return new coldSpellEffect();
		}
		if (name.equals("compositeCold")) {
			return new compositeColdEffect();
		}
		if (name.equals("compositeFire")) {
			return new compositeFireEffect();
		}
		if (name.equals("concentrate")) {
			return new concentrateEffect();
		}
		if (name.equals("cureBleed")) {
			return new cureBleedEffect();
		}
		if (name.equals("fireBall")) {
			return new fireBallEffect();
		}
		if (name.equals("fireSpell")) {
			return new fireSpellEffect();
		}
		if (name.equals("heal")) {
			return new healEffect();
		}
		if (name.equals("lightningSpell")) {
			return new lightningSpellEffect();
		}
		if (name.equals("manaBuff")) {
			return new manaBuffEffect();
		}
		if (name.equals("missileSpell")) {
			return new missileSpellEffect();
		}
		if (name.equals("modifyStat")) {
			return new modifyStatEffect();
		}
		if (name.equals("modifyStatSpell")) {
			return new modifyStatSpellEffect();
		}
		if (name.equals("penetrateArmorAttack")) {
			return new penetrateArmorAttackEffect();
		}
		if (name.equals("penetrateBlockAttack")) {
			return new penetrateBlockAttackEffect();
		}
		if (name.equals("poison")) {
			return new poisonEffect();
		}
		if (name.equals("ram")) {
			return new ramEffect();
		}
		if (name.equals("regenerationSpell")) {
			return new regenerationSpellEffect();
		}
		if (name.equals("resistableSpell")) {
			return new resistableSpellEffect();
		}
		if (name.equals("targetAllAlliesOfTarget")) {
			return new targetAllAlliesOfTargetEffect();
		}
		if (name.equals("targetSelf")) {
			return new targetSelfEffect();
		}
		if (name.equals("useup")) {
			return new useupEffect();
		}
		System.out.println("Effectbuilder failed to resolve effect name!!!");
		return null;
	}
}
