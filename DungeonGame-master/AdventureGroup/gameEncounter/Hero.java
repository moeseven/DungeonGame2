package gameEncounter;

import java.util.Collections;
import java.util.LinkedList;

import game.CharacterClass;
import game.CharacterRace;
import game.Player;

public class Hero {

	private LinkedList<Item> inventory;
	private Equipment equipment;
	protected String name;
	protected int gold;
	protected int experience;	
	protected int experienceValue;
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
	public int dodge;//TODO
	protected int attackSkill;// vs block skill
	protected int blockSkill;
	//protected int maxHp;
	protected int baseHp;
	protected int strength;
	protected int vitality;
	protected int dexterity;
	protected int intelligence;
	//current values
	private int currentSpeed;
	private LinkedList<Card> drawPile;
	private LinkedList<Card> discardPile;
	private int mana;
	protected int hp;
	private int block;
	private LinkedList<Card> hand;
	//
	public Hero(String name,Player player, CharacterRace charRace,CharacterClass charClass){
		this.name=name;
		this.charRace=charRace;
		this.charClass=charClass;
		this.inventory=player.getInventory();
		stats=new ModableHeroStats();
		this.initialize();
	}
	public void initialize() {
		setDeck(new Deck());
		isDead=false;
		isReady=false;
		equipment= new Equipment(this);
		deck=new Deck();
		charRace.modifyHero(this);
		charClass.modifyHero(this);
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
		hand.add(drawPile.removeFirst());
	}
	public void turnBegin(){
		this.discardHand();
		this.block=0;
		this.mana=manaPower;
		for(int i=0; i<draw;i++) {
			drawCard();
		}
		this.setSelectedCard(hand.getFirst());
	}
	public void block(int block) {
		this.block+=block;
	}
	//Attack stages dodge-block-armor-hp
	public boolean attackHero(Hero hero) {
		//TODO check Block and Dodge
		if(!GameEquations.dodge(this, hero)) {
			if(breachBlock(hero)) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}		
	}
	public boolean breachBlock(Hero hero) {
		if(!GameEquations.block(this, hero)) {
			return true;
		}else {
			return false;
		}
	}
	public boolean dealWeaponDamage(Hero hero, Item item) {//weapon damage str dependant or dexterity dependant
		boolean success=false;
		 if(item instanceof Weapon) {
			 Weapon weapon= (Weapon) item;
			 int dmg=weapon.computeAttackDamage(strength);
			 hero.takeArmorDamage(this, dmg);
			 success=true;
		 }else {
			 int dmg=GameEquations.FistDamage(strength);
			 hero.takeArmorDamage(this, dmg);
			 success=true;
		 }
		 return success;		
	}
	public void dealDamage(Hero hero,int damage) {
		hero.takeArmorDamage(this,damage);
	}
	public void takeArmorDamage(Hero damagingHero,int damage) {
		damagingHero.takeUnreflectableArmorDamage(this, thorns);//thorns
		this.takeUnreflectableArmorDamage(damagingHero, damage);
	}
	public void takeDamage(Hero damagingHero, int damage){
		this.setHp(hp-damage);
		if(hp<=0) {
			hp=0;
			this.die();
		}
	}
	public void takeUnreflectableArmorDamage(Hero damagingHero,int damage) {//prevent infinite thorn looping
		int armorDamage=GameEquations.damageReducedByArmor(damage, armor);
		takeDamage(damagingHero, armorDamage);
	}
	public void die() {
		//handle death //toughness rolls/receiving wounds?
		this.isDead=true;
	}
	public void loot(Hero looter) {
		//this is the loot table of this monster
	}
	public void discardHand() {
		while(hand.size()>0) {
			drawPile.add(hand.removeFirst());
		}		
	}
	//compute functions
	public int computeAccuracy() {
		return GameEquations.accuracyCalc(accuracy, dexterity);
	}
	public int computeDodge() {
		return GameEquations.dodgeCalc(dodge, dexterity);
	}
	public int computeAttackSkill() {
		return GameEquations.blockAttackSkillCalc(attackSkill, strength, dexterity);
	}
	public int computeBlockSkill() {
		return GameEquations.blockAttackSkillCalc(blockSkill, strength, dexterity);
	}
	public int computeMaxHp() {
		return GameEquations.maxHealthCalc(baseHp, vitality);
	}
	public int computeSpeed() {
		return GameEquations.speedCalc(speed, dexterity);
	}
		
	public int rollSpeed() {
		currentSpeed=GameEquations.speedRoll(computeSpeed());
		return currentSpeed;
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
	public LinkedList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(LinkedList<Item> inventory) {
		this.inventory = inventory;
	}
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
	
}
