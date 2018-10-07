package game;

import java.io.Serializable;
import java.util.LinkedList;


public abstract class Quest implements Serializable{
protected Room[][] roomLayout;//work on this
protected String description;
protected boolean finished;
protected int experienceReward;
protected int goldReward;
protected LinkedList<Room> rooms;
protected Game game;
	public Quest(Game game) {
		finished=false;
		rooms=new LinkedList<Room>();
		this.game=game;
	}
	public abstract boolean checkIfQuestFullfilled(Player player);
	public void giveReward(Player player) {
		player.gainGold(goldReward);
		for(int i=0; i<player.getHeroes().size();i++){
			player.getHeroes().get(i).gainExp(experienceReward/player.getHeroes().size());
		}
	}
	public void onReturnToTown(Player player) {		
		if(checkIfQuestFullfilled(player)&&finished==false) {
			finished=true;
		}		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LinkedList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(LinkedList<Room> rooms) {
		this.rooms = rooms;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public int getExperienceReward() {
		return experienceReward;
	}
	public void setExperienceReward(int experienceReward) {
		this.experienceReward = experienceReward;
	}
	public int getGoldReward() {
		return goldReward;
	}
	public void setGoldReward(int goldReward) {
		this.goldReward = goldReward;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
}
