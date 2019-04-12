package GUI.animations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.Timer;

import GUI.FightAnimationPanel;

public class DodgeAnimation extends Animation implements ActionListener, Serializable{
	public DodgeAnimation(AnimationHandler ah, int animationIndex) {
		super(ah, animationIndex);
		stepCount=20;max=-30;velX=-3;
	}
	
	@Override
	public void cycleEvent() {
		if (ah.animationArray[animationIndex]<max||ah.animationArray[animationIndex]>0) {
			velX=-velX;
		}
		ah.animationArray[animationIndex]+=velX;
		ah.animationArray[animationIndex+1]+=velX;
		stepCount--;
		if (stepCount<0) {				
			resetAnimation();
		}		
	}
	
}
