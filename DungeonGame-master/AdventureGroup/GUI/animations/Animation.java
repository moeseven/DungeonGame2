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
	protected boolean keepRunning;
	protected FightAnimationPanel jp;
	public Animation(FightAnimationPanel jp) {
		this.jp=jp;
		cycleTime=5;
		keepRunning=true;
		timer1 = new Timer(cycleTime,this);
		timer1.start();
		
	}
	public void runAnimation() {
		while(keepRunning) {
			try {
				Thread.sleep(cycleTime);
				cycleEvent();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		Thread t= new MyThread();
//		t.run();
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		cycleEvent();
	}
	public abstract void cycleEvent();
	private class MyThread extends Thread{
		private MyThread() {
			
		}

		@Override
		public void run() {
			super.run();
			while(keepRunning) {
				try {
					sleep(cycleTime);
					cycleEvent();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}
}
