package gameEncounter;

public class Equipment {
	private Hero hero;
	private Item hand1=null;
	private Item hand2=null;
	private Item armor=null;
	public Equipment() {
		super();
	}
	public void equipHand1(Item item) {
		if(hand1!=null) {
			hand1.demod(hero);
			hero.getBackpack().addItem(hand1);
		}
		hand1=item;		
		item.mod(hero);		
	}
	public void equipHand2(Item item) {
		if(hand2!=null) {
			hand2.demod(hero);
			hero.getBackpack().addItem(hand2);
		}
		hand2=item;		
		item.mod(hero);	
	}
	public void equipBiHand(Item item) {
		if(hand1!=null) {
			hand1.demod(hero);
			hero.getBackpack().addItem(hand1);
		}
		if(hand2!=null) {
			hand2.demod(hero);
			hero.getBackpack().addItem(hand2);
		}
		hand1=item;
		hand2=item;
		item.mod(hero);	
	}
	public void equipArmor(Item item) {
		if(armor!=null) {
			armor.demod(hero);
			hero.getBackpack().addItem(armor);
		}
		armor=item;		
		item.mod(hero);	
	}
}
