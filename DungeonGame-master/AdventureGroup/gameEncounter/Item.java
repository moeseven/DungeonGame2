package gameEncounter;

import java.util.LinkedList;

public abstract class Item {
	private int weight;
	private int goldValue;
	protected int category;
	protected ModableHeroStats stats;
	protected LinkedList<String> description;
	protected String name;
	
	public Item() {
		super();
		description=new LinkedList<String>();
		stats=new ModableHeroStats();
	}
	public abstract boolean equip(Equipment e); //move from backpack to Equipment
	public abstract boolean unequip(Equipment e); //move from Equipment to backpack (maybe not needed, inventory handles this)
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
