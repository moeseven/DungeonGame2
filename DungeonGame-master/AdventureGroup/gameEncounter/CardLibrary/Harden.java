package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Harden extends SpellnoTarget{
	public Harden() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public boolean applyEffect(Hero self) {
		for(int i=0;i<self.getPlayer().getHeroes().size();i++) {
			self.getPlayer().getHeroes().get(i).block(self.getSpellPower());
		}
		return true;
	}
	@Override
	public String getName() {
		return "harden";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"gives block to everybody";
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
	@Override
	public void buildLogEntry(Hero self) {
		self.getPlayer().getGame().log.addLine(getName());
		
	}

}
