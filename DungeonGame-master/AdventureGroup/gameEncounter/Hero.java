package gameEncounter;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;

import game.CharacterClass;
import game.CharacterRace;
import game.DungeonMaster;
import game.Player;
import game.RoomInteractionLibrary.StandardCorpse;
import gameEncounter.CardLibrary.Status.Wound;
import gameEncounter.HeroQuirkLibrary.Bleeder;
import gameEncounter.buffLibrary.Bashed;

public class Hero implements Serializable{

	//private LinkedList<Item> inventory;
	private int  cardsPlayedThisRound=0;
	private boolean isSummon=false;
	private int imageScale=3;
	private LinkedList<Buff> buffs;
	private LinkedList<HeroQuirk> quirks=new LinkedList<HeroQuirk>();;
	private LinkedList<Card> lvlUpCards=new LinkedList<Card>();
	private Equipment equipment;
	protected String name;
	//protected BufferedImage image;
	protected int imageNumber;
	protected int gold;
	protected int experience;	
	protected int experienceValue;
	protected int level=0;
	protected int skillPoints=0;
	protected int cardPoints=0;
	protected Player player;
	protected int maxHandSize=10;
	//game
	private boolean isReady;
	//Fight
	private Fight fight;
	private Hero target;
	private LinkedList<Hero> targets;
	private Card selectedCard;
	private Item selectedItem;
	private boolean isDead;
	protected boolean good;
	//type
	protected CharacterClass charClass;
	protected CharacterRace charRace;
	protected ModableHeroStats stats;
	/////stats//////
	protected int speed;				
	protected Deck deck;	
	private int thorns;
	protected int draw;
	protected int manaPower;
	public int armor;
	public int accuracy;//vs dodge
	public int dodge;
	protected int critChance=4;
	protected int critDamage=10;
	protected int attackSkill;
	protected int blockSkill;
	protected int spellPower;
	protected int spellDuration;
	protected int turnBlock=0;
	//elemental bonus
	protected int stunChance;
	protected int fireDmg;
	protected int coldDmg;
	protected int lightningDmg;
	protected int poisonDmg;
	protected int bleedDmg;
	protected int magicDmg;
	//resistance
	protected int resistSpell; // for magic dmg and curse mitigation
	protected int resistFire;
	protected int resistLightning;
	protected int resistCold;
	protected int resistPoison;	
	protected int resistBleed;
	protected int resistStun;
	protected int resistStress;	
	//
	protected int trapDisarm;
	protected int baseHp;
	protected int strength;
	protected int vitality;
	protected int dexterity;
	protected int intelligence;
	protected int stressCap=100;
	////
	//status
	protected boolean stunned;
	protected int bleed;
	protected int poison;
	protected int cold;
	protected int fire;
	protected int shock;
	protected int wounds=0;
	//current values
	private int currentSpeed;
	private LinkedList<Card> drawPile;
	private LinkedList<Card> discardPile=new LinkedList<Card>();
	private int mana;
	protected int hp;
	protected int stress=0;	
	private int block;
	private LinkedList<Card> hand;
	//
	public Hero(String name,Player player, CharacterRace charRace,CharacterClass charClass){		
		//order is important here		
		this.player=player;
		basicStats();
		this.charRace=charRace;
		this.charClass=charClass;
		buffs= new LinkedList<Buff>();
		equipment= new Equipment(this);			
		deck=new Deck();
		charRace.modifyHero(this);			
		if(!name.equals("")&&!name.equals("type name here")) {
			this.name=name;
		}
		if(charClass!=null) {
			charClass.modifyHero(this);	
		}			
		stats=new ModableHeroStats();
		this.initialize();
	}
	private void basicStats() {
		//set here basic values for stats
//		if(player!=null) {//basic image
//			image = player.getGame().imageLoader.getImage(121);
//		}else {
//			image = null;
//		}
		imageNumber=1;
		//attributes		
		setStrength(6);
		setDexterity(6);
		setIntelligence(6);
		setVitality(6);
		//base stats	
		setAttackSkill(6);
		setBlockSkill(6);
		setAccuracy(6);
		setDodge(6);
		setSpellPower(6);
		setBaseHp(80);
		setSpeed(7);
		setCritChance(3);
		setCritDamage(20);
		//other
		resistSpell =4;
		resistFire=3;
		resistLightning=3;
		resistPoison=3;
		resistCold=3;
		resistBleed=3;
		resistStun=3;
		resistStress=3;
		trapDisarm=5;
		setArmor(0);
		setManaPower(2);
		setDraw(3);		
		spellDuration=3;
		setExperienceValue(10);
	}
	public void initialize() {			
		isDead=false;
		isReady=false;	
		hp=GameEquations.maxHealthCalc(this);
	}
	//functions
	public void setUpDrawPile() {
		//shuffle
		hand=new LinkedList<Card>();
		drawPile=new LinkedList<Card>();
		discardPile=new LinkedList<Card>();
		for(Card c: this.getDeck().getCards()) {
	    	this.getDrawPile().add(c);
	    }
		for(int i=0;i<wounds;i++) {
			drawPile.add(new Wound());
		}
		Collections.shuffle(drawPile);
	}
	public void drawCard() {
		if (hand.size()<maxHandSize) {
			if(drawPile.size()==0) {
				
				drawPile=discardPile;
				Collections.shuffle(drawPile);
				discardPile=new LinkedList<Card>();
			}
			if(drawPile.size()>0) {	
				Card card=drawPile.removeFirst();
				//on draw card effects
				for (int i = 0; i < card.drawEffects.size(); i++) {
					card.drawEffects.get(i).applyEffect(this, card);
				}
				hand.add(card);		
			}else {
				player.getGame().log.addLine("no more cards in draw Pile!");
			}
		}else {
			player.getGame().log.addLine("cant draw more cards!");
		}
	}
	public void applyNegativeTurnEffects() {
		//poison
		if(poison>0) {		//poison increases when using mana		
			poison+=1;
			sufferPoison();						
		}		
		//bleed
		if(bleed>0) {
			if(Math.random()<resistBleed/100) {
				bleed-=1;
			}
			sufferBleeding();
			bleed-=1;
		}
		//fire
		if (fire>5) {
			fire=(int) (fire*0.25);
			player.getGame().log.addLine("burning: ");
			takeDamage(this, fire, true);
		}else {
			fire=0;
		}
		//cold
		if(cold>0) {
			double r=Math.random()*100*(1+resistCold/100);
			if (r<cold/GameEquations.maxHealthCalc(this)+0.3) {
				player.getGame().log.addLine(name+" is chilled");
				mana-=1;
			}else {
				if(r<cold/GameEquations.maxHealthCalc(this)) {
					player.getGame().log.addLine(name+" is frozen");
					stunned=true;
					this.block(GameEquations.calculateBlockAmount(10, this));
				}
			}
			cold=(int) Math.max(0, cold-GameEquations.maxHealthCalc(this)*0.05*(1+resistCold/100));
		}
		//lightning
		if(shock>0) {
			if (Math.random()<shock/GameEquations.maxHealthCalc(this)) {
				if(Math.random()*100>resistLightning) {
					player.getGame().log.addLine(name+" is shocked");
					stunned=true;
				}			
			}
			shock=0;
		}	
		buffTick();
	}
	public void turnBegin(){
		if(!isDead) {			
			this.discardHand();
			cardsPlayedThisRound=0;
			//turn block
			this.block=GameEquations.calculateBlockAmount(turnBlock, this);
			//
			this.mana=manaPower;
			for(int i=0; i<draw;i++) {
				drawCard();
			}
			applyNegativeTurnEffects();			
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
	//Cast resistable spell
	public boolean castResistableSpellOnHero(Hero hero) {
		if(Math.random()<(hero.getSpellResist()-magicDmg)/100.0) {
			player.getGame().log.addLine(hero.getName()+"resisted");
			return false;
		}else {
			return true;
		}
	}
	//Cast missile spell
	public boolean castMissileSpellOnHero(Hero hero, Card card) {
		if(!GameEquations.dodge(this, hero,card)) {
			return true;			
		}else {
			return false;
		}
	}
	//Attack stages dodge-block-armor-hp
	public int dealWeaponDamage(Hero hero, Item item, double mult) {//weapon damage str dependant or dexterity dependant
		int dmg;
		 if(item instanceof Weapon) {
			 Weapon weapon= (Weapon) item;
			 dmg=(int)(mult*weapon.computeAttackDamage(strength,dexterity));
		 }else {
			 dmg=(int)(mult*GameEquations.FistDamage(strength));
			 getPlayer().getGame().log.addLine("fistpunch");
		 } 
		 return dmg;		
	}
	//Attacking
	//Step 1: check if attack hits
	public boolean attackHero(Hero hero, Card card) {
		if(!GameEquations.dodge(this, hero,card)) {
			return true;			
		}else {
			return false;
		}		
	}
	//no direct call of Step 2 the card determines what is done with the hit
	//Step 2: calculate damage and forward to breach Block
	public void dealAttackDamage (Hero attackedHero, Card card, boolean thornFlag) {
		int damage;
		if (thornFlag) {
			damage=thorns;
		}else {
			damage= GameEquations.calculateAttackDamage(card, this);
		}
		int afterBlockDamage = GameEquations.attackIntoBlock(this, attackedHero, damage);		
		int afterArmorDamage = GameEquations.damageReducedByArmor(afterBlockDamage, attackedHero.armor);
		attackedHero.takeDamage(this, afterArmorDamage, thornFlag);
	}
	//Step 3: finally do health damage and check if thorns are triggered
	public void takeDamage(Hero damagingHero, int damage, boolean thornFlag){
		if (!thornFlag&&thorns>0&&damagingHero!=this) {//this is thorns
			//go directly to Step 2 with thorns (thorns can't miss)
			player.getGame().log.addLine("thorns: "+thorns);
			dealAttackDamage(damagingHero, null, true);
		}
		if(damage>0) {			
			//crit roll here, make sure to not use this for poison/bleed/burn
			if (damagingHero!=this) {
				damage=GameEquations.rollForCrit(damagingHero, damage);
				player.getGame().log.addLine(damagingHero.getName()+" deals "+damage+" damage to "+name);
			}else {
				player.getGame().log.addLine(name+" suffers "+damage+" damage");
			}
			finalDamage(damage);	
			//option for wounds instead of death
//				if(damage>hp/1.6) {	//wounds
//					if(Math.random()>wounds/(deck.getCards().size()*1.8)) {
//						player.getGame().log.addLine(name+"suffered a wound");
//						wounds+=1;
//						discardPile.add(new Wound());
//					}else {
//						finalDamage(damage);
//					}					
//				}else {
//					finalDamage(damage);
//				}
//			}			
		}		
	}
	public void finalDamage(int damage) {
		
		this.setHp(hp-damage);
		//player.getGame().log.addLine(name+" took "+damage+" damage");
		if(hp<=0) {
			hp=0;
			this.die();
		}
	}


	public void die() {
		//handle death //toughness rolls/receiving wounds?
		if(!isDead) {
			player.getGame().log.addLine(name+ " died!");
			player.getGame().getRoom().getInteractions().add(new StandardCorpse(player.getGame(),this)); //generate corpses
			player.getAvailableHeroes().add(player.getGame().generator.generateRandomHero(player));
			block=0;
			this.isDead=true;
			if (!player.getGame().getRoom().isHasFight()) {// in order to provide experience in fights!!
				player.getHeroes().remove(this);
			}		
			for(int i=0;i<player.getHeroes().size();i++) {
				player.getHeroes().get(i).becomeStressed(33);
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
	public void healStress(int heal) {
		stress-=heal;
		if (stress<0) {
			stress=0;
		}
	}
	public void heal(int heal) {//prevent overhealing
		int healing= Math.min(heal, GameEquations.maxHealthCalc(this)-getHp());
		if (healing>0) {
			this.setHp(this.getHp()+healing);
			player.getGame().log.addLine(name+" healed for "+healing+" hp");
		}				
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
	public boolean moveForward() {		
		if (player.getHeroes().indexOf(this)!=0) {
			int startPosition = getPosition();
			player.getHeroes().remove(this);
			player.getHeroes().addFirst(this);
			for(int i=startPosition-1; i>0;i--){
				Hero removedHero=player.getHeroes().remove(startPosition-1);
				player.getHeroes().addFirst(removedHero);
			}
			return true;
		}else {
			return false;
		}
	}
	public boolean moveBack() {
		if (player.getHeroes().indexOf(this)==player.getHeroes().size()-1) {
			return false;
		}else {
			int startPosition = getPosition();
			player.getHeroes().remove(this);
			player.getHeroes().addLast(this);
			for(int i=startPosition; i<player.getHeroes().size()-2;i++){
				Hero removedHero=player.getHeroes().remove(startPosition+1);
				player.getHeroes().addLast(removedHero);
			}
			return true;
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
		buff.mod(this);
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
		if (!isSummon) {
			int expToNextLvl=GameEquations.experienceThresholdForLevelUp(level)-experience;
			if(expToNextLvl<exp) {
				experience=GameEquations.experienceThresholdForLevelUp(level);
				levelUP();		
				gainExp(exp-expToNextLvl);
			}else {
				experience+=exp;
			}
		}
		
	}
	public void levelUP() {
		level+=1;
		strength+=1;dexterity+=1;intelligence+=1;vitality+=1;
		stressCap+=1;
		skillPoints+=1;
		if(cardPoints==0) {
			generatelvlUpCards();
		}
		cardPoints+=1;
		if (player.getHeroes().contains(this)) {
			player.getGame().log.addLine(this.getName()+" leveled up to level "+level);
		}				
	}
	public void generatelvlUpCards() {
		lvlUpCards=new LinkedList<Card>();
		lvlUpCards.add(player.getGame().generator.generateRandomCard(level));
		for(int i=0; i<3;i++) {//cards should be cloned
			lvlUpCards.add(player.getGame().cardBuilder.buildCard(charClass.getCardPool().get(Math.min(charClass.getCardPool().size()-1,(int)(Math.random()*charClass.getCardPool().size())))));	
		}
	}
	//
	public void autoskill() {
		while (skillPoints>0) {
			int random= (int) (Math.random()*5);
			String stat= "vitality";
			if (random==1) {
				stat= "dexterity";
			}
			if (random==2) {
				stat= "intelligence";
			}
			if (random==3) {
				stat= "strength";
			}
			skillMainStat(stat);
		}
		while (cardPoints>0) {
			pickLvlUpCard(lvlUpCards.getLast());
		}
	}
	public boolean skillMainStat(String stat) {
		if (skillPoints>0) {
			if (modifyStat(stat, 1)) {
				skillPoints-=1;
				return true;
			}
		}		
		return false;
	}
	public boolean pickLvlUpCard(Card card) {
		if (lvlUpCards.contains(card)) {
			deck.addCard(card);
			cardPoints-=1;
			if (cardPoints>0) {
				generatelvlUpCards();
			}		
			return true;
		}
		return false;
	}
	public boolean removeCardWithCardpoint(Card card) {
		if (deck.getCards().contains(card)&&cardPoints>0) {
			deck.getCards().remove(card);
			cardPoints-=1;
			return true;
		}
		return false;
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
	//bleed/poison/fire/lightning/cold/stun
	public void sufferBleeding() {
		player.getGame().log.addLine(name+" bleeds for "+bleed+" damage.");
		this.setHp(hp-bleed);
		if(hp<=0) {
			hp=0;
			this.die();
		}
	}
	public void sufferPoison() {
		if (poison>=hp) {
			player.getGame().log.addLine("the poison strikes "+name+".");
			setHp(1);
			poison=0;
		}				
	}
	//elemental damage
	
	//apply
	public void doBleedDamage(int damage, Hero target) {
		int bonus=this.getBleedDmg()-target.resistBleed;
		target.takeBleedDamage(damage,bonus);
	}
	public void doPoisonDamage(int damage,Hero target) {
		int bonus = this.getPoisonDmg()-target.resistPoison;
		target.takePoisonDamage(damage,bonus);
	}
	public void doFireDamage(int damage,Hero target) {
		int bonus = -target.resistFire;
		target.takeFireDamage(this,damage,bonus);
	}
	public void doColdDamage(int damage,Hero target) {
		int bonus = -target.resistCold;
		target.takeColdDamage(this,damage,bonus);
	}
	public void doLightningDamage(int damage,Hero target) {
		int bonus = -target.resistLightning;
		target.takeLightningDamage(this,damage,bonus);
	}
	public void doMagicDamage(int damage,Hero target) {
		int bonus = -target.resistSpell;
		target.takeMagicDamage(this,damage,bonus);
	}
	public void doStun(int stunChance,Hero target) {
		int bonus= stunChance-target.resistStun;
		target.takeStun(bonus);
	}
	//receive		
	public boolean takeBleedDamage(int bleedAmount, int bonus) {
		if (bonus>0) {
			bleed+=bleedAmount*(1+bonus/100);
		}else {
			if(Math.random()<-bonus/100.0) {
				player.getGame().log.addLine(name+" resisted bleeding");
				return false;
			}else {
				bleed+=bleedAmount;
				player.getGame().log.addLine(name+" bleeds");
				return true;
			}
		}
		return true;
	}
	public boolean takePoisonDamage(int poisonAmount, int bonus) {
		if (bonus>0) {
			poison+=poisonAmount*(1+bonus/100);
		}else {
			if(Math.random()<-bonus/100.0) {
				player.getGame().log.addLine(name+" resisted poison");
				return false;
			}else {
				if (poison>0) {
					poison+=poisonAmount;
				}else {
					poison++;
				}				
				player.getGame().log.addLine(name+" got poisoned");
				return true;
			}
		}
		return true;
	}
	public void takeFireDamage(Hero damagingHero, int damage, int bonus) {
		int fireDamage=(int)(damage*(1.0-bonus/100.0));
		damagingHero.getPlayer().getGame().log.addLine("fire:");
		fire+=fireDamage;
		int afterBlockDamage = GameEquations.attackIntoBlock(damagingHero, this, fireDamage);		
		takeDamage(damagingHero,afterBlockDamage,false);
		int fireCold =fire-cold;
		if (fireCold<0) {
			cold=-fireCold;
			fire=0;
		}else {
			cold=0;
			fire=fireCold;
		}
	}
	public void takeLightningDamage(Hero damagingHero, int damage, int bonus) {
		int lightningDamage=(int)(damage*(1.0-bonus/100.0));
		damagingHero.getPlayer().getGame().log.addLine("lightning damage:");
		shock+=lightningDamage;
		int afterBlockDamage = GameEquations.attackIntoBlock(damagingHero, this, lightningDamage);	
		takeDamage(damagingHero,afterBlockDamage,false);
	}
	public void takeColdDamage(Hero damagingHero, int damage, int bonus) {
		int coldDamage=(int)(damage*(1-bonus/100.0));
		damagingHero.getPlayer().getGame().log.addLine("cold damage:");
		cold+=coldDamage;		
		int afterBlockDamage = GameEquations.attackIntoBlock(damagingHero, this, coldDamage);		
		takeDamage(damagingHero,afterBlockDamage,false);
		int fireCold =fire-cold;
		if (fireCold<0) {
			cold=-fireCold;
			fire=0;
		}else {
			cold=0;
			fire=fireCold;
		}
	}
	public void takeMagicDamage(Hero damagingHero, int damage, int bonus) {
		int magicDamage=(int)(damage*(1-bonus/100.0));
		damagingHero.getPlayer().getGame().log.addLine("magic damage:");		
		int afterBlockDamage = GameEquations.attackIntoBlock(damagingHero, this, magicDamage);		
		takeDamage(damagingHero,afterBlockDamage,false);
	}
	//stun
	public boolean takeStun(int bonus) {
		if(Math.random()<bonus/100.0) {
			stunned=true;
			player.getGame().log.addLine(name+" got stunned!");
			buffHero(new Bashed());
			return true;
		}else {
			player.getGame().log.addLine(name+" resisted stun!");
			return false;
		}
	};
	
	public void enhance(int percent) {
		//for summoned monsters (100 is normal)
		dexterity=(int) (dexterity*percent/100.0);
		//attributes
		attackSkill=(int) (attackSkill*percent/100.0);
		blockSkill=(int) (blockSkill*percent/100.0);
		spellPower=(int) (spellPower*percent/100.0);
		baseHp=(int) (baseHp*percent/100.0);
		hp=GameEquations.maxHealthCalc(this);
	}
	public int rollSpeed() {
		currentSpeed=GameEquations.speedRoll(this);
		return currentSpeed;
	}

	//A all stats to String method might be handy for gui
	//
	public int getStatValueFromString(String stat) {
		if (stat.equals("shielding")) {//for magic shields that don't scale with blockskill			
			return block;
		}
		/////stats//////
		if (stat.equals("speed")) {			
			return speed;
		}	
		if (stat.equals("thorns")) {			
			return thorns;
		}	
		if (stat.equals("draw")) {			
			return draw;
		}	
		if (stat.equals("manaPower")) {			
			return manaPower;
		}
		if (stat.equals("armor")) {			
			return armor;
		}
		if (stat.equals("accuracy")) {			
			return accuracy;
		}
		if (stat.equals("dodge")) {			
			return dodge;
		}
		if (stat.equals("critChance")) {			
			return critChance;
		}
		if (stat.equals("critDamage")) {			
			return critDamage;
		}
		if (stat.equals("attackSkill")) {			
			return attackSkill;
		}
		if (stat.equals("blockSkill")) {		
			return 	blockSkill;
		}
		if (stat.equals("turnBlock")) {			
			return turnBlock;
		}
		if (stat.equals("spellPower")) {			
			return spellPower;
		}
		//resistance
		if (stat.equals("resistSpell")) {			
			return resistSpell;
		}		
		if (stat.equals("resistFire")) {
			return resistFire;
		}
		if (stat.equals("resistLightning")) {			
			return resistLightning;
		}
		if (stat.equals("resistCold")) {			
			return resistCold;
		}
		if (stat.equals("resistPoison")) {			
			return resistPoison;
		}
		if (stat.equals("resistBleed")) {			
			return resistBleed;
		}
		if (stat.equals("resistStun")) {			
			return resistStun;
		}
		if (stat.equals("resistStress")) {			
			return resistStress;
		}
		if (stat.equals("trapDisarm")) {			
			return trapDisarm;
		}
		if (stat.equals("baseHp")) {			
			return baseHp;
		}
		if (stat.equals("strength")) {			
			return strength;
		}
		if (stat.equals("vitality")) {			
			return vitality;
		}
		if (stat.equals("dexterity")) {			
			return dexterity;
		}
		if (stat.equals("intelligence")) {			
			return intelligence;
		}
		System.out.println("stat resolve error!");
		return 0;
		
	}
	//modify stats method for items and buffs...
	public boolean modifyStat(String stat, int value) {
		if (stat.equals("shielding")) {//for magic shields that don't scale with blockskill
			block+=value;
			return true;
		}
		/////stats//////
		if (stat.equals("speed")) {
			speed+=value;
			return true;
		}	
		if (stat.equals("thorns")) {
			thorns+=value;
			return true;
		}	
		if (stat.equals("draw")) {
			draw+=value;
			return true;
		}	
		if (stat.equals("manaPower")) {
			manaPower+=value;
			return true;
		}
		if (stat.equals("armor")) {
			armor+=value;
			return true;
		}
		if (stat.equals("accuracy")) {
			accuracy+=value;
			return true;
		}
		if (stat.equals("dodge")) {
			dodge+=value;
			return true;
		}
		if (stat.equals("critChance")) {
			critChance+=value;
			return true;
		}
		if (stat.equals("critDamage")) {
			critDamage+=value;
			return true;
		}
		if (stat.equals("attackSkill")) {
			attackSkill+=value;
			return true;
		}
		if (stat.equals("blockSkill")) {
			blockSkill+=value;
			return true;
		}
		if (stat.equals("turnBlock")) {
			turnBlock+=value;
			return true;
		}
		if (stat.equals("spellPower")) {
			spellPower+=value;
			return true;
		}
		//resistance
		if (stat.equals("resistSpell")) {
			resistSpell+=value;
			return true;
		}		
		if (stat.equals("resistFire")) {
			resistFire+=value;
			return true;
		}
		if (stat.equals("resistLightning")) {
			resistLightning+=value;
			return true;
		}
		if (stat.equals("resistCold")) {
			resistCold+=value;
			return true;
		}
		if (stat.equals("resistPoison")) {
			resistPoison+=value;
			return true;
		}
		if (stat.equals("resistBleed")) {
			resistBleed+=value;
			return true;
		}
		if (stat.equals("resistStun")) {
			resistStun+=value;
			return true;
		}
		if (stat.equals("resistStress")) {
			resistStress+=value;
			return true;
		}
		if (stat.equals("trapDisarm")) {
			trapDisarm+=value;
			return true;
		}
		if (stat.equals("baseHp")) {
			baseHp+=value;
			return true;
		}
		if (stat.equals("strength")) {
			strength+=value;
			return true;
		}
		if (stat.equals("vitality")) {
			vitality+=value;
			return true;
		}
		if (stat.equals("dexterity")) {
			dexterity+=value;
			return true;
		}
		if (stat.equals("intelligence")) {
			intelligence+=value;
			return true;
		}
		System.out.println("stat resolve error!");
		return false;
	}
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
	public void setNewTarget(Hero target) {
		this.target = target;
		targets=new LinkedList<Hero>();
		addTarget(target);
	}
	public void addTarget(Hero target) {
		targets.add(target);
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
		return resistSpell;
	}
	public void setSpellResist(int spellResist) {
		this.resistSpell = spellResist;
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
	
	public int getResistLightning() {
		return resistLightning;
	}
	public void setResistLightning(int resistLightning) {
		this.resistLightning = resistLightning;
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
	public int getWounds() {
		return wounds;
	}
	public void setWounds(int wounds) {
		this.wounds = wounds;
	}
//	public BufferedImage getImage() {
//		return image;
//	}
//	public void setImage(BufferedImage image) {
//		this.image = image;
//	}
	public int getCritChance() {
		return critChance;
	}
	public void setCritChance(int critChance) {
		this.critChance = critChance;
	}
	public int getCritDamage() {
		return critDamage;
	}
	public void setCritDamage(int critDamage) {
		this.critDamage = critDamage;
	}
	public LinkedList<Hero> getTargets() {
		return targets;
	}
	public void setTargets(LinkedList<Hero> targets) {
		this.targets = targets;
	}
	public int getSpellDuration() {
		return spellDuration;
	}
	public void setSpellDuration(int spellDuration) {
		this.spellDuration = spellDuration;
	}
	public int getFireDmg() {
		return fireDmg;
	}
	public void setFireDmg(int fireDmg) {
		this.fireDmg = fireDmg;
	}
	public int getColdDmg() {
		return coldDmg;
	}
	public void setColdDmg(int coldDmg) {
		this.coldDmg = coldDmg;
	}
	public int getLightningDmg() {
		return lightningDmg;
	}
	public void setLightningDmg(int lightningDmg) {
		this.lightningDmg = lightningDmg;
	}
	public int getPoisonDmg() {
		return poisonDmg;
	}
	public void setPoisonDmg(int poisonDmg) {
		this.poisonDmg = poisonDmg;
	}
	public int getBleedDmg() {
		return bleedDmg;
	}
	public void setBleedDmg(int bleedDmg) {
		this.bleedDmg = bleedDmg;
	}
	public int getMagicDmg() {
		return magicDmg;
	}
	public void setMagicDmg(int magicDmg) {
		this.magicDmg = magicDmg;
	}
	public int getResistSpell() {
		return resistSpell;
	}
	public void setResistSpell(int resistSpell) {
		this.resistSpell = resistSpell;
	}
	public int getImageNumber() {
		return imageNumber;
	}
	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}
	public int getFire() {
		return fire;
	}
	public void setFire(int fire) {
		this.fire = fire;
	}
	public int getStunChance() {
		return stunChance;
	}
	public void setStunChance(int stunChance) {
		this.stunChance = stunChance;
	}
	public int getImageScale() {
		return imageScale;
	}
	public void setImageScale(int imageScale) {
		this.imageScale = imageScale;
	}
	public boolean isStunned() {
		return stunned;
	}
	public boolean isSummon() {
		return isSummon;
	}
	public void setSummon(boolean isSummon) {
		this.isSummon = isSummon;
	}
	public int getCardsPlayedThisRound() {
		return cardsPlayedThisRound;
	}
	public void setCardsPlayedThisRound(int cardsPlayedThisRound) {
		this.cardsPlayedThisRound = cardsPlayedThisRound;
	}

	
	
}
