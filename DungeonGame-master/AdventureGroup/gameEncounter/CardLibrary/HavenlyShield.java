package gameEncounter.CardLibrary;

import gameEncounter.Buff;
import gameEncounter.Card;
import gameEncounter.Hero;

public class HavenlyShield extends Spell{
	public HavenlyShield() {
		// TODO Auto-generated constructor stub
		manaCost =1;		
	}
	public boolean applyEffect(Hero self) {
		self.getTarget().buffHero(new HavenlyShieldBuff((int)(2+(self.computeSpellPower()/1.1))));
		return true;
	}
	@Override
	public String getName() {
		return "havenly shield";
	}
	@Override
	public String getCardText() {
		return super.getCardText()+"armor bonus to target";
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
	private class HavenlyShieldBuff extends Buff{
		private int armor;
		public HavenlyShieldBuff(int armor) {
			this.armor=armor;
			duration=3;
		}
		@Override
		public void onTick(Hero hero) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setArmor(hero.getArmor()+armor);
		}

		@Override
		public void demod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setArmor(hero.getArmor()-armor);
		}
		
	}
}
