package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Sidestep extends SpellnoTarget{
	public Sidestep() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public boolean applyEffect(Hero self) {
		self.block((int) (self.computeBlockSkill()*0.9));
		self.drawCard();
		return true;
	}
	@Override
	public String getName() {
		return "sidestep";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"90% block, draw 1";
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
