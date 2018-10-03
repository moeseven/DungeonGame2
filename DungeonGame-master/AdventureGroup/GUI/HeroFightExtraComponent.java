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

public class HeroFightExtraComponent extends JComponent{
	private HandComponent handComponent;
	private HandPaintComponent hpc;
	private JPanel jp;
	private JScrollPane sp;
	private FightWindow fw;
	public HeroFightExtraComponent(FightWindow fw) {
		this.fw=fw;
		handComponent=new HandComponent(fw);
		hpc=new HandPaintComponent(fw);
		setLayout(new BorderLayout());
		jp=new JPanel();
		jp.add(hpc);
		add(jp,BorderLayout.CENTER);
		add(new HeroFightManaComponent(fw),BorderLayout.WEST);
	}
	public HandComponent getHandComponent() {
		return handComponent;
	}
	public void setHandComponent(HandComponent handComponent) {
		this.handComponent = handComponent;
	}
	
}
