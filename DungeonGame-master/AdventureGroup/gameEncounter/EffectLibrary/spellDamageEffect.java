package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.Card_new;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class spellDamageEffect extends CardEffect{
	public spellDamageEffect(LinkedList<String> pars) {
		super(pars);
	}

	@Override
	public boolean applyEffect(Hero self, Card card) {
		String damageType= pars.get(1);
		int dmg=0;
		if (pars.size()>2) {
			if (pars.get(2).equals("x")) {
				dmg=card.getX();
			}
		}else {
			dmg = GameEquations.calculateSpellDamage(card.getSpellDamage(), self, damageType);	
		}			
		LinkedList<Hero> nextTargets = new LinkedList<Hero>();
		for (int i = 0; i < self.getTargets().size(); i++) {
			nextTargets.add(self.getTargets().get(i));
			switch (damageType) {
	        case "fire":
	        	self.doFireDamage(dmg, self.getTargets().get(i));
	            break;
	        case "cold":
	        	self.doColdDamage(dmg, self.getTargets().get(i));
	            break;
	        case "magic":
	        	self.doMagicDamage(dmg, self.getTargets().get(i));
	            break;
	        case "lightning":
	        	self.doLightningDamage(dmg, self.getTargets().get(i));        
	            break;
	        default:
	        	throw new IllegalArgumentException("Invalid argument: "+damageType);
			}		
		}
		self.setTargets(nextTargets);
		if(nextTargets.size()>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		String damageType= pars.get(1);
		String dmg = ""+GameEquations.calculateSpellDamage(card.getSpellDamage(), self, damageType);	
		if (pars.get(2).equals("x")) {
			dmg="x";
		}
		return dmg+" "+damageType+" damage.";
	}

}
