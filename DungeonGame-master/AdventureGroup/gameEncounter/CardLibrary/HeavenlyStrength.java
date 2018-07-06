package gameEncounter.CardLibrary;

import gameEncounter.Buff;
import gameEncounter.Card;
import gameEncounter.Hero;

public class HeavenlyStrength extends Spell{
	public HeavenlyStrength() {
		// TODO Auto-generated constructor stub
		manaCost =2;		
	}
	public boolean applyEffect(Hero self) {
		self.getTarget().buffHero(new HeavenlyStregnthened(self));
		return true;
	}
	@Override
	public String getName() {
		return "heavenly strength";
	}
	@Override
	public String getCardText() {
		return super.getCardText()+"gives great strength";
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
	private class HeavenlyStregnthened extends Buff{
		private int bonus=0;
		public HeavenlyStregnthened(Hero hero) {
			bonus=hero.getSpellPower()/2;
			duration=6;
		}
		@Override
		public void onTick(Hero hero) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setStrength(hero.getStrength()+bonus);
		}

		@Override
		public void demod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setStrength(hero.getStrength()-bonus);
		}
		
	}
}
