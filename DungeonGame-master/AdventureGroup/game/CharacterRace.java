package game;

import java.util.LinkedList;

import gameEncounter.Hero;

public abstract class CharacterRace extends CharacterType{
	protected LinkedList<String> nameList = new LinkedList<String>();
	protected Game game;
	public CharacterRace(Game game) {
		this.game=game;
	}

	@Override
	public void modifyHero(Hero hero) {
		hero.setName(name);		
		for(int i=0; i<items.size();i++) {
			hero.getPlayer().getInventory().add(items.get(i));
			hero.getEquipment().equipItem(items.get(i));
		}
		//deck
		for(int i=0; i<cards.size();i++) {
			hero.getDeck().addCard(cards.get(i));
		}
	}

	public LinkedList<String> getNameList() {
		return nameList;
	}

	public void setNameList(LinkedList<String> nameList) {
		this.nameList = nameList;
	}
	

}
