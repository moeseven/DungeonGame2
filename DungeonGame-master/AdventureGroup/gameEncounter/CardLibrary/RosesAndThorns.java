package gameEncounter.CardLibrary;

import gameEncounter.Buff;
import gameEncounter.Card;
import gameEncounter.Hero;

public class RosesAndThorns extends SpellnoTarget{
	public RosesAndThorns() {
		// TODO Auto-generated constructor stub
		manaCost =2;
	}
	public boolean applyEffect(Hero self) {
		for(int i=0; i<self.getPlayer().getHeroes().size();i++) {
			self.getPlayer().getHeroes().get(i).buffHero(new RosedAndThorned(self));
			self.getPlayer().getHeroes().get(i).heal((int)(1+self.getSpellPower()/8.0));
		}
		return true;
	}
	@Override
	public String getName() {
		return "roses and thorns";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"gain thorns and heal";
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
	private class RosedAndThorned extends Buff{
		private int thornValue=0;
		public RosedAndThorned(Hero hero) {
			thornValue=(int)(3+hero.getSpellPower()/3.5);
			duration=4;
		}
		@Override
		public void onTick(Hero hero) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setThorns(hero.getThorns()+thornValue);
		}

		@Override
		public void demod(Hero hero) {
			// TODO Auto-generated method stub
			hero.setThorns(hero.getThorns()-thornValue);
		}
		
	}
}
