package gameEncounter;

import java.io.Serializable;
import java.util.LinkedList;

import gameEncounter.ItemLibrary.usables.HealingPotion;

public abstract class Card implements Serializable,Cloneable{
	protected int critChance=0;
	protected int manaCost;
	protected boolean xCostCard=false;
	protected int x;
	protected int accuracy=90;
	protected int block=0;
	protected int attackDamage=0;
	protected int spellDamage=0;
	protected boolean[] legalCastPositions={true,true,true,true,true};
	protected boolean[] legalTargetPositions={true,true,true,true,true};
	protected String name;
	public Card() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public boolean playable(Hero self){
		if(isFriendly()) {
			if(self.getTarget().getPlayer()==self.getPlayer()) {
				return castable(self);
			}else {
				self.getPlayer().getGame().log.addLine("not a possible target!");
			}
		}else {
			if(self.getTarget().getPlayer()!=self.getPlayer()) {
				return castable(self);
			}else {
				self.getPlayer().getGame().log.addLine("not a possible target!");
			}
		}
		return false;
	}
	public boolean castable(Hero self) {
		if(extraCastConditions(self)&&self.getMana()>=computeManaCost(self)&&self.getHand().contains(this)&&checkPositonsLegal(self)) {						
			return true;
		}else {
			return false;
		}
	}
	public void handleManaCost(Hero self) {
		x=computeManaCost(self);
		self.setMana(self.getMana()-x);		
	}
	public void cast(Hero self) {
		if (!self.isDead()) {
			handleManaCost(self);		
			self.getHand().remove(this);
			self.getDiscardPile().add(this);
			buildLogEntry(self);
			applyEffect(self);
		}		
	}
	public abstract boolean extraCastConditions(Hero hero);
	public abstract boolean applyEffect(Hero self);// here happens the magic
	public abstract String getName();
	public abstract void buildLogEntry(Hero self);
	public abstract LinkedList<String> getCardText(Hero hero);
	public abstract boolean isFriendly();
	public int computeManaCost(Hero self) {
		if (xCostCard) {
			return self.getMana();
		}else {
			return manaCost;
		}
	}
	//getters and setters
//	public int getManaCost() {
//		return manaCost;
//	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean checkPositonsLegal(Hero hero){
		if(legalCastPositions[hero.getPosition()]==false||legalTargetPositions[hero.getTarget().getPosition()]==false) {
			if(hero.getPlayer()!=hero.getPlayer().getGame().dungeonMaster) {
				if (legalCastPositions[hero.getPosition()]) {
					hero.getPlayer().getGame().log.addLine("can not target this position!");
				}else {
					hero.getPlayer().getGame().log.addLine("can not be used from this position!");
				}
				
			}		
			return false;
		}else {
			return true;
		}
	}

	public boolean[] getLegalCastPositions() {
		return legalCastPositions;
	}

	public void setLegalCastPositions(boolean[] legalPositions) {
		this.legalCastPositions = legalPositions;
	}

	public boolean[] getLegalTargetPositions() {
		return legalTargetPositions;
	}

	public void setLegalTargetPositions(boolean[] legalTargetPositions) {
		this.legalTargetPositions = legalTargetPositions;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpellDamage() {
		return spellDamage;
	}

	public void setSpellDamage(int spellDamage) {
		this.spellDamage = spellDamage;
	}
			
	
}
