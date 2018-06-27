package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;
import gameEncounter.buffLibrary.Bashed;

public class Bash extends AttackCard{
	public Bash() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.5;
		legalPositions[0]=true;
		legalPositions[1]=true;
		legalPositions[2]=false;
		legalPositions[3]=false;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				self.getTarget().buffHero(new Bashed());
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
	public String getCardText() {
		//TODO correct number display
		return super.getCardText()+" bash";
	}
}
