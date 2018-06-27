package game.characterTypeLibrary;

import game.CharacterRace;
import gameEncounter.Hero;


public class RaceElf extends CharacterRace{

	public RaceElf() {
		name="elf";
		nameList.add("Irdal");
		nameList.add("Auril");
		nameList.add("Thiril");
		nameList.add("Banduril");
		nameList.add("Thranduil");
		nameList.add("Iril");
		nameList.add("Mandal");
		nameList.add("Nogalin");
		nameList.add("Sondulin");
		nameList.add("Haldir");
		nameList.add("Glorfindel");
		nameList.add("Elor");
		nameList.add("Fingolfin");
		nameList.add("Lauriel");
		nameList.add("Thiril");
		nameList.add("Caranthir");
		nameList.add("Beleg");
		nameList.add("Celebrimbor");
		nameList.add("Ecthelion");
		nameList.add("Feanor");
		nameList.add("Finarfin");
		nameList.add("Galathil");
		nameList.add("Ingil");
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		hero.setSpeed(hero.getSpeed()+2);
		hero.setAccuracy(hero.getAccuracy()+3);
		hero.setBaseHp(hero.getBaseHp()-5);
		hero.setStrength(hero.getStrength()-1);
		hero.setDexterity(hero.getDexterity()+3);
		//resistances
		hero.setResistFire(4);
		hero.setResistCold(16);
		hero.setResistPoison(19);
		hero.setResistBleed(6);
		hero.setResistStun(8);
		hero.setResistStress(12);
		hero.setTrapDisarm(16);

	}


}
