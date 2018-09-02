package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public abstract class AttackCard extends Card{
	protected double damageMult=1;
	public AttackCard() {
		// TODO Auto-generated constructor stub
		
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
		self.dealWeaponDamage(self.getTarget(), self.getEquipment().getHand1(),damageMult);
	}

	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void buildLogEntry(Hero self) {
		self.getPlayer().getGame().log.addLine(getName());
		
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		//generate legeal positions text
		return damageMult*100+"% damage ";
	}
	@Override
	public boolean extraCastConditions(Hero hero) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
