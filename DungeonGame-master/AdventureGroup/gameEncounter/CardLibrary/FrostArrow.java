package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class FrostArrow extends AttackCard{
	public FrostArrow() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=1;
		legalPositions[0]=false;
		legalPositions[1]=false;
		
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				
				return true;
			}else {
				return false;
			}
	}
	protected void damageTarget(Hero self) {
		self.getTarget().takeColdDamage(self,(int)(0.25*self.dealWeaponDamage(self.getTarget(), self.getEquipment().getHand1(),damageMult)));		
	}
	
	@Override
	public String getCardText() {
		// TODO Auto-generated method stub
		return super.getCardText()+"/25% cold damage";
	}
	@Override
	public String getName() {
		return "frost arrow";
	}
}
