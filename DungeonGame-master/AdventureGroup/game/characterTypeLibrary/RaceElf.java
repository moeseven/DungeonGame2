package game.characterTypeLibrary;

import game.CharacterRace;
import game.Game;
import gameEncounter.Hero;


public class RaceElf extends CharacterRace{

	public RaceElf(Game game) {
		super(game);
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
		//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(27));
		hero.setImageNumber(27);
		hero.setSpeed(hero.getSpeed()+2);
		hero.setAccuracy(hero.getAccuracy()+7);
		hero.setBaseHp(hero.getBaseHp()-6);
		hero.setStrength(hero.getStrength()-2);
		hero.setDexterity(hero.getDexterity()+3);
		hero.setSpellDuration(hero.getSpellDuration()+1);
		//resistances
		hero.setArmor(1);
		hero.setSpellResist(10);
		hero.setResistFire(5);
		hero.setResistCold(5);
		hero.setResistPoison(10);
		hero.setResistBleed(0);
		hero.setResistStun(0);
		hero.setResistStress(15);
		hero.setTrapDisarm(16);
		hero.setStunChance(0);
		//
		hero.setLightningDmg(5);
		hero.setCritDamage(11);
		hero.setCritChance(4);
	}


}
