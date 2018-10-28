package game.Leaderboard;

import java.io.Serializable;
import java.util.LinkedList;

import game.Game;
import gameEncounter.Item;

public class LeaderBoardEntry implements Serializable{
private int turns;
private String playerName;
private int points;
public LeaderBoardEntry(int turns, String playerName, int points) {
	super();
	this.turns = turns;
	this.playerName = playerName;
	this.points = points;
}
public LeaderBoardEntry(Game game, String playerName) {
	turns=game.turn;
	this.playerName=playerName;
	int pointsum=0;
	for (int i = 0; i < game.getPlayer().getHeroes().size(); i++) {
		pointsum+=game.getPlayer().getHeroes().get(i).getExperience()*3;
		LinkedList<Item> items=game.getPlayer().getHeroes().get(i).getEquipment().getAllEquippedItems();
		for (int j = 0; j < items.size(); j++) {
			pointsum+=items.get(j).getGoldValue()/4;//item would sell for 1/5
		}
		
	}
	for (int i = 0; i < game.getPlayer().getAvailableHeroes().size(); i++) {
		pointsum+=game.getPlayer().getAvailableHeroes().get(i).getExperience()*3;
		LinkedList<Item> items=game.getPlayer().getAvailableHeroes().get(i).getEquipment().getAllEquippedItems();
		for (int j = 0; j < items.size(); j++) {
			pointsum+=items.get(j).getGoldValue()/4;
		}
	}
	for (int i = 0; i < game.getPlayer().getInventory().size(); i++) {
		pointsum+=game.getPlayer().getInventory().get(i).getGoldValue()/4;
	}
	points=(pointsum+game.getPlayer().getGold()+game.points-100)/(turns+5);
}
public int getTurns() {
	return turns;
}
public void setTurns(int turns) {
	this.turns = turns;
}
public String getPlayerName() {
	return playerName;
}
public void setPlayerName(String playerName) {
	this.playerName = playerName;
}
public int getPoints() {
	return points;
}
public void setPoints(int points) {
	this.points = points;
}

}
