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
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		Weapon w;
		if(hero.getEquipment().getHand1()!=null) {
			 w=(Weapon) hero.getEquipment().getHand1();
			 return w.getWeaponRange();
		}
		return 1;
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
	public String getCardText() {
		//TODO correct number display
		//generate legeal positions text
		String legalPos="positions(";
		for(int i=0;i<legalPositions.length;i++) {
			if(legalPositions[i]) {
				legalPos+=(i+1)+" ";
			}
		}
		legalPos+=")";
		return legalPos+damageMult*100+"% damage ";
	}
}
