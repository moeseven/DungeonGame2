package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class targetRandomAllyOfTargetEffect extends CardEffect{

	public targetRandomAllyOfTargetEffect(LinkedList<String> pars) {
		super(pars);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		//switches target to self
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for(int i=0; i<self.getTargets().get(0).getPlayer().getHeroes().size();i++) {
			nextTargets.add(self.getTargets().get(0).getPlayer().getHeroes().get(i));
		}
		Hero randomTarget= nextTargets.get((int) (Math.random()*nextTargets.size()));
		nextTargets = new LinkedList<Hero>();
		nextTargets.add(randomTarget);
		self.setTargets(nextTargets);
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		return "random target";
	}

}
