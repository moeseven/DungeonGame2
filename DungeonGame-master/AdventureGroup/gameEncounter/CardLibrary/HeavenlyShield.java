package gameEncounter.CardLibrary;

import gameEncounter.Buff;
import gameEncounter.Card;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class HeavenlyShield extends Spell{
	public HeavenlyShield() {
		// TODO Auto-generated constructor stub
		manaCost =1;		
	}
	public boolean applyEffect(Hero self) {
		self.getTarget().buffHero(new HavenlyShieldBuff((int)(2+(GameEquations.spellPowerCalc(self)/1.1))));
		return true;
	}
	@Override
	public String getName() {
		return "heavenly shield";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"armor bonus to target";
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
