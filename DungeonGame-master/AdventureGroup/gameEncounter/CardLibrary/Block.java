package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Block extends SpellnoTarget{
	public Block() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public boolean applyEffect(Hero self) {
		self.block((int) (self.computeBlockSkill()*0.8));
		return true;
	}
	@Override
	public String getName() {
		return "parry";
	}
	@Override
	public String getCardText() {
		return super.getCardText()+"80% block";
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
