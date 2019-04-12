package GUI.animations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.DungeonMaster;
import gameEncounter.Hero;

public class MissileAnimation extends Animation implements ActionListener, Serializable{
	protected int missileImage;
	protected Hero shooter,shot;
	public MissileAnimation(AnimationHandler ah, int animationIndex, int missileImage, Hero shooter, Hero shot) {
		super(ah, animationIndex+2);
		//negative value is monsters 3,2,1,0  -1,-2,-3,-4,-5
		this.shooter=shooter;
		this.shot= shot;
		this.missileImage=missileImage;
		velX=1;
		max=150; 
		stepCount=150;		
	}
	@Override
	public void cycleEvent() {
		currentX+=velX;		
		stepCount--;
		if (stepCount<0) {				
			resetAnimation();
		}		
	}
	//getters and setters
	public int getMissileImage() {
		return missileImage;
	}

	public void setMissileImage(int missileImage) {
		this.missileImage = missileImage;
	}
	public Hero getShooter() {
		return shooter;
	}
	public void setShooter(Hero shooter) {
		this.shooter = shooter;
	}
	public Hero getShot() {
		return shot;
	}
	public void setShot(Hero shot) {
		this.shot = shot;
	}
	
}
