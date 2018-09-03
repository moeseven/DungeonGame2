package gameEncounter;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class HeroQuirk implements Serializable{
	protected ModableHeroStats stats;
	protected LinkedList<String> description;
	protected String name="";	
	public HeroQuirk() {
		super();
		description=new LinkedList<String>();
		stats=new ModableHeroStats();
	}
	public void gainQuirk(Hero hero) {
		hero.getQuirks().add(this);
		mod(hero);
		if(hero.getHp()>GameEquations.maxHealthCalc(hero)) {
			hero.setHp(GameEquations.maxHealthCalc(hero));
		}
	}
	public void looseQuirk(Hero hero) {
		hero.getQuirks().remove(this);
		demod(hero);
		if(hero.getHp()>GameEquations.maxHealthCalc(hero)) {
			hero.setHp(GameEquations.maxHealthCalc(hero));
		}
	}
	public void mod(Hero hero) {
		ModableHeroStats.modStats(hero,stats.getStats());
	}
	public void demod(Hero hero) {
		Integer[] minusValues=new Integer[stats.getStats().length];
		for(int i=0; i<minusValues.length;i++) {
			minusValues[i]=stats.getStats()[i]*(-1);
		}
		ModableHeroStats.modStats(hero,minusValues);
	}
	
	public void generateItemDescription() {
		description=new LinkedList<String>();		
		for(int i=0; i<stats.getStats().length;i++) {
			if(stats.getStats()[i]!=0) {
				if(stats.getStats()[i]>0) {
					description.add("+"+stats.getStats()[i]+" "+ModableHeroStats.getDescriptionStringForItemStat(i));
				}else {
					description.add(stats.getStats()[i]+" "+ModableHeroStats.getDescriptionStringForItemStat(i));
				}				
			}
		}
	} 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkedList<String> getDescription() {
		generateItemDescription();
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

	
}
