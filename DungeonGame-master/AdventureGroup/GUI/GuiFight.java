package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

import game.Player;
import gameEncounter.Fight;
import tools.MyLog;

public class GuiFight extends JPanel{
	private Fight fight;
	private FightWindow fw;
	private HeroComponent hc;
	private CombatComponent mc;
	private LogComponent lc;
	private JButton b;
	private JPanel jp_mid_1;
	private JPanel jp_south;
	private JTextField tf;
	private Player player;
	public GuiFight(FightWindow fw) {
		this.fw=fw;
		if(this.fw.getGame().getRoom().getFight()!=null) {
			this.fight=this.fw.getGame().getRoom().getFight();				
			setLayout(new BorderLayout());
			myUpdate();
			setVisible(true);
		}		
	}
	private class ml extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			fw.getGame().getRoom().getFight().nextTurn();
			fw.getGuiFight().upadate();
			fw.revalidate();
			fw.repaint();
			if(fw.getGame().getRoom().getFight().isFightOver()) {
				fw.windowswitch();
			}
		}
	}
	public void myUpdate() {
		// TODO Auto-generated method stub
		hc=new HeroComponent(this.fw);
		mc=new CombatComponent(this.fw);
		lc=new LogComponent(fw.getGame().log);
		jp_mid_1= new JPanel();
		jp_mid_1.setLayout(new BorderLayout());
		jp_mid_1.add(mc,BorderLayout.NORTH);
		jp_mid_1.add(hc,BorderLayout.CENTER);
		jp_mid_1.add(lc,BorderLayout.SOUTH);
		this.add(jp_mid_1,BorderLayout.CENTER);
		b=new JButton("end turn");
		b.addMouseListener(new ml());
		this.add(b,BorderLayout.SOUTH);
	}
	public void upadate(){
		this.remove(jp_mid_1);
		hc=new HeroComponent(this.fw);
		mc=new CombatComponent(this.fw);
		lc=new LogComponent(fw.getGame().log);
		jp_mid_1= new JPanel();
		jp_mid_1.setLayout(new BorderLayout());
		jp_mid_1.add(mc,BorderLayout.NORTH);
		jp_mid_1.add(hc,BorderLayout.CENTER);
		jp_mid_1.add(lc,BorderLayout.SOUTH);
		this.add(jp_mid_1,BorderLayout.CENTER);
		fw.setVisible(true);
	}
	public HeroComponent getHc() {
		return hc;
	}
	public void setHc(HeroComponent hc) {
		this.hc = hc;
	}
	public CombatComponent getMc() {
		return mc;
	}
	public void setMc(CombatComponent mc) {
		this.mc = mc;
	}
	public LogComponent getLc() {
		return lc;
	}
	public void setLc(LogComponent lc) {
		this.lc = lc;
	}
	
}
