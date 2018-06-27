package gameEncounter;

import java.io.Serializable;

import gameEncounter.ItemLibrary.usables.HealingPotion;

public abstract class Card implements Serializable,Cloneable{
	protected int manaCost;
	protected boolean[] legalPositions={true,true,true,true,true};
	protected String name;
	protected int range;
	public Card() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public boolean playCard(Hero self){
		
		if(self.getMana()>=manaCost&&self.getHand().contains(this)&&checkPositonLegal(self)&&self.targetInRange(self.getTarget(),rangeOfCard(self))) {
			self.setMana(self.getMana()-manaCost);			
			self.getHand().remove(this);
			self.getDiscardPile().add(this);
			buildLogEntry(self);
			applyEffect(self);
			
			return true;
		}else {
			return false;
		}
	}
	public abstract int rangeOfCard(Hero hero);
	public abstract boolean applyEffect(Hero self);// here happens the magic
	public abstract String getName();
	public abstract void buildLogEntry(Hero self);
	public abstract String getCardText();
	public abstract boolean isFriendly();
	//getters and setters
	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean checkPositonLegal(Hero hero){
		if(legalPositions[hero.getPosition()]==false) {
			hero.getPlayer().getGame().log.addLine("can not be used from this position!");
			return false;
		}else {
			return true;
		}
	}
			
	
}
