package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class MeeleAttack extends AttackCard{
	public MeeleAttack() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=1;
		legalPositions[2]=false;
		legalPositions[3]=false;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				return true;
			}else {
				return false;
			}
			
	}
	@Override
	public String getName() {
		return "meele attack";
	}
	@Override
	public String getCardText() {
		//TODO correct number display
		return super.getCardText();
	}
}
