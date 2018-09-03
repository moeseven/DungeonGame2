package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class Feint extends AttackCard{
	public Feint() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		damageMult=1;
		legalCastPositions[0]=true;
		legalCastPositions[1]=true;
		legalCastPositions[2]=true;
		legalCastPositions[3]=false;
		legalCastPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget(),this)) {
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
	public String getCardText(Hero hero) {
		// TODO Auto-generated method stub
		return super.getCardText(hero)+"draw a card";
	}
	

}
