package game;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Act implements Serializable{
	protected Room[][] roomMap;//work on this
	protected String description;
	protected boolean finished;
	protected Quest mainQuest;
	protected LinkedList<Quest> sidequests;
	protected Game game;
	protected Room startRoom;
	public Act(Game game) {
		roomMap= new Room[10][10];
		finished=false;
		this.game=game;
	}
	public boolean addRoom(Room room, int x,int y) {
		if (roomMap[x][y]==null) {
			roomMap[x][y]=room;
			room.setxCoordinate(x);
			room.setyCoordinate(y);
			return true;
		}else {
			return false;
		}		
	}
	public abstract boolean addRandomRoom(int x, int y);
	public abstract boolean checkIfActFullfilled(Player player);
	public void onReturnToTown(Player player) {		
		if(checkIfActFullfilled(player)&&finished==false) {
			finished=true;
		}		
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Room[][] getRoomMap() {
		return roomMap;
	}
	public void setRoomMap(Room[][] roomLayout) {
		this.roomMap = roomLayout;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Quest getMainQuest() {
		return mainQuest;
	}
	public void setMainQuest(Quest mainQuest) {
		this.mainQuest = mainQuest;
	}
	public Room getStartRoom() {
		return startRoom;
	}
	public void setStartRoom(Room startRoom) {
		this.startRoom = startRoom;
	}
	
}
