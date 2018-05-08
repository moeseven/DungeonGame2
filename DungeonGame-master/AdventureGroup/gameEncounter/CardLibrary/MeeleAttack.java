package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class MeeleAttack extends Card{
	public MeeleAttack() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public void applyEffect(Hero self) {
		self.dealAttackDamage(self.getTarget(), 20);
	}
	@Override
	public String getName() {
		return "meele attack";
	}
	@Override
	public String getCardText() {
		return "deal 20 attack damage";
	}

}
