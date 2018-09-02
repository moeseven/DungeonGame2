package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Bullwork extends SpellnoTarget{
	public Bullwork() {
		// TODO Auto-generated constructor stub
		manaCost =2;
		
	}
	public boolean applyEffect(Hero self) {
		self.block(self.computeBlockSkill()*3);
		return true;
	}
	@Override
	public String getName() {
		return "bullwork";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"400% block";
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
