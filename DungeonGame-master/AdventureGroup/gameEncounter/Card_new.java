package gameEncounter;

import java.io.Serializable;

import gameEncounter.EffectLibrary.EffectBuilder;
import gameEncounter.EffectLibrary.attackEffect;
import gameEncounter.EffectLibrary.blockEffect;
import gameEncounter.ItemLibrary.usables.HealingPotion;

public class Card_new extends Card implements Serializable,Cloneable{
	protected int manaCost=1;
	protected boolean[] legalCastPositions={true,true,true,true,true};
	protected boolean[] legalTargetPositions={true,true,true,true,true};
	protected String name;
	protected int accuracy=100;
	protected int critChance=0;
	protected int block=0;
	protected int attackDamage=0;
	protected int spellDamage=0;
	protected CardEffect effect= new blockEffect();
	protected boolean isFriendly =false;
	protected String text="no data";


	public Card_new(String manaCost, String legalCastPositions, String legalTargetPositions, String name,
			String accuracy, String critChance, String block, String attackDamage, String spellDamage, String effect,
			String isFriendly, String text) {
		super();
		if (manaCost!=null) {
			this.manaCost = Integer.parseInt(manaCost);
		}		
		for(int i=0; i<5;i++) {
			if (Integer.parseInt(legalCastPositions.valueOf(i))!=0) {
				this.legalCastPositions[i] = true;
			}
			if (Integer.parseInt(legalTargetPositions.valueOf(i))!=0) {
				this.legalTargetPositions[i] = true;
			}
		}		
		this.name = name;
		if (accuracy!=null) {
			this.accuracy = Integer.parseInt(accuracy);
		}
		if (critChance!=null) {
			this.critChance = Integer.parseInt(critChance);
		}
		if (block!=null) {
			this.block = Integer.parseInt(block);
		}
		if (attackDamage!=null) {
			this.attackDamage = Integer.parseInt(attackDamage);
		}
		if (spellDamage!=null) {
			this.spellDamage = Integer.parseInt(spellDamage);
		}
		if (effect!=null) {
			this.effect = EffectBuilder.buildEffect(effect);
		}
		
		if (Integer.parseInt(isFriendly)!=0) {
			this.isFriendly = true;
		}
		if (text!=null) {
			this.text=text;
		}		
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public boolean playCard(Hero self){
		//
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
		if(extraCastConditions(self)&&self.getMana()>=manaCost&&self.getHand().contains(this)&&checkPositonsLegal(self)) {
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
	public boolean applyEffect(Hero self) {
		effect.applyEffect(self,this);
		return true;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return isFriendly;
	}
	@Override
	public void buildLogEntry(Hero self) {
		self.getPlayer().getGame().log.addLine(getName());
		
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return effect.generateCardText(hero, this);
	}
	@Override
	public boolean extraCastConditions(Hero hero) {
		// TODO Auto-generated method stub
		return true;
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
		if(legalCastPositions[hero.getPosition()]==false||legalTargetPositions[hero.getTarget().getPosition()]) {
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

	public int getCritChance() {
		return critChance;
	}

	public void setCritChance(int critChance) {
		this.critChance = critChance;
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

	public CardEffect getEffect() {
		return effect;
	}

	public void setEffect(CardEffect effect) {
		this.effect = effect;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setFriendly(boolean isFriendly) {
		this.isFriendly = isFriendly;
	}
			
	
}
