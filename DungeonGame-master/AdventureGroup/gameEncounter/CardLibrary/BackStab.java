package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class BackStab extends AttackCard{
	public BackStab() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=1.8;
		legalCastPositions[0]=false;
		legalCastPositions[1]=true;
		legalCastPositions[2]=true;
		legalCastPositions[3]=true;
		legalCastPositions[4]=true;
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
	public String getCardText(Hero hero) {
		//TODO correct number display
		return super.getCardText(hero)+", penetrates armor, can not be dodged or blocked";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 10;
	}

}
