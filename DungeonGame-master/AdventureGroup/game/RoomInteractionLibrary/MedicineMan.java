package game.RoomInteractionLibrary;

import java.util.LinkedList;

import game.Game;
import game.Player;
import game.Quest;
import game.RoomInteraction;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.ItemLibrary.usables.PotionOfHealth;


public class MedicineMan extends RoomInteraction{
	private LinkedList<Hero> heroestress=new LinkedList<Hero>();
	private LinkedList<Hero> heroeswound=new LinkedList<Hero>();
	private int baseHealFee=6;
	private int baseWoundHealFee=110;
	private int baseStressHealFee=10;
	private int freeTreatments = 0;
	private boolean giveRatFurReward=false;
	private Quest ratFurQuest;
	public MedicineMan(Game game) {
		super(game);
		ratFurQuest= new medicineManQuestRatFur(game);
		setImageNumber(107);
		name="medicine man";

	}
	public int computeHealFee(Hero hero) {
		if (freeTreatments>0) {
			return 0;
		}else {
			return baseHealFee*(hero.getLevel()+2);
		}		
	}
	public int computeStressHealFee(Hero hero) {
		return baseStressHealFee*(hero.getLevel()+2);
	}
	public int computeWoundHealFee(Hero hero) {
		return baseWoundHealFee*(hero.getLevel()+2);
	}
	public boolean purchaseWoundHealing(Hero hero){
		if (hero.getWounds()>0) {
			if(game.getPlayer().getHeroes().contains(hero)&&hero.getWounds()>0) {
				if(game.getPlayer().getGold()>=computeWoundHealFee(hero)) {
						game.getPlayer().gainGold(-computeWoundHealFee(hero));
						hero.setWounds(hero.getWounds()-1);
						return true;
				}
			}
		}else {
			game.log.addLine("hero has no wounds");
		}
		
		return false;
	}
	public boolean purchaseStressHealing(Hero hero){
		if (hero.getStress()<hero.getStressCap()) {
			if(game.getPlayer().getHeroes().contains(hero)) {
				if(game.getPlayer().getGold()>=computeStressHealFee(hero)) {
						game.getPlayer().gainGold(-computeStressHealFee(hero));
						hero.gainMoral(50);
						return true;
				}
			}
		}else {
			game.log.addLine("hero is not stressed");
		}
		
		return false;
	}
	public boolean purchaseHealing(Hero hero){
		if (hero.getHp()<GameEquations.maxHealthCalc(hero)) {
			if(game.getPlayer().getHeroes().contains(hero)) {
				if(game.getPlayer().getGold()>=computeHealFee(hero)) {
						game.getPlayer().gainGold(-computeHealFee(hero));
						if (freeTreatments>0) {
							freeTreatments--;
						}
						hero.heal(GameEquations.maxHealthCalc(hero));
						return true;
				}
			}
			
		}else {
			game.log.addLine("allready at full health");
		}
		
		return false;
	}
	@Override
	public void onEnter(Game game) {
		
	}

	@Override
	public void onInteraction(Hero hero) {
		if(hero!=null) {
			hero.getPlayer().getGame().log.addLine("entering medicine hut");
			hero.getPlayer().getGame().getRoom().setMedicine(this);
			hero.getPlayer().getGame().getRoom().setMedicineOpen(true);
			if (giveRatFurReward) {
				game.getPlayer().addItemtoInventory(new PotionOfHealth());
				game.getAvailableQuests().remove(ratFurQuest);
			
				giveRatFurReward=false;
			}else {
				if (!game.getAvailableQuests().contains(ratFurQuest)&&!ratFurQuest.isFinished()) {
					game.addNewQuest(ratFurQuest);
				}
			}
		}
		
	}
	public LinkedList<Hero> getHeroestress() {
		return heroestress;
	}

	public void setHeroestress(LinkedList<Hero> heroestress) {
		this.heroestress = heroestress;
	}

	public LinkedList<Hero> getHeroeswound() {
		return heroeswound;
	}

	public void setHeroeswound(LinkedList<Hero> heroeswound) {
		this.heroeswound = heroeswound;
	}
	private class medicineManQuestRatFur extends Quest{
		public medicineManQuestRatFur(Game game) {
			super(game);
			gamePoints=200;
			experienceReward=20;
			description= "collect 5 ratFur and bring them to the medicine man";
		}

		@Override
		public boolean checkIfQuestFullfilled(Player player) {
			int ratFurCount=0;
			for (int i = 0; i < player.getInventory().size(); i++) {
				if (player.getInventory().get(i).getItemClass().equals("ratFur")) {
					ratFurCount++;
				}
			}
			System.out.println(ratFurCount);
			if(ratFurCount>=5) {
				game.log.addLine("You brought the ratFur requested by the medicine man. Visit him to claim your reward!");
				giveRatFurReward=true;
				int furToRemove=5;
				for (int i = 0; i < player.getInventory().size(); i++) {
					if (player.getInventory().get(i).getItemClass().equals("ratFur")) {
						game.getPlayer().getInventory().remove(player.getInventory().get(i));
						furToRemove--;
					}
				}	
				giveReward(player);
				finished=true;
				return true;
			}			
			return false;
		}
		
	}

}
