package gameEncounter;

public class GameEquations {
	//speed calculation from dexterity and base speed
	public static int speedCalc(int baseSpeed, int dexterity) {
		return (int) (baseSpeed*(1+dexterity/20.0));
	}
	
	//health calculation from vitality and base health
	public static int maxHealthCalc(int baseHealth, int vitality) {
		return (int) (baseHealth*(1+vitality/20.0));
	}
	//dodge calculation from dexterity
	public static int dodgeCalc(int baseDodge, int dexterity) {
		return (int) (baseDodge*(1+dexterity/20.0));
	}
	//accuracy calculation from dexterity
	public static int accuracyCalc(int baseAccuracy, int dexterity) {
		return (int) (baseAccuracy*(1+dexterity/20.0));
	}
	//blockskill and attackskill calculation from str/dex
	public static int blockAttackSkillCalc(int baseBlockAttackSkill, int str, int dex) {
		return (int) (baseBlockAttackSkill*(1+dex/40.0+str/30.0));
	}
	
	
	//dodge chance calculation
	public static boolean dodge(Hero attacker, Hero attacked) {
		if(Math.random()>1/(1.1+(attacked.computeDodge()-attacker.computeAccuracy())*0.05)) {
			System.out.println(attacked.getName()+" dodged an attack!");
			return true;			
		}else {
			return false;
		}
	}
	//attack vs block roll
	public static boolean block(Hero attacker, Hero blocker) {
		int block;
		block=(int) (blocker.getBlock()-blocker.getBlock()*(attacker.computeAttackSkill()/(0.0+blocker.computeBlockSkill()+attacker.computeAttackSkill())));
		if(block>0) {
			blocker.setBlock(block);
			if(Math.random()<block/(0.0+block+attacker.computeAttackSkill())) {
				System.out.println(blocker.getName()+" blocked an attack!");
				return true;
			}else {
				return false;
			}
		}else {
			blocker.setBlock(0);
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
	public static int speedRoll(int speed) {
		return speed+(int)(Math.random()*15.0);
	}
}
