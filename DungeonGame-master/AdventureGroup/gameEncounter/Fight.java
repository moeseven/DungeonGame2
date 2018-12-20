package gameEncounter;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import game.DungeonMaster;
import game.Game;
import gameEncounter.EffectLibrary.cardDrawEffect;
import gameEncounter.EffectLibrary.manaEffect;

public class Fight implements Serializable{
	
	public int retreatWish=0;
	private Game game;
	private int round=0;
	private LinkedList<Hero> allFightParticipants;
	private LinkedList<Hero> turnOrder;
	private LinkedList<Hero> monsters;
	private LinkedList<Hero> heroes;
	private Map<Hero, HashMap<Card, Hero>> targetMap= new HashMap<Hero,HashMap<Card,Hero>>();
	private int turnOrderCounter;
	private LinkedList<LinkedList<Hero>> meele;
	public Fight(Game game,LinkedList<Hero> monsters, LinkedList<Hero> heroes) {
		this.game=game;
		this.monsters=monsters;
		this.heroes=heroes;
		for (Hero h : heroes) {		
		    h.startFight(this);
		    h.setFight(this);
		}
		for (Hero m : monsters) {	
		    m.startFight(this);	 
		    m.setFight(this);		    
		}
		for (Hero m : monsters) {	
			precalculateMonsterTurn(m);		    
		}
		
		this.newRound();
	}
	public void newRound() {
		round+=1;
		game.log.addLine("########## ROUND "+round+" ##########");		
		allFightParticipants=new LinkedList<Hero>();
		turnOrder=new LinkedList<Hero>();
		turnOrderCounter=-1;
		for (Hero h : heroes) {		
			if(!h.isDead()&&h.getStress()>0) {
				h.setCurrentSpeed(h.rollSpeed());
				allFightParticipants.add(h);
			}			
		}
		for (Hero m : monsters) {
			if(!m.isDead()&&m.getStress()>0) {
				m.setCurrentSpeed(m.rollSpeed());
				allFightParticipants.add(m);
			}
		}
		//my own sorting
		int highestSpeed=0;
		int fastestHeroIndex=0;
		while(allFightParticipants.size()>0) {
			for(int i=0; i<allFightParticipants.size(); i++) {
				if(allFightParticipants.get(i).getCurrentSpeed()>highestSpeed) {
					fastestHeroIndex=i;
					highestSpeed=allFightParticipants.get(i).getCurrentSpeed();
				}
			}
			turnOrder.add(allFightParticipants.remove(fastestHeroIndex));
			highestSpeed=Integer.MIN_VALUE;
		}
		nextTurn();
	}
	public void nextTurn() {
		int exp; 
		LinkedList<Hero> dead= new LinkedList<Hero>();
		LinkedList<Hero> stressed= new LinkedList<Hero>();
		for(int i=0; i<monsters.size();i++) {
			if(monsters.get(i).isDead()) {//remove bodies from fight and handle experience
				exp=monsters.get(i).getExperienceValue();				
				dead.add(monsters.get(i));
				for (Hero h: heroes) {//give experience to heroes
						h.gainExp(exp);			
				}
			}else {
				if(monsters.get(i).getStress()<=0) {
					stressed.add(monsters.get(i));
				}
			}
		}
		for(int i=0; i<dead.size();i++) {
			monsters.remove(dead.get(i));	
		}
		for(int i=0; i<stressed.size();i++) {
			monsters.remove(stressed.get(i));	
		}
		for(int i=0; i<heroes.size();i++) {
			if(heroes.get(i).isDead()) {//remove bodies from fight and handle experience
				dead.add(heroes.get(i));
			}else {
				if(heroes.get(i).getStress()<=0) {
					stressed.add(heroes.get(i));
				}
			}
		}
		for(int i=0; i<dead.size();i++) {//remove dead heroes
			heroes.remove(dead.get(i));	
		}
		for(int i=0; i<stressed.size();i++) {//remove stressed heroes
			if(stressed.get(i).getPlayer() instanceof DungeonMaster) {	
				for (int j = 0; j < heroes.size(); j++) {
					heroes.get(j).gainExp(stressed.get(i).getExperienceValue());
				}
			}else {
				heroes.remove(stressed.get(i));	
				stressed.get(i).getPlayer().getAvailableHeroes().add(stressed.get(i));//flee to tavern
			}
		}
		if (this.isFightOver()){
			fightOverHandling();
			if(heroes.size()>0) {
				
				game.log.addLine("§§§§§§§§§§ Fight won! §§§§§§§§§§");
				for (int i = 0; i < heroes.size(); i++) {
					heroes.get(i).gainMoral(5);
				}
			}else {
				game.log.addLine("§§§§§§ Devastating defeat! §§§§§§");
			}			
		}else {
			turnOrderCounter+=1;
			if(turnOrderCounter>=turnOrder.size()) {
				newRound();
			}else {
				if(turnOrder.get(turnOrderCounter).isDead()) {
					//don't participate in fight
					nextTurn();
				}else {
					this.getHeroes().getFirst().getPlayer().getGame().log.addLine("~~~~~"+turnOrder.get(turnOrderCounter).getName()+"'s turn"+"~~~~~");
					turnOrder.get(turnOrderCounter).turnBegin();//draw cards and reset buffs/debuffs
					if(monsters.contains(turnOrder.get(turnOrderCounter))||turnOrder.get(turnOrderCounter).isSummon()){	
						if(!turnOrder.get(turnOrderCounter).isDead()) {
						//monster chooses random target here make sure it attacks only targets in range!	
						Hero monster=turnOrder.get(turnOrderCounter);
						HashMap<Card, Hero> mapTest = targetMap.get(monster);
						for(int i=0; i<monster.getHand().size(); i++){
							//what if target is dead
							Card cardTest=monster.getHand().get(i);			
							boolean containsTest = mapTest.containsKey(cardTest);
							if (targetMap.get(monster).containsKey(monster.getHand().get(i))) {
								if (!targetMap.get(monster).get(monster.getHand().get(i)).isDead()) {
									monster.setNewTarget(targetMap.get(monster).get(monster.getHand().get(i)));					
									monster.getHand().get(i).cast(monster);
									i=i-1;
								}
							}
						}														
//					    for(int i=0; i<turnOrder.get(turnOrderCounter).getHand().size(); i++){
//					   
//					    	LinkedList<Hero> targets = new LinkedList<Hero>();
//					    	for(int h=0;h<heroes.size();h++) {
//					    		if (turnOrder.get(turnOrderCounter).getHand().get(i).legalTargetPositions[heroes.get(h).getPosition()]) {
//									targets.add(heroes.get(h));
//								}
//					    	}
//					    		
//					    	if(turnOrder.get(turnOrderCounter).getHand().get(i).isFriendly()) {
//					    		turnOrder.get(turnOrderCounter).setNewTarget(monsters.get(Math.min((int) (Math.random()*(monsters.size()+0.0)),monsters.size()-1)));
//					    		if(turnOrder.get(turnOrderCounter).getHand().get(i).playable(turnOrder.get(turnOrderCounter))) {
//					    			turnOrder.get(turnOrderCounter).getHand().get(i).cast(turnOrder.get(turnOrderCounter));
//					    			i=i-1;
//						    	}
//					    	}else {
//					    		if(targets.size()>0) {
//						    		turnOrder.get(turnOrderCounter).setNewTarget(targets.get(Math.min((int) (Math.random()*(targets.size()+0.0)),targets.size()-1)));//choose target for attacks
//							    	if(turnOrder.get(turnOrderCounter).getHand().get(i).playable(turnOrder.get(turnOrderCounter))) {
//							    		turnOrder.get(turnOrderCounter).getHand().get(i).cast(turnOrder.get(turnOrderCounter));
//							    		i=i-1;
//							    	}
//						    	}
//					    	}					    					    	
//					    }
					    //
//						try {
//							Thread.sleep(1000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
						precalculateMonsterTurn(monster);
					}
					
					 nextTurn();
					}else {
						if (turnOrder.get(turnOrderCounter).isDead()) {
							nextTurn();
						}else {
							this.game.getPlayer().setSelectedHero(turnOrder.get(turnOrderCounter));
						}									
					}
				}
			}						
		}		
	}
	public boolean retreatHeroes() {
		retreatWish+=game.getPlayer().getSelectedHero().getMana()/game.getPlayer().getSelectedHero().getManaPower();			
		if (Math.random()*2.8<game.getRoom().getFight().retreatWish&&game.getPlayer().getSelectedHero().getMana()>0) {
			game.getRoom().getFight().fightOverHandling();
			game.retreatHeroes();
			return true;
		}else{
			game.log.addLine("retreat failed!");
			game.getPlayer().getSelectedHero().setMana(0); 
			return false;
		}
	}
	public void fightOverHandling() {
		retreatWish=0;
		for(int i=0; i<heroes.size();i++) {
			heroes.get(i).setBlock(heroes.get(i).getArmor());
			heroes.get(i).removeBuffs();	
			heroes.get(i).applyNegativeTurnEffects();
		}
		for(int i=0; i<monsters.size();i++) {
			monsters.get(i).setBlock(monsters.get(i).getArmor());
			monsters.get(i).removeBuffs();	
			monsters.get(i).applyNegativeTurnEffects();
			monsters.get(i).applyNegativeTurnEffects();
			monsters.get(i).applyNegativeTurnEffects();
			monsters.get(i).applyNegativeTurnEffects();
			monsters.get(i).setPoison(0);
			monsters.get(i).setBleed(0);
			monsters.get(i).setCold(0);
		}
	}
	//attack indication 
	public void precalculateMonsterTurn(Hero monster) {
		targetMap.put(monster,new HashMap<Card,Hero>());
		LinkedList<Hero> enemy;
		LinkedList<Hero> friend;
		if (monster.getPlayer()==game.getPlayer()) {
			enemy=monsters;
			friend=heroes;
		}else {
			enemy=heroes;
			friend=monsters;
		}
		//should not actually draw the cards
		LinkedList<Card> pseudoHand= new LinkedList<Card>();
		if (monster.getDrawPile().size()<monster.getDraw()) {
			Collections.shuffle(monster.getDiscardPile());
			for (int i = 0; i < monster.getDiscardPile().size(); i++) {
				monster.getDrawPile().add(monster.getDiscardPile().get(i));
			}
			monster.setDiscardPile(new LinkedList<Card>());
		}
		for (int i = 0; i < Math.min(monster.getDraw(), monster.getDrawPile().size()); i++) {
			pseudoHand.add(monster.getDrawPile().get(i));
		}		
		monster.setMana(monster.getManaPower());
	    for(int i=0; i<pseudoHand.size(); i++){
	    	LinkedList<Hero> targets = new LinkedList<Hero>();
	    	for(int h=0;h<enemy.size();h++) {
	    		if (pseudoHand.get(i).legalTargetPositions[enemy.get(h).getPosition()]) {
					targets.add(enemy.get(h));
				}
	    	}			    	
	    	if(pseudoHand.get(i).isFriendly()) {
	    		monster.setNewTarget(friend.get((int) (Math.random()*(friend.size()))));    		
	    	}else {
	    		if(targets.size()>0) {
		    		monster.setNewTarget(targets.get((int) (Math.random()*(targets.size()))));//choose target for attacks
		    	}
	    	}
	    	int [] mana_draw =precalculatedSpellWithManaOrDraw(pseudoHand.get(i));
	    	if(pseudoHand.get(i).aiPlayableCheck(monster)) {
    			targetMap.get(monster).put(pseudoHand.get(i),monster.getTarget());
    			pseudoHand.get(i).handleManaCost(monster);	    			
    			monster.setMana(monster.getMana()+mana_draw[0]);
    			for (int j = 0; j < mana_draw[1]; j++) {
    				if (monster.getDrawPile().size()>pseudoHand.size()) {
    					pseudoHand.add(monster.getDrawPile().get(pseudoHand.size()));
					}   				
				}
	    	}
	    }	    
//	    int handSize = monster.getHand().size();
//		for (int i=0; i<handSize;i++) {
//			monster.getDrawPile().addFirst(monster.getHand().removeLast());			
//		}
		monster.setMana(0);
	}
	private int[] precalculatedSpellWithManaOrDraw(Card card) {
		int[] mana_card_Plus=new int [2];
		for (int i = 0; i < card.getAllEffects().size(); i++) {
			if (card.getAllEffects().get(i)instanceof manaEffect) {
				mana_card_Plus[0]+=Integer.parseInt(card.getAllEffects().get(i).pars.get(1));
			}
			if (card.getAllEffects().get(i)instanceof cardDrawEffect) {
				mana_card_Plus[1]+=Integer.parseInt(card.getAllEffects().get(i).pars.get(1));
			}
		}
		return mana_card_Plus;
	}
	public void addSummonToFight(Hero hero) {
		if (hero.getPlayer() instanceof DungeonMaster) {
			//monsters.add(hero);
			game.dungeonMaster.addSummon(hero);			
		}else {
			//heroes.add(hero);			
			hero.getPlayer().addSummon(hero);
		}
		hero.setFight(this);
		hero.setUpDrawPile();
		precalculateMonsterTurn(hero);
	}
	public boolean monstersAlive() {
		int monstersAlive=0;
		for (Hero m: monsters) {
			if(!m.isDead()){
				monstersAlive+=1;
			}
		}
		if(monstersAlive>0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean heroesAlive() {
		int heroesAlive=0;
		for (Hero h: heroes) {
			if(!h.isDead()){
				heroesAlive+=1;
			}
		}
		if(heroesAlive>0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isFightOver() {
		if(heroesAlive()&&monstersAlive()) {
			return false;
		}else {
			return true;
		}		
	}
	//getters and setters
	public LinkedList<Hero> getMonsters() {
		return monsters;
	}
	public void setMonsters(LinkedList<Hero> monsters) {
		this.monsters = monsters;
	}
	public LinkedList<Hero> getHeroes() {
		return heroes;
	}
	public void setHeroes(LinkedList<Hero> heroes) {
		this.heroes = heroes;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public LinkedList<Hero> getTurnOrder() {
		return turnOrder;
	}
	public void setTurnOrder(LinkedList<Hero> turnOrder) {
		this.turnOrder = turnOrder;
	}
	public int getTurnOrderCounter() {
		return turnOrderCounter;
	}
	public void setTurnOrderCounter(int turnOrderCounter) {
		this.turnOrderCounter = turnOrderCounter;
	}
	public Map<Hero, HashMap<Card, Hero>> getTargetMap() {
		return targetMap;
	}
	public void setTargetMap(Map<Hero, HashMap<Card, Hero>> targetMap) {
		this.targetMap = targetMap;
	}
	
}
