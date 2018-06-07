package gameEncounter;

public abstract class Item {
	private int weight;
	private int goldValue;
	protected int category;
	protected String name;
	//1: Hand1  //2: Hand2  //3: BiHand //4: Body //5: Head
	public Item() {
		super();
	}
	public abstract void mod(Hero hero); //add modifiers granted by this item
	public abstract void demod(Hero hero); //remove modifiers granted by this item
	public abstract boolean equip(Equipment e);//move from backpack to Equipment
	public abstract boolean unequip(Equipment e); //move from Equipment to backpack (maybe not needed, inventory handles this)
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

}
