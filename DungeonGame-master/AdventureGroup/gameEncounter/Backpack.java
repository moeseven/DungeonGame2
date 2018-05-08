package gameEncounter;

import java.util.LinkedList;

public class Backpack {
	private LinkedList<Item> items;
	private int weight;
	public Backpack() {
		// TODO Auto-generated constructor stub
	}
	public void addItem(Item item) {
		items.add(item);
	}
}
