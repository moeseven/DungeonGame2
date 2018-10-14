package gameEncounter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import game.DungeonMaster;
import game.Game;

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
		    h.setUpDrawPile();
		    h.setFight(this);
		}
		for (Hero m : monsters) {	
		    m.setUpDrawPile();	 
		    m.setFight(this);
		    precalculateMonsterTurn(m);
		}
		this.newRound();
	}
	public void newRound() {
		for (Hero m : monsters) {	
		    
		}
		round+=1;
		game.log.addLine("########## ROUND "+round+" ##########");		
		allFightParticipants=new LinkedList<Hero>();
		turnOrder=new LinkedList<Hero>();
		turnOrderCounter=-1;
		for (Hero h : heroes) {		
			if(!h.isDead()&&h.getStress()<h.getStressCap()) {
				h.setCurrentSpeed(h.rollSpeed());
				allFightParticipants.add(h);
			}			
		}
		for (Hero m : monsters) {
			if(!m.isDead()&&m.getStress()<m.getStressCap()) {
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
						h.gainExp((int)(1.0+(exp/heroes.size())));			
				}
			}else {
				if(monsters.get(i).getStress()>=monsters.get(i).getStressCap()) {
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
				if(heroes.get(i).getStress()>=heroes.get(i).getStressCap()) {
					stressed.add(heroes.get(i));
				}
			}
		}
		for(int i=0; i<dead.size();i++) {//remove dead heroes
			heroes.remove(dead.get(i));	
		}
		for(int i=0; i<stressed.size();i++) {//remove stressed heroes
			if(stressed.get(i).getPlayer() instanceof DungeonMaster) {				
			}else {
				heroes.remove(stressed.get(i));	
				stressed.get(i).getPlayer().getAvailableHeroes().add(stressed.get(i));//flee to tavern
			}
		}
		if (this.isFightOver()){
			for(int i=0; i<heroes.size();i++) {
				heroes.get(i).setBlock(0);
				heroes.get(i).removeBuffs();	
				heroes.get(i).applyNegativeTurnEffects();
			}
			if(heroes.size()>0) {
				game.log.addLine("§§§§§§§§§§ Fight won! §§§§§§§§§§");
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
					if(monsters.contains(turnOrder.get(turnOrderCounter))){	
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
						this.game.getPlayer().setSelectedHero(turnOrder.get(turnOrderCounter));
					}
				}
			}						
		}		
	}
	//attack indication 
	public void precalculateMonsterTurn(Hero monster) {
		targetMap.put(monster,new HashMap<Card,Hero>());
		for (int i = 0; i < monster.draw; i++) {
			monster.drawCard();
		}		
		monster.setMana(monster.getManaPower());
	    for(int i=0; i<monster.getHand().size(); i++){
	    	LinkedList<Hero> targets = new LinkedList<Hero>();
	    	for(int h=0;h<heroes.size();h++) {
	    		if (monster.getHand().get(i).legalTargetPositions[heroes.get(h).getPosition()]) {
					targets.add(heroes.get(h));
				}
	    	}		    		
	    	if(monster.getHand().get(i).isFriendly()) {
	    		monster.setNewTarget(monsters.get(Math.min((int) (Math.random()*(monsters.size()+0.0)),monsters.size()-1)));
	    		if(monster.getHand().get(i).playable(monster)) {
	    			targetMap.get(monster).put(monster.getHand().get(i),monster.getTarget());
	    			monster.getHand().get(i).handleManaCost(monster);
		    	}
	    	}else {
	    		if(targets.size()>0) {
		    		monster.setNewTarget(targets.get(Math.min((int) (Math.random()*(targets.size()+0.0)),targets.size()-1)));//choose target for attacks
			    	if(monster.getHand().get(i).playable(monster)) {
			    		targetMap.get(monster).put(monster.getHand().get(i),monster.getTarget());
			    		monster.getHand().get(i).handleManaCost(monster);
			    	}
		    	}
	    	}					    					    	
	    }	
	    int handSize = monster.getHand().size();
		for (int i=0; i<handSize;i++) {
			monster.getDrawPile().addFirst(monster.getHand().removeLast());			
		}
		monster.setMana(0);
	}
	public void handleFightisOver() {
		//TODO
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
//	public void createMeele() {//give heroes a foe not good like this! Rework!!!
//		if(monsters.size()>=heroes.size()) {
//			for (int i=0; i<heroes.size();i++) {
//				LinkedList<Hero> newList =new LinkedList<Hero>();
//				newList.add(heroes.get(i));
//				meele.add(newList);
//			}
//			for (int i=0; i<monsters.size();i++) {
//				meele.get(i % heroes.size()).add(monsters.get(i));
//			}
//			
//		}else {
//			for (int i=0; i<monsters.size();i++) {
//				LinkedList<Hero> newList =new LinkedList<Hero>();
//				newList.add(monsters.get(i));
//				meele.add(newList);
//			}
//			for (int i=0; i<heroes.size();i++) {
//				meele.get(i % monsters.size()).add(heroes.get(i));
//			}
//		}
//	}
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
