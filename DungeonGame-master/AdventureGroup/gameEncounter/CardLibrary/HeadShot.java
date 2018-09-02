package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class HeadShot extends AttackCard{
	public HeadShot() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=3.6;
		legalCastPositions[0]=false;
		legalCastPositions[1]=false;
		
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
		return "head shot";
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+"";
	}

}
