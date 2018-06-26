package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class PoisonAttack extends AttackCard{
	public PoisonAttack() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.3;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				self.getTarget().poison(5);
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "poison attack";
	}
	@Override
	public String getCardText() {
		//TODO correct number display
		return super.getCardText()+" 5 poison";
	}

}
