package gameEncounter;

public class GameEquations {
	//all the attribute bonus calculation SUBJECT to CHANGE
	
	//////////////////////Stats//////////////////////
	// elemental and effects that change stats should be handled here
	//speed calculation from dexterity and base speed
	public static int speedCalc(Hero hero) {//effected by cold
		return (int) (hero.getSpeed()*(1+hero.getDexterity()/20.0));
	}	
	//health calculation from vitality and base health
	public static int maxHealthCalc(Hero hero) {
		return (int) (hero.getBaseHp()*(1+hero.getVitality()/20.0));
	}
	//dodge calculation from dexterity 
	public static int dodgeCalc(Hero hero) {//effected by cold
		return (int) (hero.getDodge()*(1+hero.getDexterity()/20.0));
	}
	//accuracy calculation
	public static int accuracyCalc(Hero hero) {
		return (int) (hero.getAccuracy()*(1+hero.getDexterity()/20.0));
	}
	//blockskill and attackskill calculation from str
	public static int attackSkillCalc(Hero hero) {//effected by cold
		return (int) (hero.getAttackSkill()*(1+hero.getStrength()/20.0));
	}
	public static int blockSkillCalc(Hero hero) {
		return (int) (hero.getBlockSkill()*(1+hero.getStrength()/20.0));
	}
	//spellpower calculation from intelligence
	public static int spellPowerCalc(Hero hero) {
		return (int) (hero.getSpellPower()*(1+hero.getIntelligence()/20.0));
	}	
	//spellresist calculation from intelligence
	public static int spellResistCalc(Hero hero) {
		return (int) (hero.getSpellResist()*(1+hero.getIntelligence()/20.0));
	}
	//crit calculations
	public static int critDamageCalc(Hero hero) {
		return (int) (hero.getCritDamage()+hero.getDexterity());
	}
	public static int critChanceCalc(Hero hero, Card_new card) {
		return (int) (hero.getCritChance()+card.getCritChance());
	}
	
	////////////////////////////////////////////////////////////////////
		
	//spell resist calculation
		public static boolean resist(Hero caster, Hero target) {
			if(Math.random()>1/(1.1+(spellResistCalc(target)-spellPowerCalc(caster))*0.05)) {
				
				caster.getPlayer().getGame().log.addLine(target.getName()+" resisted!");
				return true;			
			}else {
				return false;
			}
		}
	//crit combat calculation
	public static int rollForCrit(Hero hero, Card_new card, int damage) {
		if (Math.random()*100<critChanceCalc(hero, card)) {
			hero.getPlayer().getGame().log.addLine("critical!");
			damage=(int)(damage*(1+critDamageCalc(hero)/100.0));
		}
		return damage;
	}
		
	//dodge chance calculation
	public static boolean dodge(Hero attacker, Hero attacked, Card card) {
	double dodgeRoll=Math.random()*100;
		if(dodgeRoll>(-dodgeCalc(attacked)+accuracyCalc(attacker)+card.getAccuracy())) {			
		attacked.getPlayer().getGame().log.addLine(attacked.getName()+" dodged!");
		return true;			
		}else {
			return false;
		}			
	}

	//damage for spells
	public static int calculateSpellDamage(int dmg,Hero hero) {
		return (int) (dmg*(1+(spellPowerCalc(hero))/100.0));
	}
	
	//damage for attacks
	public static int calculateAttackDamage(Card_new card,Hero hero) {
		return (int) (card.getAttackDamage()*(1+(attackSkillCalc(hero))/100.0));
	}
	//block amount calculation
	public static int calculateBlockAmount(int block,Hero hero) {
		return (int) (block*(1+(blockSkillCalc(hero))/100.0));
	}
	//damage factor from strength and dexterity old!
	public static double damageBonus(double strfac,int strength, int dexterity) {
		return 1+(strfac*strength+(1-strfac)*dexterity)/30;
	}

	public static int attackIntoBlock(Hero attacker, Hero blocker, int damage) {
		int restDamage=damage;
		if(blocker.getBlock()>0){
			restDamage=restDamage-blocker.getBlock();
		}
		if(restDamage<0) {
			restDamage=0;
		}
		blocker.setBlock(blocker.getBlock()-(damage-restDamage));
		if (restDamage<damage) {
			blocker.getPlayer().getGame().log.addLine(blocker.getName()+" blocked "+(damage-restDamage)+" damage");			
		}		
		return restDamage;
	}
	public static int elementalIntoBlock(Hero attacker, Hero blocker, int damage) {
		//half block for elementals
		int blockableDamage= damage/2;
		int restDamage=damage-blockableDamage;
		if(blocker.getBlock()>0){
			blockableDamage=blockableDamage-blocker.getBlock();
		}
		if(blockableDamage<0) {
			blockableDamage=0;
		}
		blocker.setBlock(blocker.getBlock()-(damage/2-blockableDamage));
		if (blockableDamage<damage/2) {
			blocker.getPlayer().getGame().log.addLine(blocker.getName()+" blocked "+(damage/2-blockableDamage)+" damage");			
		}		
		return restDamage+blockableDamage;
	}
	//attack vs block roll old
	public static int breachBlock(Hero attacker, Hero blocker, int damage) {
		int restDamage=damage;
		if(blocker.getBlock()>0){
			int block = blocker.getBlock();
			int blockValueVSAttack= block*blocker.getBlockSkill()/attacker.getAttackSkill();
			int blockValueVsAttackAfterDamage= blockValueVSAttack-restDamage;
			if(blockValueVsAttackAfterDamage>=0) {
				restDamage=0;
				blocker.setBlock((int)(1.0*blockValueVsAttackAfterDamage/blockValueVSAttack*block));
			}else {
				blocker.setBlock(0);
				restDamage=-blockValueVsAttackAfterDamage;				
			}
			blocker.getPlayer().getGame().log.addLine(blocker.getName()+" blocked "+(damage-restDamage)+" damage");
		}	
		return restDamage;
	}
	
	//damage reduction by armor
	public static int damageReducedByArmor(int damage, int armor) {
		//negative armor does not amplify damage
		return (int) (damage/(1+Math.max(0, armor)/100.0));
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
	public static int speedRoll(Hero hero) {
		return speedCalc(hero)+(int)(Math.random()*15.0);
	}
	public static int experienceThresholdForLevelUp(int level) {
		if(level==0) {
			return 100;
		}else {
			return experienceThresholdForLevelUp(level-1)+100*level;
		}		
	}
}
