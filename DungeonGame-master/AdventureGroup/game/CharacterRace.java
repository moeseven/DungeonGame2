package game;

import java.util.LinkedList;

import gameEncounter.Hero;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;

public abstract class CharacterRace extends CharacterType{
	protected LinkedList<String> nameList = new LinkedList<String>();
	protected Game game;
	public CharacterRace(Game game) {
		this.game=game;
	}

	@Override
	public void modifyHero(Hero hero) {
		hero.setName(name);
		//deck

	}

	public LinkedList<String> getNameList() {
		return nameList;
	}

	public void setNameList(LinkedList<String> nameList) {
		this.nameList = nameList;
	}
	

}
