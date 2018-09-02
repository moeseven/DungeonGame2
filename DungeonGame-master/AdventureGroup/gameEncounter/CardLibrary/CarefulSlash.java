package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class CarefulSlash extends AttackCard{
	public CarefulSlash() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=0.8;
		legalCastPositions[2]=false;
		legalCastPositions[3]=false;
		legalCastPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			self.block((int)(self.computeBlockSkill()*0.8));
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
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+"/80% block";
	}
}
