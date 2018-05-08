package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import gameEncounter.Hero;

public class HeroComponent extends JComponent{
	private Hero hero;
	private HandComponent handComponent;
	private HandPaintComponent hpc;
	private JPanel jp;
	private JScrollPane sp;
	private GameWindow gf;
	public HeroComponent(GameWindow gf, Hero hero) {
		this.gf=gf;
		this.hero=hero;
		handComponent=new HandComponent(gf,hero);
		hpc=new HandPaintComponent(gf,hero);
		setLayout(new BorderLayout());
		jp=new JPanel();
		jp.add(hpc);
		add(jp,BorderLayout.CENTER);
		add(new HeroStatsComponent(gf,hero),BorderLayout.WEST);
	}
	public HandComponent getHandComponent() {
		return handComponent;
	}
	public void setHandComponent(HandComponent handComponent) {
		this.handComponent = handComponent;
	}
	
}
