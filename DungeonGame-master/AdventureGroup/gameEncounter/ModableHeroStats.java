package gameEncounter;

import java.io.Serializable;

public class ModableHeroStats implements Serializable{
	private int totalStats;
	private Integer[] stats;
	public static final String[] STATNAMES= {"not a stat!","health","armor","block","attack","thorns","draw","strength","dexterity","intelligence","vitality","spell","dodge","accuracy","resistSpell","resistFire","resistCold","resistBleed","resistPoison","resistStun","resistStress","speed","mana","spellDuration"};
	public ModableHeroStats(){
		stats= new Integer[STATNAMES.length];
		for(int i=0; i<stats.length;i++) {
			stats[i]=0;
		}
		
	}
	public static final void modStats(Hero hero, Integer[] stats) { //stats belong to array positions
		hero.setArmor(hero.getArmor()+stats[nameResolveStat("armor")]);
	    hero.setBlockSkill(hero.getBlockSkill()+stats[nameResolveStat("block")]);
	    hero.setAttackSkill(hero.getAttackSkill()+stats[nameResolveStat("attack")]);
	    hero.setThorns(hero.getThorns()+stats[nameResolveStat("thorns")]);
	    hero.setDraw(hero.getDraw()+stats[nameResolveStat("draw")]);		
	    hero.setStrength(hero.getStrength()+stats[nameResolveStat("strength")]);
	    hero.setDexterity(hero.getDexterity()+stats[nameResolveStat("dexterity")]);
	    hero.setIntelligence(hero.getIntelligence()+stats[nameResolveStat("intelligence")]);
	    hero.setVitality(hero.getVitality()+stats[nameResolveStat("vitality")]);
	    hero.setSpellPower(hero.getSpellPower()+stats[nameResolveStat("spell")]);
	    hero.setDodge(hero.getDodge()+stats[nameResolveStat("dodge")]);
	    hero.setAccuracy(hero.getAccuracy()+stats[nameResolveStat("accuracy")]);
	    hero.setSpellResist(hero.getSpellResist()+stats[nameResolveStat("resistSpell")]);
	    hero.setResistFire(hero.getResistFire()+stats[nameResolveStat("resistFire")]);
	    hero.setResistCold(hero.getResistCold()+stats[nameResolveStat("resistCold")]);
	    hero.setResistBleed(hero.getResistBleed()+stats[nameResolveStat("resistBleed")]);
	    hero.setResistPoison(hero.getResistPoison()+stats[nameResolveStat("resistPoison")]);
	    hero.setResistStun(hero.getResistStun()+stats[nameResolveStat("resistStun")]);
	    hero.setResistStress(hero.getResistStress()+stats[nameResolveStat("resistStress")]);
	    hero.setBaseHp(hero.getBaseHp()+stats[nameResolveStat("health")]);
	    hero.setSpeed(hero.getSpeed()+stats[nameResolveStat("speed")]);
	    hero.setManaPower(hero.getManaPower()+stats[nameResolveStat("mana")]);
	    hero.setSpellDuration(hero.getSpellDuration()+stats[nameResolveStat("spellDuration")]);
	}
	public static final Integer nameResolveStat(String n) {
		for(int i=0;i<STATNAMES.length;i++) {
			if(STATNAMES[i].equals(n)) {
				return i;
			}
		}
		System.out.println("nameResolveStat error! (not a stat)");
		return 0;
	}
	public static final  String getDescriptionStringForItemStat(int i) {// assert a number to every possible item bonus
		if(i<STATNAMES.length&&i>0) {
			return STATNAMES[i];
		}else {
			return "not a stat!";
		}
    }
	
	public Integer[] getStats() {
		return stats;
	}
	public void setStats(Integer[] stats) {
		this.stats = stats;
	}

	
}
