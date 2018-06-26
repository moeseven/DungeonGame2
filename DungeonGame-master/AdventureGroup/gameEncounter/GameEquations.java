package gameEncounter;

public class GameEquations {
	//all the attribute bonus calculation SUBJECT to CHANGE
	
	//speed calculation from dexterity and base speed
	public static int speedCalc(int baseSpeed, int dexterity) {
		return (int) (baseSpeed*(1+dexterity/20.0));
	}
	
	//health calculation from vitality and base health
	public static int maxHealthCalc(int baseHealth, int vitality) {
		return (int) (baseHealth*(1+vitality/20.0));
	}
	//dodge calculation from dexterity (same as accuracy calc)
	public static int dodgeCalc(int baseDodge, int dexterity) {
		return (int) (baseDodge*(1+dexterity/20.0));
	}
	//damage factor from strength and dexterity
	public static double damageBonus(double strfac,int strength, int dexterity) {
		return 1+(strfac*strength+(1-strfac)*dexterity)/30;
	}
	//blockskill and attackskill calculation from str/dex
	public static int blockAttackSkillCalc(int baseBlockAttackSkill, int str, int dex) {
		return (int) (baseBlockAttackSkill*(1+dex/40.0+str/30.0));
	}
	//spellpower calculation from intelligence
	public static int spellPowerCalc(int baseSpellPower, int intelligence) {
		return (int) (baseSpellPower*(1+intelligence/20.0));
	}
	
	//spell resist calculation
	public static boolean resist(Hero caster, Hero target) {
		if(Math.random()>1/(1.1+(target.computeSpellResist()-caster.computeSpellPower())*0.05)) {
			
			caster.getPlayer().getGame().log.addLine(target.getName()+" resisted!");
			return true;			
		}else {
			return false;
		}
	}
	
	//dodge chance calculation
	public static boolean dodge(Hero attacker, Hero attacked) {
		if(Math.random()>1/(1.1+(attacked.computeDodge()-attacker.computeAccuracy())*0.05)) {
			
			attacked.getPlayer().getGame().log.addLine(attacked.getName()+" dodged!");
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
				attacker.getPlayer().getGame().log.addLine(blocker.getName()+" blocked!");
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
		return (int) ((1+2*Math.random())*(1+0.3*strength));
	}
	public static String FistDamageToString(int strength, int dexterity) {
		return ""+(int)((1*(1+0.3*strength)))+"-"+(int)(3*(1+0.3*strength));
	}
	
	//requirement penalties (maybe remove this and just don't allow equipping if requirement is not matched)
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
	public static int experienceThresholdForLevelUp(int level) {
		if(level==0) {
			return 100;
		}else {
			return experienceThresholdForLevelUp(level-1)+100*level;
		}		
	}
}
