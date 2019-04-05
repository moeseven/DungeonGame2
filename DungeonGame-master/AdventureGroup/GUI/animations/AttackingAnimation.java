package GUI.animations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.Timer;

import GUI.FightAnimationPanel;

public class AttackingAnimation extends Animation implements ActionListener, Serializable{
	public AttackingAnimation(AnimationHandler ah, int animationIndex) {
		super(ah, animationIndex);
		stepCount=40;max=60;velX=3;
	}
	
	@Override
	public void cycleEvent() {
		if (ah.animationArray[animationIndex]>max||ah.animationArray[animationIndex]<0) {
			velX=-velX;
		}
		ah.animationArray[animationIndex]+=velX;
		stepCount--;
		if (stepCount<0) {				
			resetAnimation();
		}		
	}
	
}
