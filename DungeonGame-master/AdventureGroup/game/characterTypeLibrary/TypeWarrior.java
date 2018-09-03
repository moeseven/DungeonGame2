package game.characterTypeLibrary;

import java.util.LinkedList;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.CardLibrary.Bash;
import gameEncounter.CardLibrary.BasicAttack;
import gameEncounter.CardLibrary.BleedingSlice;
import gameEncounter.CardLibrary.Block;
import gameEncounter.CardLibrary.Bullwork;
import gameEncounter.CardLibrary.CardBuilder;
import gameEncounter.CardLibrary.CarefulSlash;
import gameEncounter.CardLibrary.Cleave;
import gameEncounter.CardLibrary.IntimidatingCry;
import gameEncounter.CardLibrary.MeeleAttack;
import gameEncounter.CardLibrary.MightyBlow;
import gameEncounter.CardLibrary.Parry;
import gameEncounter.CardLibrary.Ram;
import gameEncounter.CardLibrary.RangedAttack;
import gameEncounter.CardLibrary.Wisdom;
import gameEncounter.ItemLibrary.RustyBlade;

public class TypeWarrior extends CharacterClass{

	public TypeWarrior(Game game) {
		super(game);
		cardPool.add(new CarefulSlash());
		cardPool.add(new BleedingSlice());
		cardPool.add(new Cleave());
		cardPool.add(new Bash());
		cardPool.add(new Bullwork());
		cardPool.add(new Ram());
		cardPool.add(new MightyBlow());
		cardPool.add(new Parry());
		cardPool.add(new IntimidatingCry());
		name="warrior";
		items.add(game.itemBuilder.buildItem("rustyBlade"));				
		for (int i=0; i<4;i++) {
			cards.add(game.cardBuilder.buildCard("meeleAttack"));
		}
		cards.add(game.cardBuilder.buildCard("basicAttack"));
		for (int i=0; i<5;i++) {
			cards.add(game.cardBuilder.buildCard("basicBlock"));
		}
	}

	public void modifyHero(Hero hero) {
		// TODO Auto-generated method stub
		super.modifyHero(hero);
		//mainstats
		hero.setStrength(hero.getStrength()+3);
		hero.setDexterity(hero.getDexterity()+2);
		hero.setIntelligence(hero.getIntelligence()+0);
		hero.setVitality(hero.getVitality()+5);
		//
		hero.setAttackSkill(hero.getAttackSkill()+1);
		hero.setBlockSkill(hero.getBlockSkill()+3);
		hero.setResistStress(hero.getResistStress()+1);
	}
}
