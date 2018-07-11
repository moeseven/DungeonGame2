package game.RoomLibrary;


import game.Game;
import game.Room;
import game.RoomInteractionLibrary.MedicineMan;
import game.RoomInteractionLibrary.QuestBoard;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Tavern;
import game.RoomInteractionLibrary.Well;

public class Town extends Room{
	private int idleStressRelief=3;
	public Town(Game game) {
		// TODO Auto-generated constructor stub
		super(game);
		getInteractions().add(new Shop());
		getInteractions().add(new Tavern());
		getInteractions().add(new MedicineMan());
		getInteractions().add(new QuestBoard());
	}

	@Override
	public void enterRoom() {
		// TODO Auto-generated method stub
		super.enterRoom();
		for(int i=0; i<game.getPlayer().getAvailableHeroes().size();i++) {
			game.getPlayer().getAvailableHeroes().get(i).setStress(game.getPlayer().getAvailableHeroes().get(i).getStress()-idleStressRelief);
			if (game.getPlayer().getAvailableHeroes().get(i).getStress()<0) {
				game.getPlayer().getAvailableHeroes().get(i).setStress(0);
			}
			game.getPlayer().getAvailableHeroes().get(i).setHp(game.getPlayer().getAvailableHeroes().get(i).computeMaxHp());
		}	
		if(game.getPlayer().getAvailableHeroes().size()<10) {
			game.getPlayer().getAvailableHeroes().add(game.generator.generateRandomHero(game.getPlayer()));
			game.getPlayer().getAvailableHeroes().add(game.generator.generateRandomHero(game.getPlayer()));
		}
		game.getActiveQuest().onReturnToTown(game.getPlayer());
		game.newQuest();
	}
	

}
