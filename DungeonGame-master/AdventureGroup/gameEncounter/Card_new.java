package gameEncounter;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import gameEncounter.CardLibrary.CastCondition;
import gameEncounter.CardLibrary.CastConditionBuilder;
import gameEncounter.CardLibrary.EffectParameters;
import gameEncounter.EffectLibrary.EffectBuilder;
import gameEncounter.EffectLibrary.attackEffect;
import gameEncounter.EffectLibrary.blockEffect;
import gameEncounter.ItemLibrary.usables.HealingPotion;

public class Card_new extends Card implements Serializable,Cloneable{
	protected LinkedList<CastCondition> castConditions =new LinkedList<CastCondition>();
	protected boolean[] legalCastPositions={true,true,true,true,true};
	protected boolean[] legalTargetPositions={true,true,true,true,true};
	protected String name;
	protected boolean isFriendly =false;
	protected String text="no data";
	protected LinkedList<CardEffect> allEffects= new LinkedList<CardEffect>();
	//protected LinkedList<EffectParameters> allEffectsParameter= new LinkedList<EffectParameters>();

	public Card_new(String manaCost, String legalCastPositions, String legalTargetPositions, String name,
			String accuracy, String critChance, String block, String attackDamage, String spellDamage, String effect,
			String effect2, String effect3,String isFriendly, String text, String effect4, String effect5, String castConditions, String xCostCard) {
		super();
		assert manaCost!=null;
		if (manaCost!=null) {
			this.manaCost = Integer.parseInt(manaCost);
		}
			
		if (legalCastPositions!=null&&legalTargetPositions!=null) {
			int[] lcP= toArray(legalCastPositions);
			int[] ltP=toArray(legalTargetPositions);
			for(int i=0; i<5;i++) {
				if (lcP[i]==0) {
					this.legalCastPositions[i] = false;
				}
				if (ltP[i]==0){
					this.legalTargetPositions[i] = false;
				}
			}
		}		
		this.name = name;
		if (accuracy!=null) {
			this.accuracy = Integer.parseInt(accuracy);
		}
		if (critChance!=null) {//unused
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
		//
		if (effect!=null) {
			allEffects.add(EffectBuilder.buildEffect(new EffectParameters(effect)));
		}
		if (effect2!=null) {
			allEffects.add(EffectBuilder.buildEffect(new EffectParameters(effect2)));
		}
		if (effect3!=null) {
			allEffects.add(EffectBuilder.buildEffect(new EffectParameters(effect3)));
		}
		if (effect4!=null) {
			allEffects.add(EffectBuilder.buildEffect(new EffectParameters(effect4)));
		}
		if (effect5!=null) {
			allEffects.add(EffectBuilder.buildEffect(new EffectParameters(effect5)));
		}
		if (castConditions!=null) {
			this.castConditions.add(CastConditionBuilder.buildCastCondition(castConditions));
		}
		if (xCostCard!=null) {
			this.xCostCard=true;
		}
		//
		if (isFriendly!=null) {
			if (Integer.parseInt(isFriendly)!=0) {
				this.isFriendly = true;
			}
		}
		
		if (text!=null) {
			this.text=text;
		}
	}
	public int[] toArray( String s ) {
	   if ( s == null ) {
	     return null;
	   }
	   int len = s.length();
	   int[] array = new int[len];
	   for (int i = 0; i < len ; i++) {
	      array[i] = Integer.parseInt(""+s.charAt(i));
	   }
	   return array;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public boolean applyEffect(Hero self) {
		//keep going through effects until fail
		
		boolean previousSuccess=true;
		for (int i=0; i<allEffects.size();i++) {
			if (previousSuccess) {
				previousSuccess=allEffects.get(i).applyEffect(self,this);				
			}			
		}
		//poison
		if(self.poison>0) {
			if(Math.random()>self.resistPoison/100.0) {
				self.poison+=manaCost;
			}			
		}
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
	public LinkedList<String> getCardText(Hero hero) {
		LinkedList<String> cardText = new LinkedList<String>();
		for (Iterator iterator = allEffects.iterator(); iterator.hasNext();) {
			CardEffect cardEffect = (CardEffect) iterator.next();
			cardText.add(cardEffect.generateCardText(hero, this));
		}
		if (critChance>0) {
			cardText.add("crit chance: +"+critChance);
		}
		if (accuracy>0) {
			cardText.add("accuracy: "+(accuracy+GameEquations.accuracyCalc(hero,hero.getTarget())));
		}
		if (cardText.size()==0) {
			System.out.println("empty card has been built!!!");
		}
		return cardText;
	}
	@Override
	public boolean extraCastConditions(Hero hero) {
		for (int i = 0; i < castConditions.size(); i++) {
			if (!castConditions.get(i).checkCondition(hero)) {
				hero.getPlayer().getGame().log.addLine(castConditions.get(i).explanation);
				return false;
			}
		}
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setFriendly(boolean isFriendly) {
		this.isFriendly = isFriendly;
	}

	public LinkedList<CardEffect> getAllEffects() {
		return allEffects;
	}

	public void setAllEffects(LinkedList<CardEffect> allEffects) {
		this.allEffects = allEffects;
	}
			
	
}
