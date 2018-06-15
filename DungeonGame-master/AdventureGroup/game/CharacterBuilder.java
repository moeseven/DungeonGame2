package game;

import java.util.LinkedList;

import game.characterTypeLibrary.*;
import gameEncounter.Hero;

public class CharacterBuilder {
	private LinkedList<CharacterClass> charClasses;
	private LinkedList<CharacterRace> charRaces;
	private Hero hero;
	private String name;
	public CharacterBuilder() {
		super();
		name="Olg";
		charClasses=new LinkedList<CharacterClass>();
		charRaces=new LinkedList<CharacterRace>();
		charClasses.add(new TypeWarrior());
		charClasses.add(new TypeThief());
		charClasses.add(new TypeMage());
		charClasses.add(new TypeCleric());
		charRaces.add(new RaceHuman());
		charRaces.add(new RaceDwarf());
		charRaces.add(new RaceHalfling());
		charRaces.add(new RaceElf());
		// TODO Auto-generated constructor stub
	}
	public void scrollThroughCharClasses() {
		charClasses.add(charClasses.removeFirst());
	}
	public void scrollThroughCharRaces() {
		charRaces.add(charRaces.removeFirst());
	}
	public void createHero() {
		hero=new Hero(name, charRaces.getFirst(), charClasses.getFirst());
	}
	public LinkedList<CharacterClass> getCharClasses() {
		return charClasses;
	}
	public void setCharClasses(LinkedList<CharacterClass> charClasses) {
		this.charClasses = charClasses;
	}
	public LinkedList<CharacterRace> getCharRaces() {
		return charRaces;
	}
	public void setCharRaces(LinkedList<CharacterRace> charRaces) {
		this.charRaces = charRaces;
	}
	public CharacterClass getCharClass() {
		return charClasses.getFirst();
	}
	public CharacterRace getCharRace() {
		return charRaces.getFirst();
	}
	public Hero getHero() {
		return hero;
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//classes: warrior, thief, cleric, mage
//races: human, dwarf, elf, halfling
	
}
