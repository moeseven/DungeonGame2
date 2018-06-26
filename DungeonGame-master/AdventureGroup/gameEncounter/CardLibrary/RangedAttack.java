package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class RangedAttack extends AttackCard{
	public RangedAttack() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=1.2;
		legalPositions[0]=false;
		legalPositions[1]=false;
		
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
		return "ranged attack";
	}
}
