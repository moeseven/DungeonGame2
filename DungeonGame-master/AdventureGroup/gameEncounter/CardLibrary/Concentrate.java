package gameEncounter.CardLibrary;

import gameEncounter.Buff;
import gameEncounter.Card;
import gameEncounter.Hero;

public class Concentrate extends SpellnoTarget{
	public Concentrate() {
		// TODO Auto-generated constructor stub
		manaCost =2;
	}
	public boolean applyEffect(Hero self) {
		
		return true;
	}
	@Override
	public String getName() {
		return "concentrate";
	}
	@Override
	public String getCardText() {
		return super.getCardText()+"double dexterity";
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
	private class Concentrated extends Buff{
		private int doubleDex=0;
		public Concentrated(Hero hero) {
			doubleDex=hero.getDexterity();
			duration=3;
		}
		@Override
		public void onTick(Hero hero) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setDexterity(hero.getDexterity()+doubleDex);
		}

		@Override
		public void demod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setDexterity(hero.getDexterity()-doubleDex);
		}
		
	}
}
