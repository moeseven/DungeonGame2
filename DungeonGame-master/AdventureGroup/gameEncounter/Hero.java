package gameEncounter;

import java.util.Collections;
import java.util.LinkedList;

public abstract class Hero {

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
	//stats
	protected ModableHeroStats stats;			
	protected Deck deck;	
	private int thorns;
	protected int draw;
	protected int manaPower;
	public int armor;
	protected int blockSkill;
	protected int attackSkill;
	protected int maxHp;
	//current values
	private LinkedList<Card> drawPile;
	private int mana;
	protected int hp;
	private int block;
	private LinkedList<Card> hand;
	//
	public Hero(){
		this.initialize();
		stats=new ModableHeroStats();
	}
	public void initialize() {
		thorns=0;
		isDead=false;
		isReady=false;
		inventory= new LinkedList<Item>();
		equipment= new Equipment(this);
	}
	//functions
	public void setUpHandPile() {
		//shuffle + new hand
		this.hand=new LinkedList<Card>();
		this.setDrawPile(new LinkedList<Card>());
		for(Card c: this.getDeck().getCards()) {
	    	this.getDrawPile().add(c);
	    }
		Collections.shuffle(this.getDrawPile());
	}
	public void turnBegin(){
		this.discardHand();
		this.block=armor;
		this.mana=manaPower;
		for(int i=0; i<draw;i++) {
			this.hand.add(drawPile.removeFirst());
		}	
	}
	public void block(int block) {
		this.block+=block;
	}
	public void dealDamage(Hero hero,int damage) {
		hero.takeDamage(this,damage);
	}
	public void takeDamage(Hero hero,int damage) {
		hero.takeThornDamage(this, thorns);//thorns
		int hpDamage=block-damage;
		if(hpDamage<0) {
			this.setHp(hp+hpDamage);
			block=0;
		}else {
			this.setBlock(block-damage);
		}
		if(hp<=0) {
			hp=0;
			this.die();
		}
	}
	public void takeThornDamage(Hero hero,int damage) {//prevent infinite thorn looping
		int hpDamage=block-damage;
		if(hpDamage<0) {
			this.setHp(hp+hpDamage);
			block=0;
		}else {
			this.setBlock(block-damage);
		}
		if(hp<=0) {
			hp=0;
			this.die();
		}
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
	//getters and setters
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
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
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
	
}
