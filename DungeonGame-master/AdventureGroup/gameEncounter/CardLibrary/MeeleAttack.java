package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class MeeleAttack extends Card{
	public MeeleAttack() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public void applyEffect(Hero self) {
		self.dealDamage(self.getTarget(), self.getAttackSkill());
	}
	@Override
	public String getName() {
		return "meele attack";
	}
	@Override
	public String getCardText(Hero self) {
		return "deal "+ self.getAttackSkill()+" physical damage";
	}

}
