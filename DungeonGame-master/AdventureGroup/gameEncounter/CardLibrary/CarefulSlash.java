package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class CarefulSlash extends AttackCard{
	public CarefulSlash() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=0.75;
		legalPositions[2]=false;
		legalPositions[3]=false;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			self.block((int)(self.computeBlockSkill()*0.75));
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				return true;
			}else {
				return false;
			}
			
	}
	@Override
	public String getName() {
		return "careful slash";
	}
	@Override
	public String getCardText() {
		//TODO correct number display
		return super.getCardText()+"/75% block";
	}
}
