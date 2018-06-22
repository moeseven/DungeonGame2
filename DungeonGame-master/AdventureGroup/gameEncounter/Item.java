package gameEncounter;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Item implements Serializable{
	private int weight;
	private int goldValue=100;
	protected int category;
	protected int requiredStrength=1;
	protected int requiredDexterity=1;
	protected int requiredIntelligence=1;
	protected int requiredVitality=1;
	protected ModableHeroStats stats;
	protected LinkedList<String> description;
	protected String name="";
	
	public Item() {
		super();
		description=new LinkedList<String>();
		stats=new ModableHeroStats();
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
		description.add("category: "+ getItemCategoryName(category));
		description.add("requirements: "+requiredStrength+"str, "+requiredDexterity+"dex, "+requiredIntelligence+"int");
		for(int i=0; i<stats.getStats().length;i++) {
			if(stats.getStats()[i]!=0) {
				if(stats.getStats()[i]>0) {
					description.add(ModableHeroStats.getDescriptionStringForItemStat(i)+": +"+stats.getStats()[i]);
				}else {
					description.add(ModableHeroStats.getDescriptionStringForItemStat(i)+": "+stats.getStats()[i]);
				}				
			}
		}
	} 
	public final  String getItemCategoryName(int i) {
		switch (i) { //1: Hand1  //2: Hand2  //3: BiHand //4: Body //5: Head
        case 1:  return"main hand";
        case 2:  return "off hand";
        case 3:  return "two handed";
        case 4:  return "body";
        case 5:  return "head";
        default: return "there is no such category!";
		}
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

	
}
