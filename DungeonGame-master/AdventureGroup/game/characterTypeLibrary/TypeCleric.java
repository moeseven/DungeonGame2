package game.characterTypeLibrary;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.Item;


public class TypeCleric extends CharacterClass{

	public TypeCleric(Game game) {
		super(game);
		cardPool.add("bash");
		cardPool.add("divineGrace");
		cardPool.add("heavenlyShield");
		cardPool.add("heavenlyStrength");
		cardPool.add("harden");
		cardPool.add("growth");
		cardPool.add("groupHeal");
		cardPool.add("shooAway");
		cardPool.add("electroStaticCharge");
		cardPool.add("hedgehog");
		cardPool.add("delayedCombustion");
		cardPool.add("smiteUndead");
		cardPool.add("guard");
		cardPool.add("energyBlock");
		cardPool.add("energyAttack");
		cardPool.add("doubleBlock");
		name="cleric";
		Item startItem = game.itemBuilder.buildItem("rustyBlade",6);
		items.add(startItem);
		cards.add(game.cardBuilder.buildCard("bash"));
		cards.add(game.cardBuilder.buildCard("divineGrace"));
		for (int i=0; i<5;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("basicBlock"));
		}
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		if (hero.getCharRace().getName().equals("human")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(39));
			hero.setImageNumber(39);
		}
		if (hero.getCharRace().getName().equals("dwarf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(38));
			hero.setImageNumber(38);
		}
		if (hero.getCharRace().getName().equals("elf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(122));
			hero.setImageNumber(122);
		}
		if (hero.getCharRace().getName().equals("halfling")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(123));
			hero.setImageNumber(123);
		}
		//mainstats
		
		hero.setStrength(hero.getStrength()+3);
		hero.setDexterity(hero.getDexterity()-1);
		hero.setIntelligence(hero.getIntelligence()+4);
		hero.setVitality(hero.getVitality()+5);
		//
		hero.setArmor(hero.getArmor()+1);
		hero.setSpellDuration(hero.getSpellDuration()+1);
		hero.setMagicDmg(hero.getMagicDmg()+5);
		hero.setBlockSkill(hero.getBlockSkill()+3);
		hero.setAttackSkill(hero.getAttackSkill()-2);
		hero.setSpellResist(hero.getSpellResist()+5);
		hero.setSpellPower(hero.getSpellPower()+3);
		hero.setResistStress(hero.getResistStress()+8);
		hero.setStunChance(hero.getStunChance()+2);
	}

}
