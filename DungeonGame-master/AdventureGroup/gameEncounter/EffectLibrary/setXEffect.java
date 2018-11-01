package gameEncounter.EffectLibrary;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.CardEffect;
import gameEncounter.GameEquations;
import gameEncounter.Hero;

public class setXEffect extends CardEffect{
	String cardText;
	public setXEffect(LinkedList<String> pars) {
		super(pars);
	}
	//TODO multiple targets fix
	@Override
	public boolean applyEffect(Hero self, Card card) {
		String parameter= pars.get(1);
		switch (parameter) {
        case "drawPile":
        	card.setX(self.getDrawPile().size());
            break;
        case "handSize":
        	card.setX(self.getHand().size());
            break;
        case "block":
        	card.setX(self.getBlock());
            break;
        case "healthPercent":
            card.setX((int) (100.0*self.getHp()/GameEquations.maxHealthCalc(self)));
            break;
        case "mana": //x cost spells
            card.setX(self.getMana());
            self.setMana(0);
            break;
        case "targetPoison":
        	card.setX(self.getTargets().get(0).getPoison()); 
            break;
        case "isPoisoned":
        	if (self.getTargets().get(0).getPoison()>0) {
				card.setX(1); 
			}else {
				card.setX(0);
			}      	
            break;
        case "isUndead":
        	if (self.getTargets().get(0).isUndead()) {
				card.setX(1); 
			}else {
				card.setX(0);
			}      	
            break;
        case "cardsPlayed":
        	card.setX(self.getCardsPlayedThisRound()); 
            break;
        case "x":
        	String xMod= pars.get(2);
        	switch (xMod) {
        	case "*":
            	card.setX(card.getX()*Integer.parseInt(pars.get(3))); 
                break;
        	case "*attack":
            	card.setX(card.getX()*card.getAttackDamage()); 
                break;
        	case "*block":
            	card.setX(card.getX()*card.getBlock()); 
                break;
        	case "*spell":
            	card.setX(card.getX()*card.getSpellDamage()); 
                break;
            case "+":
            	card.setX(card.getX()+Integer.parseInt(pars.get(3))); 
                break;
            default:
            	throw new IllegalArgumentException("Invalid argument: "+xMod);
    		}
            break;
        default:
        	throw new IllegalArgumentException("Invalid argument: "+parameter);
		}
		return true;
	}

	@Override
	public String generateCardText(Hero self, Card card) {
		String retVal="x="+pars.get(1);
		if (pars.size()>2) {
			retVal+="; "+pars.get(2)+pars.get(3);
		}
		return retVal;
	}

}
