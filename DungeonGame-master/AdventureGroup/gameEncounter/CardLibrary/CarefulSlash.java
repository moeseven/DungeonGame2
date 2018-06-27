package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class CarefulSlash extends AttackCard{
	public CarefulSlash() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=0.7;
		legalPositions[2]=false;
		legalPositions[3]=false;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			self.block((int)(self.computeBlockSkill()*0.7));
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
		return super.getCardText()+"/70% block";
	}
}
