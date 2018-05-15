package gameEncounter;

import java.util.Collections;
import java.util.LinkedList;

public abstract class Hero {

	private Backpack backpack;
	private Equipment inventory;
	protected String name;
	protected int gold;
	protected int experience;
	protected Deck deck;
	protected int experienceValue;
	//game
	private boolean isReady;
	//Fight
	private Fight fight;
	private Hero target;
	private Card selectedCard;
	private boolean isDead;
	protected boolean good;
	//stats
	protected int hp;
	private int mana;
	private int block;
	private LinkedList<Card> drawPile;
	private LinkedList<Card> hand;
	//skills
	protected int turnDraw;
	protected int turnMana;
	public int turnBlock;
	private int blockBonus;
	private int attackBonus;
	protected int maxHp;
	public Hero(){
		this.initialize();
	}
	public void initialize() {
		isDead=false;
		isReady=false;
		backpack= new Backpack(this);
		inventory= new Equipment(this);
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
		this.block=turnBlock;
		this.mana=turnMana;
		for(int i=0; i<turnDraw;i++) {
			this.hand.add(drawPile.removeFirst());
		}	
	}
	public void blockWithBonus(int block) {
		this.block+=block+this.blockBonus;
	}
	public void block(int block) {
		this.block+=block;
	}
	public void dealAttackDamage(Hero hero, int damage) {
		hero.takeDamage(hero, damage+this.attackBonus);
	}
	public void dealDamage(Hero hero,int damage) {
		hero.takeDamage(hero,damage);
	}
	public void takeDamage(Hero hero,int damage) {
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
	
	public Backpack getBackpack() {
		return backpack;
	}
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
	public int getAttackBonus() {
		return attackBonus;
	}
	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}
	public Hero getTarget() {
		return target;
	}
	public void setTarget(Hero target) {
		this.target = target;
	}
	public void setBackpack(Backpack backpack) {
		this.backpack = backpack;
	}
	public Equipment getInventory() {
		return inventory;
	}
	public void setInventory(Equipment inventory) {
		this.inventory = inventory;
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
	public int getTurnDraw() {
		return turnDraw;
	}
	public void setTurnDraw(int turnDraw) {
		this.turnDraw = turnDraw;
	}
	public int getTurnMana() {
		return turnMana;
	}
	public void setTurnMana(int turnMana) {
		this.turnMana = turnMana;
	}
	public int getTurnBlock() {
		return turnBlock;
	}
	public void setTurnBlock(int turnBlock) {
		this.turnBlock = turnBlock;
	}
	public int getBlockBonus() {
		return blockBonus;
	}
	public void setBlockBonus(int blockBonus) {
		this.blockBonus = blockBonus;
	}
	public int getDamageBonus() {
		return attackBonus;
	}
	public void setDamageBonus(int damageBonus) {
		this.attackBonus = damageBonus;
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
	
}
