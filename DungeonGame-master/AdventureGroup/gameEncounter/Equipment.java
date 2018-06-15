package gameEncounter;

public class Equipment {
	private Hero hero;
	private Item hand1=null;
	private Item hand2=null;
	private Item body=null;
	private Item head=null;
	//1: Hand1  //2: Hand2  //3: BiHand //4: Body //5: Head
	public Equipment(Hero hero) {
		this.hero=hero;
	}
	public boolean equipItem(Item item) {
		boolean success=true;
		switch (item.getCategory()) {
        case 1:  equipHand1(item);
        case 2:  equipHand2(item);
        case 3:  equipBiHand(item);
        case 4:  equipBody(item);
        case 5:  equipHead(item);
        default: success=false;
		}
		return success;
	}
	public boolean unequipItem(Item item) {
		boolean success=true;
		switch (item.getCategory()) {
        case 1:  unequipHand1();
        case 2:  unequipHand2();
        case 3:  unequipBiHand();
        case 4:  unequipBody();
        case 5:  unequipHead();
        default: success=false;
		}
		return success;
	}
	public void equipHand1(Item item) {
		if(item.getCategory()==1) {
			unequipHand1();
			hero.getInventory().remove(item);			
			hand1=item;					
			item.mod(hero);
		}else {
			equipBiHand(item);
		}
	}
	public void equipHand2(Item item) {
		if(item.getCategory()==2) {
			unequipHand2();
			hand2=item;	
			hero.getInventory().remove(item);	
			item.mod(hero);	
		}else {
			equipBiHand(item);
		}

	}
	public void equipBiHand(Item item) {
		if(item.getCategory()==3) {
			unequipHand1();
			unequipHand2();
			hand1=item;
			hand2=item;
			hero.getInventory().remove(item);	
			item.mod(hero);
		}
			
	}
	public void equipBody(Item item) {
		if(item.getCategory()==4) {
			unequipBody();
			body=item;
			hero.getInventory().remove(item);	
			item.mod(hero);
		}
			
	}
	public void equipHead(Item item) {
		if(item.getCategory()==5) {
			unequipHead();
			head=item;	
			hero.getInventory().remove(item);	
			item.mod(hero);
		}
			
	}
	public void unequipHand1() {
		if(hand1!=null) {
			hand1.demod(hero);
			hero.getInventory().add(hand1);
		}
		if(hand1==hand2) {//clean biHand removal
			hand2=null;
		}		
		hand1=null;
	}
	public void unequipHand2() {
		if(hand2!=null) {
			hand2.demod(hero);
			hero.getInventory().add(hand2);
		}
		if(hand1==hand2) {//clean biHand removal
			hand1=null;
		}		
		hand2=null;
	}
	public void unequipBiHand() {
		if(hand2!=null) {
			hand2.demod(hero);
			hero.getInventory().add(hand2);
		}
		hand1=null;		
		hand2=null;
	}
	public void unequipBody() {
		if(body!=null) {
			body.demod(hero);
			hero.getInventory().add(body);
		}		
		body=null;
	}
	public void unequipHead() {
		if(head!=null) {
			head.demod(hero);
			hero.getInventory().add(head);
		}		
		head=null;
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public Item getHand1() {
		return hand1;
	}
	public void setHand1(Item hand1) {
		this.hand1 = hand1;
	}
	public Item getHand2() {
		return hand2;
	}
	public void setHand2(Item hand2) {
		this.hand2 = hand2;
	}
	public Item getBody() {
		return body;
	}
	public void setBody(Item body) {
		this.body = body;
	}
	public Item getHead() {
		return head;
	}
	public void setHead(Item head) {
		this.head = head;
	}
	
}
