package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class BleedingSlice extends AttackCard{
	public BleedingSlice() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=2;
		legalCastPositions[0]=true;
		legalCastPositions[1]=true;
		legalCastPositions[2]=false;
		legalCastPositions[3]=false;
		legalCastPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget(),this)) {
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
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+" 4 bleed";
	}

}
