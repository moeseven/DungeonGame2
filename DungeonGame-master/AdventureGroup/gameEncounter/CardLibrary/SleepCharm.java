package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Weapon;

public class SleepCharm extends Card{
	public SleepCharm() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public void applyEffect(Hero self) {
			if(self.castSpellOnHero(self.getTarget())) {
				self.getTarget().getDiscardPile().add(new Sleepy());
			}			
	}
	@Override
	public String getName() {
		return "sleep charm";
	}
	@Override
	public String getCardText(Hero self) {
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
	private class Sleepy extends Card{
		public Sleepy() {
			// TODO Auto-generated constructor stub
			manaCost =2;
			
		}
		public void applyEffect(Hero self) {
			self.getDiscardPile().remove(this);
		}
		@Override
		public String getName() {
			return "sleepy";
		}
		@Override
		public String getCardText(Hero self) {
			return "remove this card from pile";
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
