package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class Block extends SpellnoTarget{
	public Block() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public boolean applyEffect(Hero self) {
		self.block((int) (GameEquations.blockSkillCalc(self)*0.8));
		return true;
	}
	@Override
	public String getName() {
		return "block";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"80% block";
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
