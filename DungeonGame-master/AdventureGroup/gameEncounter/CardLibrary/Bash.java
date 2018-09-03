package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;
import gameEncounter.buffLibrary.Bashed;

public class Bash extends AttackCard{
	public Bash() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.6;
		legalCastPositions[0]=true;
		legalCastPositions[1]=true;
		legalCastPositions[2]=false;
		legalCastPositions[3]=false;
		legalCastPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget(),this)) {
				damageTarget(self);
				self.getTarget().takeStun();
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "Bash";
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+" bash";
	}
}
