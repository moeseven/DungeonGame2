package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class Feint extends AttackCard{
	public Feint() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=1;
		legalPositions[0]=true;
		legalPositions[1]=true;
		legalPositions[2]=true;
		legalPositions[3]=false;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				self.drawCard();
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "feint";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 5;
	}
	@Override
	public String getCardText() {
		// TODO Auto-generated method stub
		return super.getCardText()+"draw a card";
	}
	

}
