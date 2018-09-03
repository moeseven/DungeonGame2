package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class MightyBlow extends AttackCard{
	public MightyBlow() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		damageMult=6.25;
		legalCastPositions[0]=true;
		legalCastPositions[1]=true;
		legalCastPositions[2]=false;
		legalCastPositions[3]=false;
		legalCastPositions[4]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.attackHero(self.getTarget(),this)) {
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
			legalCastPositions[0]=false;
			legalCastPositions[1]=false;
			legalCastPositions[2]=false;
			legalCastPositions[3]=false;
		}
		public boolean applyEffect(Hero self) {
			return true;
		}
		@Override
		public String getName() {
			return "exhausted";
		}
		@Override
		public String getCardText(Hero hero) {
			return super.getCardText(hero)+"exhausted from a previous attack";
		}

		@Override
		public boolean isFriendly() {
			// TODO Auto-generated method stub
			return true;
		}
	}
}
