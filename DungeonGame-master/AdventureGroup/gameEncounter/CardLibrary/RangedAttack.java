package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class RangedAttack extends Card{
	public RangedAttack() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		legalPositions[0]=false;
		legalPositions[1]=false;
		
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				self.dealWeaponDamage(self.getTarget(), self.getEquipment().getHand1(),1.2);
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "ranged attack";
	}
	@Override
	public String getCardText(Hero self) {
		//TODO correct number display
		return "a ranged attack with a weapon";
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

}
