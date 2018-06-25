package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class CarefulSlash extends Card{
	public CarefulSlash() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public boolean applyEffect(Hero self) {
			self.block((int)(self.computeBlockSkill()*0.75));
			if(self.attackHero(self.getTarget())) {
				self.dealWeaponDamage(self.getTarget(), self.getEquipment().getHand1(),0.75);
				return true;
			}else {
				return false;
			}
			
	}
	@Override
	public String getName() {
		return "careful slash";
	}
	@Override
	public String getCardText(Hero self) {
		//TODO correct number display
		return "75% damage + 75% block";
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
