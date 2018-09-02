package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class SleepCharm extends Spell{
	public SleepCharm() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		legalCastPositions[0]=false;
	}
	public boolean applyEffect(Hero self) {
			if(self.castSpellOnHero(self.getTarget())) {
				self.getTarget().getDiscardPile().add(new Sleepy());
				self.getTarget().getDiscardPile().add(new Sleepy());
				return true;
			}else {
				return false;
			}
	}
	@Override
	public String getName() {
		return "sleep charm";
	}
	@Override
	public String getCardText(Hero hero) {
		//TODO correct number display
		return "make the target sleepy";
	}
	@Override
	public int rangeOfCard(Hero hero) {
		// TODO Auto-generated method stub
		return 10;
	}
	@Override
	public boolean isFriendly() {
		// TODO Auto-generated method stub
		return false;
	}
	private class Sleepy extends SpellnoTarget{
		public Sleepy() {
			// TODO Auto-generated constructor stub
			manaCost =2;
			
		}
		public boolean applyEffect(Hero self) {
			self.getDiscardPile().remove(this);
			return true;
		}
		@Override
		public String getName() {
			return "sleepy";
		}
		@Override
		public String getCardText(Hero  hero) {
			return super.getCardText(hero)+"casting removes this card from deck";
		}
		@Override
		public int rangeOfCard(Hero hero) {
			// TODO Auto-generated method stub
			return 10;
		}
		@Override
		public boolean isFriendly() {
			// TODO Auto-generated method stub
			return true;
		}
	}
}
