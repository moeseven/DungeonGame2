package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Hero;

public class RaceDwarf extends CharacterRace{

	public RaceDwarf() {
		name="dwarf";
		nameList.add("Bimbur");
		nameList.add("Turi");
		nameList.add("Thorgrim");
		nameList.add("Bombur");
		nameList.add("Thorin");
		nameList.add("Gloin");
		nameList.add("Dain");
		nameList.add("Kambur");
		nameList.add("Dwalin");
		nameList.add("Oin");
		nameList.add("Ori");
		nameList.add("Bifur");
		nameList.add("Naugrim");
		nameList.add("Gimli");
		nameList.add("Urm");
		nameList.add("Gaulur");
		nameList.add("Bogrim");
		nameList.add("Olgrim");
		nameList.add("Falbur");
		nameList.add("Fenbur");
		nameList.add("Balin");
		nameList.add("Fundin");
		nameList.add("Grór");
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);	
		hero.setBaseHp(hero.getBaseHp()+10);
		hero.setAttackSkill(hero.getAttackSkill()+1);
		hero.setSpellResist(hero.getSpellResist()+1);
		hero.setDodge(hero.getDodge()-2);
		hero.setSpeed(hero.getSpeed()-2);
		hero.setStrength(hero.getStrength()+1);
		hero.setDexterity(hero.getDexterity()-1);
		hero.setSpellPower(hero.getSpellPower()-1);
		//resistances
		hero.setResistFire(12);
		hero.setResistCold(12);
		hero.setResistPoison(2);
		hero.setResistBleed(20);
		hero.setResistStun(17);		
		hero.setTrapDisarm(10);
	}


}
