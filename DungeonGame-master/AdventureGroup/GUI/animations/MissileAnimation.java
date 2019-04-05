package GUI.animations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.Timer;

import GUI.FightAnimationPanel;
import gameEncounter.Hero;

public class MissileAnimation extends Animation implements ActionListener, Serializable{
	protected int missileImage;
	public MissileAnimation(AnimationHandler ah, int animationIndex, int missileImage) {
		super(ah, animationIndex+2);
		velX=4;
		max=100;
		stepCount=25;
		ah.missileImage[animationIndex]=missileImage;
	}
	
	@Override
	public void cycleEvent() {
		ah.animationArray[animationIndex]+=velX;
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
	
}
