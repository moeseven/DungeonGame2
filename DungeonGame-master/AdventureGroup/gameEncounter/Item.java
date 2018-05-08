package gameEncounter;

public abstract class Item {
	private int weight;
	private int gold;
	private int category;
	//1: Hand1  //2: Hand2  //3: BiHand //4: Armor
	public Item() {
		super();
	}
	public abstract void mod(Hero hero); //add modifiers granted by this item
	public abstract void demod(Hero hero); //remove modifiers granted by this item
	public abstract String toString();
	public abstract boolean equip(Equipment e);//move from backpack to Equipment
	public abstract boolean unequip(Equipment e); //move from Equipment to backpack (maybe not needed, inventory handles this)

}
