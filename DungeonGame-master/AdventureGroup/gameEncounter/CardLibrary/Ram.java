package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;
import gameEncounter.buffLibrary.Bashed;

public class Ram extends AttackCard{
	public Ram() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.5;
		legalPositions[0]=true;
		legalPositions[1]=true;
		legalPositions[2]=true;
		legalPositions[3]=true;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				self.moveForward();
				self.moveForward();
				damageTarget(self);
				if(self.getStrength()>self.getTarget().getStrength()) {
					self.getTarget().moveBack();
				}		
				if(self.getStrength()>5+self.getTarget().getStrength()) {
					self.getTarget().moveBack();
				}
				if(self.getStrength()>10+self.getTarget().getStrength()) {
					self.getTarget().moveBack();
				}
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "ram";
	}
	@Override
	public String getCardText() {
		//TODO correct number display
		return super.getCardText()+" pushes target back depending on strength difference";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return hero.getPosition()+2;
	}
	
}
