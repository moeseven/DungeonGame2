package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class FireFist extends AttackCard{
	public FireFist() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=0.5;
		legalPositions[4]=false;
		legalPositions[3]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				self.getTarget().takeFireDamage(self,(int)(1*self.dealWeaponDamage(self.getTarget(), self.getEquipment().getHand1(),damageMult)));		
				return true;
			}else {
				return false;
			}
	}
	
	@Override
	public String getCardText() {
		// TODO Auto-generated method stub
		return super.getCardText()+"/25% fire damage";
	}
	@Override
	public String getName() {
		return "fire fist";
	}
}
