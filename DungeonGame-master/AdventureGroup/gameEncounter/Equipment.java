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
	public void equipHand1(Item item) {
		if(item.getCategory()==1) {
			if(hand1!=null) {
				hand1.demod(hero);
				hero.getInventory().add(hand1);
			}
			if(hand1==hand2) {//clean biHand removal
				hand2=null;
			}			
			hand1=item;	
			hero.getInventory().remove(item);	
			item.mod(hero);
		}else {
			equipBiHand(item);
		}
	}
	public void equipHand2(Item item) {
		if(item.getCategory()==2) {
			if(hand2!=null) {
				hand2.demod(hero);
				hero.getInventory().add(hand2);
			}
			if(hand1==hand2) {//clean biHand removal
				hand1=null;
			}
			hand2=item;	
			hero.getInventory().remove(item);	
			item.mod(hero);	
		}else {
			equipBiHand(item);
		}

	}
	public void equipBiHand(Item item) {
		if(item.getCategory()==3) {
			if(hand1!=null) {
				hand1.demod(hero);
				hero.getInventory().add(hand1);
			}
			if(hand2!=null) {
				hand2.demod(hero);
				hero.getInventory().add(hand2);
			}
			hand1=item;
			hand2=item;
			hero.getInventory().remove(item);	
			item.mod(hero);
		}
			
	}
	public void equipBody(Item item) {
		if(item.getCategory()==4) {
			if(body!=null) {
				body.demod(hero);
				hero.getInventory().add(body);
			}
			body=item;
			hero.getInventory().remove(item);	
			item.mod(hero);
		}
			
	}
	public void equipHead(Item item) {
		if(item.getCategory()==5) {
			if(head!=null) {
				head.demod(hero);
				hero.getInventory().add(head);
			}
			head=item;	
			hero.getInventory().remove(item);	
			item.mod(hero);
		}
			
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
