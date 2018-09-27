package game;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import gameEncounter.Hero;

public abstract class RoomInteraction implements Serializable{
	protected String name;
	protected boolean hidden;
	//protected BufferedImage image;
	protected int imageNumber;
	protected Game game;
	public RoomInteraction(Game game) {
		super();
		this.game=game;
		name="room interaction";
		// TODO Auto-generated constructor stub
	}

	public abstract void onEnter(Game game);//triggered on entering the room (traps)

	public abstract void onInteraction(Hero hero);//triggered when interacted with	

	//getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}

//	public BufferedImage getImage() {
//		return image;
//	}
//
//	public void setImage(BufferedImage image) {
//		this.image = image;
//	}


	
}
