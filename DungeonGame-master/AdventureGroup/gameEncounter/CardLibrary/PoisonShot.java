package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class PoisonShot extends AttackCard{
	public PoisonShot() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.7;
		legalCastPositions[0]=false;
		legalCastPositions[1]=false;
		
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget(),this)) {
				damageTarget(self);
				self.getTarget().poison(3);
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "poison shot";
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+" 3 poison";
	}


}
