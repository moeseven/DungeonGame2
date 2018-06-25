package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class BackStab extends Card{
	public BackStab() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		
	}
	public boolean applyEffect(Hero self) {
		if(self.getEquipment().getHand1() instanceof Weapon) {
			Weapon weapon= (Weapon) self.getEquipment().getHand1();				
			self.getTarget().takeDamage(self, (int)(1.8*weapon.computeAttackDamage(self.getStrength(),self.getDexterity())));
			self.getDiscardPile().remove(this);
		}else {
			return false;
		}
		return true;
	}
	@Override
	public String getName() {
		return "back stab";
	}
	@Override
	public String getCardText(Hero self) {
		//TODO correct number display
		return "an unexpected stab in the back that penetrates armor can not be dodged or blocked";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 10;
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
