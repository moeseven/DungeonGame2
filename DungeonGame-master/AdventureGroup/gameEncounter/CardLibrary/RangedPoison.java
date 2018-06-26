package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class RangedPoison extends AttackCard{
	public RangedPoison() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.7;
		legalPositions[0]=false;
		legalPositions[1]=false;
		
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				self.getTarget().poison(3);
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "ranged poison";
	}
	@Override
	public String getCardText() {
		//TODO correct number display
		return super.getCardText()+" 3 poison";
	}


}
