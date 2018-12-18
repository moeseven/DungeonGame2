package game.characterTypeLibrary;

import game.CharacterClass;
import game.Game;
import gameEncounter.Hero;
import gameEncounter.Item;

public class TypeThief extends CharacterClass{

	public TypeThief(Game game) {
		super(game);
		name="thief";
		cardPool.add("backStab");
		cardPool.add("blind");
		cardPool.add("poisonClowd");
		cardPool.add("poisonousSlice");		
		cardPool.add("daggerThrow");
		cardPool.add("feint");
		cardPool.add("carefulSlash");
		cardPool.add("hook");
		cardPool.add("observeFirst");
		cardPool.add("arsenal");
		cardPool.add("daggerArsenal");
		cardPool.add("armorCracker");
		cardPool.add("combo");
		cardPool.add("reEvaluate");
		cardPool.add("amplifyingMixture");
		cardPool.add("diminishingAttack");
		cardPool.add("diminishingBlock");
		cardPool.add("heavyPoison");
		Item startItem = game.itemBuilder.buildItem("rustyBlade",5);
		items.add(startItem);
		cards.add(game.cardBuilder.buildCard("feint"));
		cards.add(game.cardBuilder.buildCard("daggerThrow"));	
		cards.add(game.cardBuilder.buildCard("poisonDagger"));	
		for (int i=0; i<5;i++) {
			cards.add(game.cardBuilder.buildCard("basicAttack"));
			cards.add(game.cardBuilder.buildCard("basicBlock"));
		}
//		cards.add(game.cardBuilder.buildCard("backStab"));
//		cards.add(game.cardBuilder.buildCard("blindingBomb"));
//		cards.add(game.cardBuilder.buildCard("poisonBomb"));
//		cards.add(game.cardBuilder.buildCard("poisonousSlice"));
//		cards.add(game.cardBuilder.buildCard("daggerThrow"));
//		cards.add(game.cardBuilder.buildCard("feint"));
//		cards.add(game.cardBuilder.buildCard("sideStep"));
	}

	public void modifyHero(Hero hero) {
		super.modifyHero(hero);
		if (hero.getCharRace().getName().equals("human")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(25));
			hero.setImageNumber(25);
		}
		if (hero.getCharRace().getName().equals("dwarf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(35));
			hero.setImageNumber(35);
		}
		if (hero.getCharRace().getName().equals("elf")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(36));
			hero.setImageNumber(36);
		}
		if (hero.getCharRace().getName().equals("halfling")) {
			//hero.setImage(hero.getPlayer().getGame().imageLoader.getImage(37));
			hero.setImageNumber(37);
		}
		//mainstats
		hero.setStrength(hero.getStrength()+2);
		hero.setDexterity(hero.getDexterity()+4);
		hero.setIntelligence(hero.getIntelligence()+2);
		hero.setVitality(hero.getVitality()+1);
		//
		hero.setPoisonDmg(hero.getPoisonDmg()+5);
		hero.setCritChance(hero.getCritChance()+7);
		hero.setCritDamage(hero.getCritDamage()+10);
		hero.setDodge(hero.getDodge()+4);
		hero.setSpeed(hero.getSpeed()+2);
		hero.setTrapDisarm(hero.getTrapDisarm()+40);
		hero.setResistStress(hero.getResistStress()-4);
		hero.setStunChance(hero.getStunChance()+1);
	}
}
