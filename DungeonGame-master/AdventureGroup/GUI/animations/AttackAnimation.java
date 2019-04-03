package GUI.animations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.Timer;

import GUI.FightAnimationPanel;

public class AttackAnimation extends Animation implements ActionListener, Serializable{
	protected int stepCount2;
	public AttackAnimation(FightAnimationPanel jp) {
		super(jp);
		stepCount=40;max=60;velX=3;stepCount2=20;
		//runAnimation();
	}

	@Override
	public void cycleEvent() {
		stepCount--;
		if (stepCount<0) {
			stepCount2--;
			if (jp.animationValues[2]>=max/2||jp.animationValues[2]<0) {
				velX=-velX;
			}
			jp.animationValues[2]+=velX;
			jp.repaint();
			if (stepCount2<0) {				
				timer1.stop();
				keepRunning=false;
				jp.resetAnimation();
			}			
		}else {
			if (jp.animationValues[0]>=max||jp.animationValues[0]<0) {
				velX=-velX;
			}
			jp.animationValues[0]+=velX;
			jp.repaint();
		}
		
	}
	
}
