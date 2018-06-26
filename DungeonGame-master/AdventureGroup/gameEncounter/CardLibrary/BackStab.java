package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class BackStab extends AttackCard{
	public BackStab() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.8;
		legalPositions[0]=false;
		legalPositions[1]=true;
		legalPositions[2]=true;
		legalPositions[3]=true;
	}
	public boolean applyEffect(Hero self) {
		damageTarget(self);
		self.getDiscardPile().remove(this);
		return true;
	}
	@Override
	public String getName() {
		return "back stab";
	}
	@Override
	public String getCardText() {
		//TODO correct number display
		return super.getCardText()+", penetrates armor, can not be dodged or blocked";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 10;
	}

}
