package gameEncounter;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Item implements Serializable{
	protected double itemQuality=0;
	protected int imageNumber=101;
	protected int numberOfSuffixes=0;
	protected String itemClass="bow";
	protected int weight=10;
	private int goldValue=100;
	protected int baseGoldValue=goldValue;
	protected int numberOfModifications=0;
	protected int category=10;
	protected boolean droppable=true;
	protected int requiredStrength=0;
	protected int requiredDexterity=0;
	protected int requiredIntelligence=0;
	protected int requiredVitality=0;
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
		String requirements="requirements: ";
		if(requiredStrength>0) {
			requirements+= requiredStrength+"str ";
		}
		if(requiredDexterity>0) {
			requirements+= requiredDexterity+"dex ";
		}
		if(requiredIntelligence>0) {
			requirements+= requiredIntelligence+"int ";
		}
		description.add(requirements);
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
	public final  String getItemCategoryName(int i) {
		switch (i) { //1: Hand1  //2: Hand2  //3: BiHand //4: Body //5: Head
		case 0:	 return "consumable";
		case 1:  return"mainHand";
        case 2:  return "offHand";
        case 3:  return "twoHanded";
        case 4:  return "body";
        case 5:  return "head";
        case 6:	 return "ring";
        case 10: return "relic";
        default: return "there is no such category!";
		}
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
		if (s.equals("ring")) {
			retVal=6;
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
	public String getItemClass() {
		return itemClass;
	}
	public void setItemClass(String itemClass) {
		this.itemClass = itemClass;
	}
	public int getBaseGoldValue() {
		return baseGoldValue;
	}
	public void setBaseGoldValue(int baseGoldValue) {
		this.baseGoldValue = baseGoldValue;
	}
	public int getNumberOfModifications() {
		return numberOfModifications;
	}
	public void setNumberOfModifications(int numberOfModifications) {
		this.numberOfModifications = numberOfModifications;
	}
	public int getImageNumber() {
		return imageNumber;
	}
	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}
	public int getNumberOfSuffixes() {
		return numberOfSuffixes;
	}
	public void setNumberOfSuffixes(int numberOfSuffixes) {
		this.numberOfSuffixes = numberOfSuffixes;
	}
	public double getItemQuality() {
		return itemQuality;
	}
	public void setItemQuality(double itemQuality) {
		this.itemQuality = itemQuality;
	}
	
}
