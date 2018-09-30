package game.characterTypeLibrary;

import game.CharacterRace;
import game.Game;
import gameEncounter.Hero;

public class RaceDwarf extends CharacterRace{

	public RaceDwarf(Game game) {
		super(game);
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
		//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(28));
		hero.setImageNumber(28);
		hero.setBaseHp(hero.getBaseHp()+10);
		hero.setAttackSkill(hero.getAttackSkill()+1);		
		hero.setDodge(hero.getDodge()-2);
		hero.setSpeed(hero.getSpeed()-2);
		hero.setStrength(hero.getStrength()+3);
		hero.setDexterity(hero.getDexterity()-1);
		hero.setSpellPower(hero.getSpellPower()-1);
		//resistances
		hero.setSpellResist(10);
		hero.setResistFire(5);
		hero.setResistCold(5);
		hero.setResistPoison(0);
		hero.setResistBleed(0);
		hero.setResistStun(5);
		hero.setResistStress(0);
		hero.setTrapDisarm(10);
	}


}
