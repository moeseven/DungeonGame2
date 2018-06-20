package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class BasicAttack extends Card{
	public BasicAttack() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public void applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				self.dealWeaponDamage(self.getTarget(), self.getEquipment().getHand1());
			}			
	}
	@Override
	public String getName() {
		return "basic attack";
	}
	@Override
	public String getCardText(Hero self) {
		//TODO correct number display
		return "deal "+ 0+" physical damage";
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

}
