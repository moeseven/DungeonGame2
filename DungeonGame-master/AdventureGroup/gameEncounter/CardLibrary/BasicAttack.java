package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class BasicAttack extends AttackCard{
	public BasicAttack() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=0.7;
		legalCastPositions[0]=true;
		legalCastPositions[1]=true;
		legalCastPositions[2]=true;
		legalCastPositions[3]=true;
		legalCastPositions[4]=true;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget(), this)) {
				damageTarget(self);
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "basic attack";
	}
	

}
