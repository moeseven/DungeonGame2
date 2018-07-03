package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class DaggerThrow extends AttackCard{
	public DaggerThrow() {
		// TODO Auto-generated constructor stub
		manaCost =0;
		damageMult=0.5;
		legalPositions[0]=false;
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
		return "dagger throw";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		return 8;
	}

}
