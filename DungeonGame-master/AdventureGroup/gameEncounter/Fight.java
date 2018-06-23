package gameEncounter;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.LinkedList;

import game.Game;
import game.RoomInteractionLibrary.StandardCorpse;

public class Fight implements Serializable{
	private Game game;
	private int round=0;
	private LinkedList<Hero> turnOrder;
	private LinkedList<Hero> monsters;
	private LinkedList<Hero> heroes;
	private int turnOrderCounter;
	private LinkedList<LinkedList<Hero>> meele;
	public Fight(Game game,LinkedList<Hero> monsters, LinkedList<Hero> heroes) {
		// TODO Auto-generated constructor stub
		this.game=game;
		this.monsters=monsters;
		this.heroes=heroes;
		for (Hero h : heroes) {		
		    h.setUpHandPile();
		    h.setFight(this);
		}
		for (Hero m : monsters) {	
		    m.setUpHandPile();	 
		    m.setFight(this);
		}
		this.newRound();
	}
	public void newRound() {
		round+=1;
		game.log.addLine("########## ROUND "+round+" ##########");
		LinkedList<Hero> allFightParticipants;
		allFightParticipants=new LinkedList<Hero>();
		turnOrder=new LinkedList<Hero>();
		turnOrderCounter=-1;
		for (Hero h : heroes) {		
			if(!h.isDead()) {
				h.setCurrentSpeed(h.rollSpeed());
				allFightParticipants.add(h);
			}			
		}
		for (Hero m : monsters) {
			if(!m.isDead()) {
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
			highestSpeed=0;
		}
		nextTurn();
	}
	public void nextTurn() {
		int exp; 
		LinkedList<Hero> dead= new LinkedList<Hero>();
		for(int i=0; i<monsters.size();i++) {
			if(monsters.get(i).isDead()) {//remove bodies from fight and handle experience
				exp=monsters.get(i).getExperienceValue();
				game.getRoom().getInteractions().add(new StandardCorpse(monsters.get(i))); //generate corpses
				dead.add(monsters.get(i));
				for (Hero h: heroes) {//give experience to heroes
						h.setExperience(h.getExperience()+(int) (exp/heroes.size()));			
				}
			}	
		}
		for(int i=0; i<dead.size();i++) {
			monsters.remove(dead.get(i));	
		}
		for(int i=0; i<heroes.size();i++) {
			if(heroes.get(i).isDead()) {//remove bodies from fight and handle experience
				game.getRoom().getInteractions().add(new StandardCorpse(heroes.get(i))); //generate corpses
				//add items to corpse
				
				dead.add(heroes.get(i));
			}	
		}
		for(int i=0; i<dead.size();i++) {
			heroes.remove(dead.get(i));	
		}
		if (this.isFightOver()){
			for(int i=0; i<heroes.size();i++) {
				heroes.get(i).removeBuffs();
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
					System.out.println(turnOrder.get(turnOrderCounter).getName()+"'s turn");
					this.getHeroes().getFirst().getPlayer().getGame().log.addLine(turnOrder.get(turnOrderCounter).getName()+"'s turn");
					turnOrder.get(turnOrderCounter).turnBegin();//draw cards and reset buffs/debuffs
					if(monsters.contains(turnOrder.get(turnOrderCounter))){	
						//monster chooses random target here TODO make sure it attacks only targets in range!
						
					    for(int i=0; i<turnOrder.get(turnOrderCounter).getHand().size(); i++){
					    	int range=turnOrder.get(turnOrderCounter).getHand().get(i).rangeOfCard(turnOrder.get(turnOrderCounter));
					    	int eligibleTargets=Math.min(range-monsters.indexOf(turnOrder.get(turnOrderCounter)),heroes.size());
					    	if(turnOrder.get(turnOrderCounter).getHand().get(i).isFriendly()) {
					    		turnOrder.get(turnOrderCounter).setTarget(monsters.get(Math.min((int) (Math.random()*(monsters.size()+0.0)),monsters.size()-1)));
					    		if(turnOrder.get(turnOrderCounter).getHand().get(i).playCard(turnOrder.get(turnOrderCounter))) {
						    		i=i-1;
						    	}
					    	}else {
					    		if(eligibleTargets>=0) {
						    		turnOrder.get(turnOrderCounter).setTarget(heroes.get(Math.min((int) (Math.random()*(eligibleTargets+0.0)),heroes.size()-1)));//choose target for attacks
							    	if(turnOrder.get(turnOrderCounter).getHand().get(i).playCard(turnOrder.get(turnOrderCounter))) {
							    		i=i-1;
							    	}
						    	}
					    	}					    					    	
					    }
					    //
					    nextTurn();
					}else {
						this.game.getPlayer().setSelectedHero(turnOrder.get(turnOrderCounter));
					}
				}
			}						
		}		
	}
	public void handleFightisOver() {
		//TODO
	}
	public boolean isFightOver() {
		int monstersAlive=0,heroesAlive=0;
		for (Hero m: monsters) {
			if(!m.isDead()){
				monstersAlive+=1;
			}
		}
		for (Hero h: heroes) {
			if(!h.isDead()){
				heroesAlive+=1;
			}
		}
		if(monstersAlive>0&&heroesAlive>0) {
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
	
}
