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
		legalCastPositions[0]=true;
		legalCastPositions[1]=true;
		legalCastPositions[2]=true;
		legalCastPositions[3]=true;
		legalCastPositions[4]=false;
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
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+" pushes target back depending on strength difference";
	}
	
}
