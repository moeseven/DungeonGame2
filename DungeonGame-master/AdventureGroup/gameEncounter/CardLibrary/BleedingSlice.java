package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class BleedingSlice extends AttackCard{
	public BleedingSlice() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=2;
		legalPositions[0]=true;
		legalPositions[1]=true;
		legalPositions[2]=false;
		legalPositions[3]=false;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				self.getTarget().bleed(4);
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "bleeding slice";
	}
	@Override
	public String getCardText() {
		//TODO correct number display
		return super.getCardText()+" 4 bleed";
	}

}
