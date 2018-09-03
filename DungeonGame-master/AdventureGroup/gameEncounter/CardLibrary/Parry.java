package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class Parry extends SpellnoTarget{
	public Parry() {
		// TODO Auto-generated constructor stub
		manaCost =0;
		
	}
	public boolean applyEffect(Hero self) {
		self.block((int) (GameEquations.blockSkillCalc(self)*0.7));
		return true;
	}
	@Override
	public String getName() {
		return "parry";
	}
	@Override
	public String getCardText(Hero hero) {
		return super.getCardText(hero)+"70% block";
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
