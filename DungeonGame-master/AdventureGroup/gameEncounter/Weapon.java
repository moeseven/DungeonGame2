package gameEncounter;

import java.util.LinkedList;

public abstract class Weapon extends Item{
	protected double facStr;
	protected  int baseDamage;
	protected int damageRange;
	protected int weaponRange;
	public int computeAttackDamage(int strength) {
		return Math.max(GameEquations.FistDamage(strength),(int) ((baseDamage+damageRange*Math.random())*(1+facStr*strength)*GameEquations.RequirementsPenaltyWeapon(strength, requiredStrength)));
	}
	public String AttackDamageToString(int strength) {
		return ""+(int) (baseDamage*(1+facStr*strength)*GameEquations.RequirementsPenaltyWeapon(strength, requiredStrength))+"-"+(int)((baseDamage+damageRange)*(1+facStr*strength)*GameEquations.RequirementsPenaltyWeapon(strength, requiredStrength));
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
