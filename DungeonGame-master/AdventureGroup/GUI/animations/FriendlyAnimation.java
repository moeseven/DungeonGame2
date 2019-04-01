package GUI.animations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.Timer;

import GUI.FightAnimationPanel;

public class FriendlyAnimation extends Animation implements ActionListener, Serializable{
	public FriendlyAnimation(FightAnimationPanel jp) {
		super(jp);
		stepCount=20;max=20;velX=2;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (jp.animationValues[1]>max||jp.animationValues[1]<0) {
			velX=-velX;
		}
		jp.animationValues[1]+=velX;
		jp.repaint();
		stepCount--;
		if (stepCount<0) {				
			timer1.stop();
			jp.resetAnimation();
		}		
	}
	
}
