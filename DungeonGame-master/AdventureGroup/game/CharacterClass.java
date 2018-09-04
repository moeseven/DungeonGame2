package game;

import java.util.LinkedList;

import gameEncounter.Card;
import gameEncounter.Hero;

public abstract class CharacterClass extends CharacterType{
protected LinkedList<String> cardPool=new LinkedList<String>();
protected Game game;
	public CharacterClass(Game game) {
		this.game=game;
	}
	@Override
	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		for(int i=0; i<items.size();i++) {
			hero.getPlayer().getInventory().add(items.get(i));
			hero.getEquipment().equipItem(items.get(i));
		}
		for(int i=0; i<cards.size();i++) {
			hero.getDeck().addCard(cards.get(i));
		}
		hero.setName(hero.getName()+" ("+name+")");
	}
	public LinkedList<String> getCardPool() {
		return cardPool;
	}
	public void setCardPool(LinkedList<String> cardPool) {
		this.cardPool = cardPool;
	}
	
}
