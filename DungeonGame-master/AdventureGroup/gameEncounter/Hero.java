package gameEncounter;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

import game.CharacterClass;
import game.CharacterRace;
import game.DungeonMaster;
import game.Player;
import game.RoomInteractionLibrary.StandardCorpse;
import gameEncounter.CardLibrary.BleedingSlice;
import gameEncounter.ItemLibrary.usables.HealingPotion;
import gameEncounter.buffLibrary.Bashed;

public class Hero implements Serializable{

	//private LinkedList<Item> inventory;
	private LinkedList<Buff> buffs;
	private LinkedList<HeroQuirk> quirks=new LinkedList<HeroQuirk>();;
	private LinkedList<Card> lvlUpCards=new LinkedList<Card>();
	private Equipment equipment;
	protected String name;
	protected int gold;
	protected int experience;	
	protected int experienceValue;
	protected int level=0;
	protected int skillPoints=0;
	protected int cardPoints=0;
	protected Player player;
	//game
	private boolean isReady;
	//Fight
	private Fight fight;
	private Hero target;
	private Card selectedCard;
	private Item selectedItem;
	private boolean isDead;
	protected boolean good;
	//type
	protected CharacterClass charClass;
	protected CharacterRace charRace;
	//stats
	protected int speed;
	protected ModableHeroStats stats;			
	protected Deck deck;	
	private int thorns;
	protected int draw;
	protected int manaPower;
	public int armor;
	public int accuracy;//vs dodge
	public int dodge;
	protected int attackSkill;// vs block skill
	protected int blockSkill;
	protected int spellPower;//vs spell resist
	protected int spellResist;
	//resistance
	protected int resistFire;
	protected int resistCold;
	protected int resistPoison;	
	protected int resistBleed;
	protected int resistStun;
	protected int resistStress;
	protected int trapDisarm;
	//
	protected int baseHp;
	protected int strength;
	protected int vitality;
	protected int dexterity;
	protected int intelligence;
	//status
	protected boolean stunned;
	protected int bleed;
	protected int poison;
	protected int cold;
	//current values
	private int currentSpeed;
	private LinkedList<Card> drawPile;
	private LinkedList<Card> discardPile;
	private int mana;
	protected int hp;
	protected int stress=0;
	protected int stressCap=100;
	private int block;
	private LinkedList<Card> hand;
	//
	public Hero(String name,Player player, CharacterRace charRace,CharacterClass charClass){		
		//order is important here
		basicStats();
		this.player=player;
		this.charRace=charRace;
		this.charClass=charClass;
		buffs= new LinkedList<Buff>();
		equipment= new Equipment(this);			
		deck=new Deck();
		charRace.modifyHero(this);
		if(charClass!=null) {
			charClass.modifyHero(this);	
		}
	
		if(!name.equals("")&&!name.equals("type name here")) {
			this.name=name;
		}			
		stats=new ModableHeroStats();
		this.initialize();
	}
	private void basicStats() {
		//set here basic values for stats
		//attributes		
		setStrength(10);
		setDexterity(10);
		setIntelligence(10);
		setVitality(10);
		//base stats	
		setAttackSkill(10);
		setBlockSkill(10);
		setAccuracy(10);
		setDodge(10);
		setSpellPower(10);
		setSpellResist(10);
		setBaseHp(100);
		setSpeed(10);
		//other
		resistFire=5;
		resistPoison=5;
		resistCold=5;
		resistBleed=5;
		resistStun=5;
		resistStress=5;
		trapDisarm=5;
		setArmor(0);
		setManaPower(2);
		setDraw(3);		
		setExperienceValue(10);
	}
	public void initialize() {		
		isDead=false;
		isReady=false;	
		hp=computeMaxHp();
	}
	//functions
	public void setUpHandPile() {
		//shuffle
		hand=new LinkedList<Card>();
		drawPile=new LinkedList<Card>();
		discardPile=new LinkedList<Card>();
		for(Card c: this.getDeck().getCards()) {
	    	this.getDrawPile().add(c);
	    }
		Collections.shuffle(this.getDrawPile());
	}
	public void drawCard() {
		if(drawPile.size()==0) {
			drawPile=discardPile;
			Collections.shuffle(this.getDrawPile());
			discardPile=new LinkedList<Card>();
		}
		if(drawPile.size()>0) {
			hand.add(drawPile.removeFirst());
		}else {
			player.getGame().log.addLine("no more cards in draw Pile!");
		}
	}
	public void applyNegativeTurnEffects() {
		//poison TODO not working properly
		if(poison>0) {	
			poison-=1;		
			takePoisonDamage(5);			
		}		
		//bleed
		if(bleed>0) {
			takeBleedDamage(getBleed());
			bleed-=1;
		}
		//cold
		if(cold>0) {
			cold-=1;
		}		

	}
	public void turnBegin(){
		if(!isDead) {
			applyNegativeTurnEffects();
			this.discardHand();
			this.block=0;
			this.mana=manaPower;
			for(int i=0; i<draw;i++) {
				drawCard();
			}
			this.buffTick();
			if(stunned) {
				mana=0;
				this.discardHand();
				player.getGame().log.addLine(name+" is stunned!");
				stunned=false;
			}		
			if(hand.size()!=0) {
				setSelectedCard(hand.getFirst());	
			}							
		}				
	}
	public void block(int block) {
		player.getGame().log.addLine(name+" blocks for "+block);
		this.block+=block;
	}
	//Cast spell
	public boolean castSpellOnHero(Hero hero) {
		if(GameEquations.resist(this, hero)) {
			return false;
		}else {
			return true;
		}
	}
	//Attack stages dodge-block-armor-hp
	public boolean attackHero(Hero hero) {
		//TODO check Block and Dodge
		if(!GameEquations.dodge(this, hero)) {
			return true;			
		}else {
			return false;
		}		
	}
	public void breachBlock(Hero hero, int damage) {
		 hero.takeArmorDamage(this,GameEquations.breachBlock(this, hero, damage));
	}
	public int dealWeaponDamage(Hero hero, Item item, double mult) {//weapon damage str dependant or dexterity dependant
		int dmg;
		 if(item instanceof Weapon) {
			 Weapon weapon= (Weapon) item;
			 dmg=(int)(mult*weapon.computeAttackDamage(strength,dexterity));
		 }else {
			 dmg=(int)(mult*GameEquations.FistDamage(strength));
			 getPlayer().getGame().log.addLine("fistpunch");
		 } 
		 breachBlock(hero, dmg);
		 return dmg;		
	}
	public void dealDamage(Hero hero,int damage) {
		hero.takeArmorDamage(this,damage);
	}
	public void takeArmorDamage(Hero damagingHero,int damage) {
		damagingHero.takeUnreflectableArmorDamage(this, thorns);//thorns
		this.takeUnreflectableArmorDamage(damagingHero, damage);
	}
	public void takeDamage(Hero damagingHero, int damage){
		if(damage>0) {
			player.getGame().log.addLine(damagingHero.getName()+" deals "+damage+" damage to "+name);
			this.setHp(hp-damage);
			if(hp<=0) {
				hp=0;
				this.die();
			}
		}		
	}
	public void takeBleedDamage(int damage) {
		if(damage>0) {
			player.getGame().log.addLine(name+" bleeds for "+damage+" hp.");
			this.setHp(hp-damage);
			if(hp<=0) {
				hp=0;
				this.die();
			}
		}
	}
	public void takePoisonDamage(int damage) {
	
		if(damage>0) {
			int poisondamage=(int) Math.max(1, damage*(1-resistPoison/100.0));
			player.getGame().log.addLine(name+" suffers poison damage of "+poisondamage+".");
			this.setHp(hp-poisondamage);
			if(hp<=0) {
				hp=0;
				this.die();
			}
		}
	}
	public void takeUnreflectableArmorDamage(Hero damagingHero,int damage) {//prevent infinite thorn looping
		int armorDamage=GameEquations.damageReducedByArmor(damage, armor);
		takeDamage(damagingHero, armorDamage);
	}

	public void die() {
		//handle death //toughness rolls/receiving wounds?
		if(!isDead) {
			player.getGame().log.addLine(name+ " died!");
			player.getGame().getRoom().getInteractions().add(new StandardCorpse(this)); //generate corpses
			block=0;
			this.isDead=true;
			for(int i=0;i<player.getHeroes().size();i++) {
				player.getHeroes().get(i).becomeStressed(35);
			}			
		}else {
			player.getGame().log.addLine(name+ " allready dead");
		}		
	}
	public void loot(Hero looted) {		
		looted.getLooted(this);
	}
	public void getLooted(Hero looter) {
		//this is the loot table of this monster
		looter.getPlayer().gainGold(gold);
		gold=0;
		getPlayer().getGame().log.addLine(name+" got looted");
	}
	public void discardHand() {
		while(hand.size()>0) {
			discardPile.add(hand.removeFirst());
		}		
	}
	public void heal(int heal) {//prevent overhealing
		int healing= Math.min(heal, computeMaxHp()-getHp());
		this.setHp(this.getHp()+healing);
		player.getGame().log.addLine(name+" healed for "+healing+" hp");		
	}
	public boolean targetInRange(Hero target2, int range) {
		//this seems to not work for targeting own heroes
		if(this.getPlayer()!=target2.getPlayer()) {
			if(player.getHeroes().indexOf(this)+target2.getPlayer().getHeroes().indexOf(target2)<range) {
				return true;
				}else {
					if(getPlayer() instanceof DungeonMaster) {						
					}else {
						getPlayer().getGame().log.addLine("target out of Range!");	
					}
					return false;
				}			
		}else {
			return true;
		}					
	}
	//move
	public void moveForward() {
		int startPosition = getPosition();
		player.getHeroes().remove(this);
		player.getHeroes().addFirst(this);
		for(int i=startPosition-1; i>0;i--){
			Hero removedHero=player.getHeroes().remove(startPosition-1);
			player.getHeroes().addFirst(removedHero);
		}
	}
	public void moveBack() {
		int startPosition = getPosition();
		player.getHeroes().remove(this);
		player.getHeroes().addLast(this);
		for(int i=startPosition; i<player.getGroupSize()-3;i++){
			Hero removedHero=player.getHeroes().remove(startPosition+1);
			player.getHeroes().addLast(removedHero);
		}
	}
	//cleansing
	public void cleanseHero() {
		removeBuffs();
		bleed=0;
		poison=0;
		cold=0;
		
	}
	//Buffs
	public void buffHero(Buff buff) {
		buffs.add(buff);
	}
	public void removeBuffs() {
		LinkedList<Buff> debuffing=new LinkedList<Buff>();
		for(int i=0; i<buffs.size();i++) {
			debuffing.add(buffs.get(i));
		}
		for(int i=0; i<debuffing.size();i++) {
			debuffing.get(i).removeBuff(this);
		}
	}
	public void buffTick() {
		LinkedList<Buff> tick=new LinkedList<Buff>();
		for(int i=0; i<buffs.size();i++) {
			tick.add(buffs.get(i));
		}
		for(int i=0; i<tick.size();i++) {
			tick.get(i).tick(this);
		}
	}
	public void gainExp(int exp) {	
		//int t=GameEquations.experienceThresholdForLevelUp(level);
		int expToNextLvl=GameEquations.experienceThresholdForLevelUp(level)-experience;
		if(expToNextLvl<exp) {
			experience=GameEquations.experienceThresholdForLevelUp(level);
			levelUP();		
			gainExp(exp-expToNextLvl);
		}else {
			experience+=exp;
		}
	}
	public void levelUP() {
		level+=1;
		strength+=1;dexterity+=1;intelligence+=1;vitality+=1;
		stressCap+=5;
		skillPoints+=1;
		if(cardPoints==0) {
			generatelvlUpCards();
		}
		cardPoints+=1;
		player.getGame().log.addLine(this.getName()+" leveled up to level "+level);		
	}
	public void generatelvlUpCards() {
		lvlUpCards=new LinkedList<Card>();
		for(int i=0; i<3;i++) {//cards should be cloned
			try {
				lvlUpCards.add((Card) charClass.getCardPool().get(Math.min(charClass.getCardPool().size()-1,(int)(Math.random()*charClass.getCardPool().size()))).clone());
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	//
	public void becomeStressed(int s) {
		if(!isDead) {
			int sDamage=(int)(s*(1-resistStress/100));
			stress+=sDamage;
			player.getGame().log.addLine(name+" gets stressed for "+sDamage+" stress!");
			if(stress>stressCap) {
				stress=stressCap;
				if(player instanceof DungeonMaster) {
					player.getGame().log.addLine(getName()+" flees in fear!");
				}else {
					player.getGame().log.addLine(getName()+"is stressed out ("+stressCap+") and will not continue adventuring with that much stress!");
				}			
			}else {
				if(stress<0) {
					stress=0;
				}
			}
		}				
	}
	//////
	//bleed/poison/fire/cold/stun
	public boolean bleed(int bleedAmount) {
		if(Math.random()<resistBleed/100.0) {
			player.getGame().log.addLine(name+" resisted bleeding");
			return false;
		}else {
			bleed+=bleedAmount;
			player.getGame().log.addLine(name+" bleeds");
			return true;
		}
	}
	public boolean poison(int poisonAmount) {
		if(Math.random()<resistPoison/100.0) {
			player.getGame().log.addLine(name+" resisted poison");
			return false;
		}else {
			poison+=poisonAmount;
			player.getGame().log.addLine(name+" got poisoned");
			return true;
		}		
	}
	//elemental damage
	public void takeFireDamage(Hero damagingHero, int damage) {
		int fireDamage=(int)(damage*(1-resistFire/100.0));
		damagingHero.getPlayer().getGame().log.addLine("fire damage:");
		takeDamage(damagingHero,fireDamage);
	}
	public void takeColdDamage(Hero damagingHero, int damage) {
		int coldDamage=(int)(damage*(1-resistCold/100.0));
		cold+=coldDamage;
		damagingHero.getPlayer().getGame().log.addLine("cold damage:");
		takeDamage(damagingHero,coldDamage);
	}
	//stun
	public boolean takeStun() {
		if(Math.random()>resistStun/100.0) {
			stunned=true;
			buffHero(new Bashed());
			return true;
		}else {
			return false;
		}
	};
	//
	//compute functions with cold effect
	public int computeAccuracy() {
		return GameEquations.dodgeCalc(accuracy, dexterity)-cold/2;
	}
	public int computeDodge() {
		return GameEquations.dodgeCalc(dodge, dexterity)-cold/2;
	}
	public int computeAttackSkill() {
		return GameEquations.blockAttackSkillCalc(attackSkill, strength, dexterity);
	}
	public int computeBlockSkill() {
		return GameEquations.blockAttackSkillCalc(blockSkill, strength, dexterity);
	}
	public int computeSpellPower() {
		return GameEquations.spellPowerCalc(spellPower, intelligence)-cold/2;
	}
	public int computeSpellResist() {
		return GameEquations.spellPowerCalc(spellResist, intelligence)-cold/2;
	}
	public int computeMaxHp() {
		return GameEquations.maxHealthCalc(baseHp, vitality);
	}
	public int computeSpeed() {
		return GameEquations.speedCalc(speed, dexterity)-cold/2;
	}
	
	
	public int rollSpeed() {
		currentSpeed=GameEquations.speedRoll(computeSpeed());
		return currentSpeed;
	}

	//A all stats to String method might be handy for gui

	//
	public int getPosition() {
		return player.getHeroes().indexOf(this);
	}
	//Getters and Setters
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getExperienceValue() {
		return experienceValue;
	}
	public void setExperienceValue(int experienceValue) {
		this.experienceValue = experienceValue;
	}
	public boolean isReady() {
		return isReady;
	}
	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public Hero getTarget() {
		return target;
	}
	public void setTarget(Hero target) {
		this.target = target;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Deck getDeck() {
		return deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getManaPower() {
		return manaPower;
	}
	public void setManaPower(int manaPower) {
		this.manaPower = manaPower;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getBlockSkill() {
		return blockSkill;
	}
	public void setBlockSkill(int blockSkill) {
		this.blockSkill = blockSkill;
	}
	public int getAttackSkill() {
		return attackSkill;
	}
	public void setAttackSkill(int attackSkill) {
		this.attackSkill = attackSkill;
	}
	public Fight getFight() {
		return fight;
	}
	public void setFight(Fight fight) {
		this.fight = fight;
	}
	public LinkedList<Card> getDrawPile() {
		return drawPile;
	}
	public void setDrawPile(LinkedList<Card> drawPile) {
		this.drawPile = drawPile;
	}
	public LinkedList<Card> getHand() {
		return hand;
	}
	public void setHand(LinkedList<Card> hand) {
		this.hand = hand;
	}
	public Card getSelectedCard() {
		return selectedCard;
	}
	public void setSelectedCard(Card selectedCard) {
		this.selectedCard = selectedCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGood() {
		return good;
	}
	public void setGood(boolean isgood) {
		this.good = isgood;
	}
	public Item getSelectedItem() {
		return selectedItem;
	}
	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}
	public int getThorns() {
		return thorns;
	}
	public void setThorns(int thorns) {
		this.thorns = thorns;
	}
//	public LinkedList<Item> getInventory() {
//		return inventory;
//	}
//	public void setInventory(LinkedList<Item> inventory) {
//		this.inventory = inventory;
//	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getCurrentSpeed() {
		return currentSpeed;
	}
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}
	public CharacterClass getCharClass() {
		return charClass;
	}
	public CharacterRace getCharRace() {
		return charRace;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getVitality() {
		return vitality;
	}
	public void setVitality(int vitality) {
		this.vitality = vitality;
	}
	public int getDexterity() {
		return dexterity;
	}
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public LinkedList<Card> getDiscardPile() {
		return discardPile;
	}
	public void setDiscardPile(LinkedList<Card> discardPile) {
		this.discardPile = discardPile;
	}
	public int getBaseHp() {
		return baseHp;
	}
	public void setBaseHp(int baseHp) {
		this.baseHp = baseHp;
	}
	public void setDodge(int dodge) {
		this.dodge = dodge;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public int getDodge() {
		return dodge;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getSpellPower() {
		return spellPower;
	}
	public void setSpellPower(int spellPower) {
		this.spellPower = spellPower;
	}
	public int getSpellResist() {
		return spellResist;
	}
	public void setSpellResist(int spellResist) {
		this.spellResist = spellResist;
	}
	public LinkedList<Buff> getBuffs() {
		return buffs;
	}
	public void setBuffs(LinkedList<Buff> buffs) {
		this.buffs = buffs;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getSkillPoints() {
		return skillPoints;
	}
	public void setSkillPoints(int skillPoints) {
		this.skillPoints = skillPoints;
	}
	public int getResistFire() {
		return resistFire;
	}
	public void setResistFire(int resistFire) {
		this.resistFire = resistFire;
	}
	public int getResistCold() {
		return resistCold;
	}
	public void setResistCold(int resistCold) {
		this.resistCold = resistCold;
	}
	public int getResistPoison() {
		return resistPoison;
	}
	public void setResistPoison(int resistPoison) {
		this.resistPoison = resistPoison;
	}
	public int getResistBleed() {
		return resistBleed;
	}
	public void setResistBleed(int resistBleed) {
		this.resistBleed = resistBleed;
	}
	public int getResistStun() {
		return resistStun;
	}
	public void setResistStun(int resistStun) {
		this.resistStun = resistStun;
	}
	public LinkedList<Card> getLvlUpCards() {
		return lvlUpCards;
	}
	public void setLvlUpCards(LinkedList<Card> lvlUpCards) {
		this.lvlUpCards = lvlUpCards;
	}
	public int getCardPoints() {
		return cardPoints;
	}
	public void setCardPoints(int cardPoints) {
		this.cardPoints = cardPoints;
	}
	public int getBleed() {
		return bleed;
	}
	public void setBleed(int bleed) {
		this.bleed = bleed;
	}
	public int getPoison() {
		return poison;
	}
	public void setPoison(int poison) {
		this.poison = poison;
	}
	public int getCold() {
		return cold;
	}
	public void setCold(int cold) {
		this.cold = cold;
	}
	public int getStress() {
		return stress;
	}
	public int getStressCap() {
		return stressCap;
	}
	public void setStressCap(int stressCap) {
		this.stressCap = stressCap;
	}
	public int getTrapDisarm() {
		return trapDisarm;
	}
	public void setTrapDisarm(int trapDisarm) {
		this.trapDisarm = trapDisarm;
	}
	public int getResistStress() {
		return resistStress;
	}
	public void setResistStress(int resistStress) {
		this.resistStress = resistStress;
	}
	public void setStunned(boolean stunned) {
		this.stunned = stunned;
	}
	public LinkedList<HeroQuirk> getQuirks() {
		return quirks;
	}
	public void setQuirks(LinkedList<HeroQuirk> quirks) {
		this.quirks = quirks;
	}
	public void setStress(int stress) {
		this.stress = stress;
	}	
	
}
