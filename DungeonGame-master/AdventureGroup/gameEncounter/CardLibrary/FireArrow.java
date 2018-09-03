package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class FireArrow extends AttackCard{
	public FireArrow() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=1;
		legalCastPositions[0]=false;
		legalCastPositions[1]=false;
		
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget(),this)) {
				self.getTarget().takeFireDamage(self,(int)(0.25*self.dealWeaponDamage(self.getTarget(), self.getEquipment().getHand1(),damageMult)));		
				return true;
			}else {
				return false;
			}
	}
	
	@Override
	public String getCardText(Hero hero) {
		// TODO Auto-generated method stub
		return super.getCardText(hero)+"/25% fire damage";
	}
	@Override
	public String getName() {
		return "fire arrow";
	}
}
