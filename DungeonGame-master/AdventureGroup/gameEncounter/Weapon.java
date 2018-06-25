package gameEncounter;

import java.util.LinkedList;

public abstract class Weapon extends Item{
	protected double facStr;
	protected  int baseDamage;
	protected int damageRange;
	protected int weaponRange;
	public int computeAttackDamage(int strength, int dexterity) {
		return (int) ((baseDamage+damageRange*Math.random())*GameEquations.damageBonus(facStr, strength, dexterity));
	}
	public String AttackDamageToString(int strength, int dexterity) {
		return ""+(int)(baseDamage*GameEquations.damageBonus(facStr, strength, dexterity))+"-"+(int)((baseDamage+damageRange)*GameEquations.damageBonus(facStr, strength, dexterity));
	}
	public void generateItemDescription() {
		super.generateItemDescription();
		description.add("damage: "+baseDamage+"-"+(baseDamage+damageRange));
	}
	public int getWeaponRange() {
		return weaponRange;
	}
	public void setWeaponRange(int weaponRange) {
		this.weaponRange = weaponRange;
	} 
	
}
