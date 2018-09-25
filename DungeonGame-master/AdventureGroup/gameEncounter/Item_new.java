package gameEncounter;

import java.io.Serializable;
import java.util.LinkedList;

public class Item_new extends Item implements Serializable{
	protected int weight=10;
	private int goldValue=100;
	protected int category=10;
	protected boolean droppable=true;
	protected int requiredStrength=0;
	protected int requiredDexterity=0;
	protected int requiredIntelligence=0;
	protected int requiredVitality=0;
	protected ModableHeroStats stats;
	//item stats	
	protected int attack=0;
	protected int block=0;
	protected int spell=0;
	
	protected int accuracy=0;
	protected int dodge=0;
	protected int speed=0;
	protected int draw=0;
	protected int mana=0;
	protected int thorns=0;
	protected int armor=0;
	protected int health=0;
	protected int resistSpell=0;
	protected int resistLightning = 0;
	protected int resistFire=0;
	protected int resistCold=0;
	protected int resistPoison=0;
	protected int resistBleed=0;
	protected int resistStun=0;
	protected int resistStress=0;

	protected int critChance=0;
	//	not in yet
	protected int duration=0;
	protected int fireDmg=0;
	protected int coldDmg=0;
	protected int lightningDmg=0;
	protected int bleedDmg=0;
	protected int poisonDmg=0;
	protected int magicDmg=0;
	
	
	//
	protected LinkedList<String> description;
	protected String name="";
	
	public Item_new(String weight, String goldValue, String category, String droppable, String critChance,String attack, String block, String spell,
			String accuracy, String dodge, String speed, String draw, String mana, String thorns, String armor, String health, String resistSpell,
			String resistLightning,String resistFire, String resistCold, String resistPoison, String resistBleed, String resistStun, String resistStress,String duration,
			String fireDmg, String coldDmg, String lightningDmg, String bleedDmg, String poisonDmg, String magicDmg, String name) {
		super();
		this.name = name;
		//random attributes here
		//
		if (weight!=null) {
			this.weight = Integer.parseInt(weight);
		}
		if (goldValue!=null) {
			this.goldValue = Integer.parseInt(goldValue);
		}
		if (category!=null) {
			this.category = getItemCategoryInteger(category);
		}
		if (droppable.equals("0")) {
			this.droppable = false;
		}	
		//
		//modifiers
		if (critChance!=null) {			
			this.critChance = GameEquations.RandomizeItemStat(critChance);
		}
		if (attack!=null) {
			this.attack = GameEquations.RandomizeItemStat(attack);
		}
		if (block!=null) {
			this.block = GameEquations.RandomizeItemStat(block);;
		}
		if (spell!=null) {
			this.spell = GameEquations.RandomizeItemStat(spell);;
		}
		if (accuracy!=null) {
			this.accuracy = GameEquations.RandomizeItemStat(accuracy);;
		}
		if (dodge!=null) {
			this.dodge = GameEquations.RandomizeItemStat(dodge);
		}
		if (speed!=null) {
			this.speed = GameEquations.RandomizeItemStat(speed);
		}
		if (draw!=null) {
			this.draw = GameEquations.RandomizeItemStat(draw);
		}
		if (mana!=null) {
			this.mana = GameEquations.RandomizeItemStat(mana);
		}
		if (thorns!=null) {
			this.thorns = GameEquations.RandomizeItemStat(thorns);
		}
		if (armor!=null) {
			this.armor = GameEquations.RandomizeItemStat(armor);
		}
		if (health!=null) {
			this.health = GameEquations.RandomizeItemStat(health);
		}
		if (resistSpell!=null) {
			this.resistSpell = GameEquations.RandomizeItemStat(resistSpell);
		}
		if (resistLightning!=null) {
			this.resistLightning = GameEquations.RandomizeItemStat(resistLightning);
		}
		if (resistFire!=null) {
			this.resistFire = GameEquations.RandomizeItemStat(resistFire);
		}
		if (resistCold!=null) {
			this.resistCold = GameEquations.RandomizeItemStat(resistCold);
		}
		if (resistPoison!=null) {
			this.resistPoison = GameEquations.RandomizeItemStat(resistPoison);
		}
		if (resistBleed!=null) {
			this.resistBleed = GameEquations.RandomizeItemStat(resistBleed);
		}
		if (resistStun!=null) {
			this.resistStun = GameEquations.RandomizeItemStat(resistStun);
		}
		if (resistStress!=null) {
			this.resistStress = GameEquations.RandomizeItemStat(resistStress);
		}
		if (duration!=null) {
			this.duration= GameEquations.RandomizeItemStat(duration);
		}
		if(fireDmg!=null) {
			this.fireDmg=GameEquations.RandomizeItemStat(fireDmg);
		}
		if (coldDmg!=null) {
			this.coldDmg= GameEquations.RandomizeItemStat(coldDmg);
		}
		if (lightningDmg!=null) {
			this.lightningDmg=GameEquations.RandomizeItemStat(lightningDmg);
		}
		if (bleedDmg!=null) {
			this.bleedDmg= GameEquations.RandomizeItemStat(bleedDmg);
		}
		if (poisonDmg!=null) {
			this.poisonDmg=GameEquations.RandomizeItemStat(poisonDmg);
		}
		if (magicDmg!=null) {
			this.magicDmg= GameEquations.RandomizeItemStat(magicDmg);
		}
		//
		
	}
	public void modification(Hero hero,int fac) {
		hero.setArmor(hero.getArmor()+armor*fac);
	    hero.setBlockSkill(hero.getBlockSkill()+block*fac);
	    hero.setAttackSkill(hero.getAttackSkill()+attack*fac);
	    hero.setThorns(hero.getThorns()+thorns*fac);
	    hero.setDraw(hero.getDraw()+draw*fac);		
	    hero.setSpellPower(hero.getSpellPower()+spell*fac);
	    hero.setDodge(hero.getDodge()+dodge*fac);
	    hero.setAccuracy(hero.getAccuracy()+accuracy*fac);
	    hero.setSpellResist(hero.getSpellResist()+resistSpell*fac);
	    hero.setResistFire(hero.getResistFire()+resistFire*fac);
	    hero.setResistCold(hero.getResistCold()+resistCold*fac);
	    hero.setResistBleed(hero.getResistBleed()+resistBleed*fac);
	    hero.setResistPoison(hero.getResistPoison()+resistPoison*fac);
	    hero.setResistStun(hero.getResistStun()+resistStun*fac);
	    hero.setResistStress(hero.getResistStress()+resistStress*fac);
	    hero.setBaseHp(hero.getBaseHp()+health*fac);
	    hero.setSpeed(hero.getSpeed()+speed*fac);
	    hero.setManaPower(hero.getManaPower()+mana*fac);
	    hero.setSpellDuration(hero.getSpellDuration()+duration*fac);
	    hero.setFireDmg(hero.getFireDmg()+fireDmg*fac);
	    hero.setColdDmg(hero.getColdDmg()+coldDmg*fac);
	    hero.setLightningDmg(hero.getLightningDmg()+lightningDmg*fac);
	    hero.setBleedDmg(hero.getBleedDmg()+bleedDmg*fac);
	    hero.setPoisonDmg(hero.getPoisonDmg()+poisonDmg*fac);
	    hero.setMagicDmg(hero.getMagicDmg()+magicDmg*fac);
	}
	public void mod(Hero hero) {
		modification(hero, 1);
	}
	public void demod(Hero hero) {
		modification(hero, -1);
	}
	
	public void generateItemDescription() {
		description=new LinkedList<String>();
		description.add("category: "+ getItemCategoryName(category));
//		String requirements="requirements: ";
//		if(requiredStrength>0) {
//			requirements+= requiredStrength+"str ";
//		}
//		if(requiredDexterity>0) {
//			requirements+= requiredDexterity+"dex ";
//		}
//		if(requiredIntelligence>0) {
//			requirements+= requiredIntelligence+"int ";
//		}
//		description.add(requirements);
		//all the stats need to be here
		if (critChance!=0) {
			description.add("crit chance: "+critChance);
		}
		if (attack!=0) {
			description.add("attack skill: "+attack);
		}
		if (block!=0) {
			description.add("block skill: "+block);
		}
		if (spell!=0) {
			description.add("spell power: "+spell);
		}
		if (accuracy!=0) {
			description.add("accuracy: "+accuracy);
		}
		if (dodge!=0) {
			description.add("doge: "+dodge);
		}
		if (speed!=0) {
			description.add("speed: "+speed);
		}
		if (draw!=0) {
			description.add("draw: "+draw);
		}
		if (mana!=0) {
			description.add("mana: "+mana);
		}
		if (thorns!=0) {
			description.add("thorns: "+thorns);
		}
		if (armor!=0) {
			description.add("armor: "+armor);
		}
		if (health!=0) {
			description.add("health: "+health);
		}
		if (resistSpell!=0) {
			description.add("spell resistance: "+resistSpell+"%");
		}
		if (resistFire!=0) {
			description.add("fire resistance: "+resistFire+"%");
		}
		if (resistCold!=0) {
			description.add("cold resistance: "+resistCold+"%");
		}
		if (resistPoison!=0) {
			description.add("poison resistance: "+resistPoison+"%");
		}
		if (resistBleed!=0) {
			description.add("bleed resistance: "+resistBleed+"%");
		}
		if (resistStun!=0) {
			description.add("stun resistance: "+resistStun+"%");
		}
		if (resistStress!=0) {
			description.add("stress resistance: "+resistStress+"%");
		}
		if (duration!=0) {
			description.add("spell duration: "+duration);
		}
		if (fireDmg!=0) {
			description.add("fire damage: "+fireDmg+"%");
		}
		if (coldDmg!=0) {
			description.add("cold damage: "+coldDmg+"%");
		}
		if (lightningDmg!=0) {
			description.add("lightning damage: "+lightningDmg+"%");
		}
		if (bleedDmg!=0) {
			description.add("bleed damage: "+bleedDmg+"%");
		}
		if (poisonDmg!=0) {
			description.add("poison damage: "+poisonDmg+"%");
		}
		if (magicDmg!=0) {
			description.add("magic damage: "+magicDmg+"%");
		}
		//
	} 
	public final  int getItemCategoryInteger(String s) {
		int retVal=-1;
		if (s.equals("consumable")) {
			retVal=0;
		}
		if (s.equals("mainHand")) {
			retVal=1;
		}
		if (s.equals("offHand")) {
			retVal=2;
		}
		if (s.equals("twoHanded")) {
			retVal=3;
		}
		if (s.equals("body")) {
			retVal=4;
		}
		if (s.equals("head")) {
			retVal=5;
		}
		if (s.equals("relic")) {
			retVal=10;
		}
		return retVal;
	}

	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getGoldValue() {
		return goldValue;
	}
	public void setGoldValue(int goldValue) {
		this.goldValue = goldValue;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkedList<String> getDescription() {
		return description;
	}
	public void setDescription(LinkedList<String> description) {
		this.description = description;
	}
	public ModableHeroStats getStats() {
		return stats;
	}
	public void setStats(ModableHeroStats stats) {
		this.stats = stats;
	}
	public boolean isDroppable() {
		return droppable;
	}
	public void setDroppable(boolean droppable) {
		this.droppable = droppable;
	}

	
}
