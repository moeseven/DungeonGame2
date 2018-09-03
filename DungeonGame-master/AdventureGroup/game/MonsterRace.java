package game;

import java.util.LinkedList;

import gameEncounter.Hero;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.Block;

public abstract class MonsterRace extends CharacterRace{
	protected LinkedList<String> nameList = new LinkedList<String>();
	protected LinkedList<CharacterClass> position1Classes=new LinkedList<CharacterClass>();
	protected LinkedList<CharacterClass> position2Classes=new LinkedList<CharacterClass>();
	protected LinkedList<CharacterClass> position3Classes=new LinkedList<CharacterClass>();
	protected LinkedList<CharacterClass> position4Classes=new LinkedList<CharacterClass>();
	protected LinkedList<CharacterClass> position5Classes=new LinkedList<CharacterClass>();
	public MonsterRace(Game game) {
		super(game);
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

	public LinkedList<CharacterClass> getPosition1Classes() {
		return position1Classes;
	}
	public LinkedList<CharacterClass> getPosition2Classes() {
		// TODO Auto-generated method stub
		return position2Classes;
	}

	public LinkedList<CharacterClass> getPosition3Classes() {
		// TODO Auto-generated method stub
		return position3Classes;
	}

	public LinkedList<CharacterClass> getPosition4Classes() {
		// TODO Auto-generated method stub
		return position4Classes;
	}

	public LinkedList<CharacterClass> getPosition5Classes() {
		// TODO Auto-generated method stub
		return position5Classes;
	}
}
