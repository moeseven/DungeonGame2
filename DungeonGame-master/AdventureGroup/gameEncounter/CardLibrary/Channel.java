package gameEncounter.CardLibrary;

import gameEncounter.Buff;
import gameEncounter.Card;
import gameEncounter.Hero;

public class Channel extends SpellnoTarget{
	public Channel() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public boolean applyEffect(Hero self) {
		self.buffHero(new ChannelBuff());	
		return true;
	}
	@Override
	public String getName() {
		return "channel";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"channel 2 mana";
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
	private class ChannelBuff extends Buff{
		public ChannelBuff() {
			duration=1;
		}
		@Override
		public void mod(Hero hero) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void demod(Hero hero) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTick(Hero hero) {
			// TODO Auto-generated method stub
			hero.setMana(hero.getMana()+2);
		}
		
	}
}
