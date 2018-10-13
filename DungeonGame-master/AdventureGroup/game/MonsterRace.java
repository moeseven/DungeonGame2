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

	public LinkedList<CharacterClass> getPositionClasses(int i) {
		LinkedList<CharacterClass> retval= position1Classes;
		switch(i){
        case 1:
        	retval=position1Classes;
            break;
        case 2:
        	retval=position2Classes;
            break;
        case 3:
        	retval=position3Classes;
            break;
        case 4:
        	retval=position4Classes;
            break;
        case 5:
        	retval=position5Classes;
            break;
        default:
            System.out.println("non valid position");
            return retval;
        } 
		return retval;
	}
}
