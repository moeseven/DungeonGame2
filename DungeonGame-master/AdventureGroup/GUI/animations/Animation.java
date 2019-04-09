package GUI.animations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;
import javax.swing.Timer;

import GUI.FightAnimationPanel;

public abstract class Animation implements ActionListener, Serializable{
	protected Timer timer1;
	protected int velX;
	protected int max;
	protected int stepCount;
	protected int cycleTime;
	protected boolean over;
	protected AnimationHandler ah;
	protected int animationIndex;
	protected int currentX=0;//0-100% multiply value by distance when used in gui
	protected int currentY=0;
	public Animation(AnimationHandler ah,int animationIndex) {
		this.ah=ah;
		this.animationIndex=animationIndex;
		cycleTime=5;
						
	}
	public void runAnimation() {
		timer1 = new Timer(cycleTime,this);
		timer1.start();
	}	
	public void resetAnimation() {
		timer1.stop();
		over=true;
		ah.animationArray[animationIndex]=0;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		cycleEvent();
	}
	public abstract void cycleEvent();
	//
	public int getCurrentX() {
		return currentX;
	}
	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}
	public int getCurrentY() {
		return currentY;
	}
	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}
	
}
