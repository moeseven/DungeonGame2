package gameEncounter.CardLibrary;

import gameEncounter.Card;
import gameEncounter.Hero;

public class Block extends Card{
	public Block() {
		// TODO Auto-generated constructor stub
		manaCost =1;
		
	}
	public void applyEffect(Hero self) {
		self.block(self.getBlockSkill());
	}
	@Override
	public String getName() {
		return "parry";
	}
	@Override
	public String getCardText(Hero self) {
		return "block for "+self.getBlockSkill();
	}
}
