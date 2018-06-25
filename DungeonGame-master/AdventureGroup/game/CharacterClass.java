package game;

import gameEncounter.Hero;

public abstract class CharacterClass extends CharacterType{

	public CharacterClass() {
		// TODO Auto-generated constructor stub
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
		hero.setName(hero.getName()+" "+name);
	}

}
