package gameEncounter;

import java.io.Serializable;
import java.util.LinkedList;

import gameEncounter.ItemLibrary.usables.HealingPotion;
import gameEncounter.buffLibrary.GuardedBuff;

public abstract class Card implements Serializable,Cloneable{
	protected int imageNumber=99;
	protected int critChance=0;
	protected int manaCost;
	protected boolean xCostCard=false;
	protected int manacostX;
	protected int interEffectValue=0;
	protected boolean isFriendly =false;
	protected int accuracy=90;
	protected int block=0;
	protected int attackDamage=0;
	protected int spellDamage=0;
	protected boolean[] legalCastPositions={true,true,true,true,true};
	protected boolean[] legalTargetPositions={true,true,true,true,true};
	protected LinkedList<CardEffect> allEffects= new LinkedList<CardEffect>();
	protected LinkedList<CardEffect> drawEffects=new LinkedList<CardEffect>();
	protected LinkedList<CardEffect> discardEffects=new LinkedList<CardEffect>();
	protected LinkedList<CardEffect> useupEffects=new LinkedList<CardEffect>();
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
	public boolean aiPlayableCheck(Hero self){
		if(extraCastConditions(self)&&self.getMana()>=computeManaCost(self)&&checkPositonsLegal(self)) {						
			return true;
		}else {
			return false;
		}
	}
	public void handleManaCost(Hero self) {
		manacostX=computeManaCost(self);
		self.setMana(self.getMana()-manacostX);		
	}
	public void cast(Hero self) {
		if (!self.isDead()) {
			handleManaCost(self);		
			self.getHand().remove(this);
			self.getDiscardPile().add(this);
			self.getPlayer().getGame().setLastCaster(self);
			//card animations triggered here
			
			
			//handle protection		not TESTED!	
			for (int i = 0; i < self.getTarget().getBuffs().size(); i++) {
				if (self.getTarget().getBuffs().get(i) instanceof GuardedBuff) {
					self.getTargets().remove(self.getTarget());
					self.addTarget(self.getTarget().getBuffs().get(i).onBeeingTargeted(self));
				}				
			}
			if (isFriendly) {
				//run friendly animation
				self.getPlayer().getGame().getAnimationHandler().produceFriendlyAnimation(self);
			}else {
				//run forward move of caster 
				//run backward move of target
				self.getPlayer().getGame().getAnimationHandler().produceCombatAnimation(self, self.getTarget());
			}
			buildLogEntry(self);
			applyEffect(self);
			self.setCardsPlayedThisRound(self.getCardsPlayedThisRound()+1);
			if (self.getHand().size()>0) {
				self.setSelectedCard(self.getHand().getFirst());
			}			
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
	public int getManaCost() {
		return manaCost;
	}
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

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

	public LinkedList<CardEffect> getAllEffects() {
		return allEffects;
	}

	public void setAllEffects(LinkedList<CardEffect> allEffects) {
		this.allEffects = allEffects;
	}

	public LinkedList<CardEffect> getDrawEffects() {
		return drawEffects;
	}

	public void setDrawEffects(LinkedList<CardEffect> drawEffects) {
		this.drawEffects = drawEffects;
	}

	public LinkedList<CardEffect> getDiscardEffects() {
		return discardEffects;
	}

	public void setDiscardEffects(LinkedList<CardEffect> discardEffects) {
		this.discardEffects = discardEffects;
	}

	public LinkedList<CardEffect> getUseupEffects() {
		return useupEffects;
	}

	public void setUseupEffects(LinkedList<CardEffect> useupEffects) {
		this.useupEffects = useupEffects;
	}

	public int getX() {
		return interEffectValue;
	}

	public void setX(int interEffectValue) {
		this.interEffectValue = interEffectValue;
	}

	public int getManacostX() {
		return manacostX;
	}

	public void setManacostX(int manacostX) {
		this.manacostX = manacostX;
	}
			
	
}
