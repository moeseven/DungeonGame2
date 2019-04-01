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
	protected FightAnimationPanel jp;
	public Animation(FightAnimationPanel jp) {
		this.jp=jp;
		timer1 = new Timer(5,this);
		timer1.start();
	}
	@Override
	public abstract void actionPerformed(ActionEvent arg0);
	
}
