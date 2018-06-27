package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class MightyBlow extends AttackCard{
	public MightyBlow() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=6.25;
		legalPositions[0]=true;
		legalPositions[1]=true;
		legalPositions[2]=false;
		legalPositions[3]=false;
		legalPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget())) {
				damageTarget(self);
				self.getDiscardPile().add(new Exhausted());
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "mighty blow";
	}
	private class Exhausted extends SpellnoTarget{
		public Exhausted() {
			// TODO Auto-generated constructor stub
			manaCost =0;
			legalPositions[0]=false;
			legalPositions[1]=false;
			legalPositions[2]=false;
			legalPositions[3]=false;
		}
		public boolean applyEffect(Hero self) {
			return true;
		}
		@Override
		public String getName() {
			return "exhausted";
		}
		@Override
		public String getCardText() {
			return super.getCardText()+"exhausted from a previous attack";
		}
		@Override
		public int rangeOfCard(Hero hero) {
			// TODO Auto-generated method stub
			return 1;
		}
		@Override
		public boolean isFriendly() {
			// TODO Auto-generated method stub
			return true;
		}
	}
}
