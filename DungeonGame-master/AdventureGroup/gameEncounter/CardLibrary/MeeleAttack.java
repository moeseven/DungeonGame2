package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class MeeleAttack extends AttackCard{
	public MeeleAttack() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=1;
		legalCastPositions[2]=false;
		legalCastPositions[3]=false;
		legalCastPositions[4]=false;
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
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero);
	}
}
