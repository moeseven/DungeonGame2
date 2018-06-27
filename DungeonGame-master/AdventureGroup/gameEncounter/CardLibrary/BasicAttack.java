package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class BasicAttack extends AttackCard{
	public BasicAttack() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=0.7;
		legalPositions[0]=true;
		legalPositions[1]=true;
		legalPositions[2]=true;
		legalPositions[3]=true;
		legalPositions[4]=true;
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
		return "basic attack";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 5;
	}
	

}
