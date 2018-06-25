package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Hero;

public class RaceDwarf extends CharacterRace{

	public RaceDwarf() {
		name="dwarf";
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);	
		hero.setBaseHp(hero.getBaseHp()+10);
		hero.setAttackSkill(hero.getAttackSkill()+1);
		hero.setSpellResist(hero.getSpellResist()+2);
		hero.setDodge(hero.getDodge()-2);
		hero.setSpeed(hero.getSpeed()-2);
		hero.setStrength(hero.getStrength()+1);
		hero.setDexterity(hero.getDexterity()-1);
		hero.setSpellPower(hero.getSpellPower()-1);
		hero.setResistFire(12);
		hero.setResistCold(12);
	}


}
