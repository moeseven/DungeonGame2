package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class ramEffect extends CardEffect{

	public ramEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card_new card) {
			self.moveForward();
			self.moveForward();
			if(self.getStrength()>self.getTarget().getStrength()) {
				self.getTarget().moveBack();
			}		
			if(self.getStrength()>6+self.getTarget().getStrength()) {
				self.getTarget().moveBack();
			}
			if(self.getStrength()>18+self.getTarget().getStrength()) {
				self.getTarget().moveBack();
			}
			return true;
	}

	@Override
	public String generateCardText(Hero self, Card_new card) {
		// TODO Auto-generated method stub
		return " knocks back weaker targets, moves forward";
	}

}
