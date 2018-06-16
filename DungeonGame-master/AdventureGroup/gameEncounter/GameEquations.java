package gameEncounter;

public class GameEquations {
	
	//health calculation from vitality and base health
	public static int maxHealthCalc(int baseHealth, int vitality) {
		return (int) (baseHealth*(1+vitality/20.0));
	}
	
	//dodge chance calculation
	public static boolean dodge(Hero attacker, Hero attacked) {
		if(Math.random()>1/(1.1+(attacked.dexterity-attacker.dexterity)*0.05)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	//damage reduction by armor
	public static int damageReducedByArmor(int damage, int armor) {
		return (int) (damage/(1+armor/100.0));
	}
	
	//unarmed fist damage
	public static int FistDamage(int strength) {
		return (int) ((1+2*Math.random())*(1+0.5*strength));
	}
	public static String FistDamageToString(int strength, int dexterity) {
		return ""+(int)((1*(1+0.5*strength+0.1*dexterity)))+"-"+(int)(3*(1+0.5*strength+0.1*dexterity));
	}
	
	//requirement penalties
	public static double RequirementsPenaltyWeapon(int strength, int requiredStrength) {
		double str=strength/(double)requiredStrength;
		return Math.min(1,str);
	}
	public static int RequirementsPenaltyArmor(int strength, int requiredStrength, int dexterity) {
		//TODO difficult to handle think of something else
		double str=strength/(double)requiredStrength;
		return (int)(dexterity*Math.min(1,str));
	}
}
