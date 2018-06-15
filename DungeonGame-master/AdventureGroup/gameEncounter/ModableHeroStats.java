package gameEncounter;

public class ModableHeroStats{
	private int totalStats;
	private Integer[] stats;
	public static final String[] STATNAMES= {"not a stat!","armor","block","attack skill","thorns","draw","strength","dexterity","intelligence","vitality"};
	public ModableHeroStats(){
		stats= new Integer[STATNAMES.length];
		for(int i=0; i<stats.length;i++) {
			stats[i]=0;
		}
		
	}
	public static final Integer getHeroStat(Hero hero, int statNumber) {//is this necessary?
		for(int i=0;i<STATNAMES.length;i++) {
			switch (i) {
	        case 1:  return hero.getArmor();
	        case 2:  return hero.getBlockSkill();
	        case 3:  return hero.getAttackSkill();
	        case 4:  return hero.getThorns();
	        case 5:  return hero.getDraw();
	        case 6:  return hero.getStrength();
	        case 7:  return hero.getDexterity();
	        case 8:  return hero.getIntelligence();
	        case 9:  return hero.getVitality();
	        default: return 0;
	        //TODO the ModableHeroStat class should be integrated to the Hero class!
			}
		}	
		return 0;
	}
	public static final void modStats(Hero hero, Integer[] stats) { //stats belong to array positions
		hero.setArmor(hero.getArmor()+stats[nameResolveStat("armor")]);
	    hero.setBlockSkill(hero.getBlockSkill()+stats[nameResolveStat("block")]);
	    hero.setAttackSkill(hero.getAttackSkill()+stats[nameResolveStat("attack skill")]);
	    hero.setThorns(hero.getThorns()+stats[nameResolveStat("thorns")]);
	    hero.setDraw(hero.getDraw()+stats[nameResolveStat("draw")]);		
	    hero.setStrength(hero.getStrength()+stats[nameResolveStat("strength")]);
	    hero.setDexterity(hero.getDexterity()+stats[nameResolveStat("dexterity")]);
	    hero.setIntelligence(hero.getIntelligence()+stats[nameResolveStat("intelligence")]);
	    hero.setVitality(hero.getVitality()+stats[nameResolveStat("vitality")]);
	}
	public static final Integer nameResolveStat(String n) {
		for(int i=0;i<STATNAMES.length;i++) {
			if(STATNAMES[i].equals(n)) {
				return i;
			}
		}
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
