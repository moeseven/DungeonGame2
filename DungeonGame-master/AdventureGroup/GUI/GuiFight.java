package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
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
	private HeroFightExtraComponent hc;
	private CombatComponent mc;
	private LogComponent lc;
	private JButton b;
	private JButton buttonRetreat;
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
			endTurn();
		}
	}
	private void endTurn() {
		if (!fw.getGame().getRoom().getFight().heroesAlive()) {
			
			fw.getGame().tpHeroes();
			fw.windowswitch();
			//fw.getGame().enterRoom(fw.getGame().getRoom());
		}else {
			fw.getGame().getRoom().getFight().nextTurn();
		}		
		upadate();
		fw.revalidate();
		fw.repaint();
		if(!fw.getGame().getRoom().getFight().monstersAlive()) {
			fw.getGame().getRoom().setHasFight(false);
			fw.windowswitch();
		}
		
	}
	
	private class mlRetreat extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			//try to retreat
			fw.getGame().getRoom().getFight().retreatWish+=fw.getGame().getPlayer().getSelectedHero().getMana()/fw.getGame().getPlayer().getSelectedHero().getManaPower();			
			if (Math.random()*3<fw.getGame().getRoom().getFight().retreatWish&&fw.getGame().getPlayer().getSelectedHero().getMana()>0) {
				fw.getGame().getRoom().getFight().handleFightisOver();
				fw.getGame().retreatHeroes();
				fw.windowswitch();
			}else{
				fw.getGame().log.addLine("retreat failed!");
				fw.getGame().getPlayer().getSelectedHero().setMana(0); 
				endTurn();
			}
		}
	}
	public void myUpdate() {
		hc=new HeroFightExtraComponent(this.fw);
		mc=new CombatComponent(this.fw);
		lc=new LogComponent(fw.getGame().log);
		jp_mid_1= new JPanel();
		jp_mid_1.setLayout(new BorderLayout());
		jp_mid_1.add(mc,BorderLayout.NORTH);
		jp_mid_1.add(hc,BorderLayout.CENTER);
		jp_mid_1.add(lc,BorderLayout.SOUTH);
		this.add(jp_mid_1,BorderLayout.CENTER);
		jp_south= new JPanel();
		jp_south.setLayout(new FlowLayout());
		b=new JButton("end turn");
		b.addMouseListener(new ml());
		jp_south.add(b);
		buttonRetreat= new JButton("retreat");
		buttonRetreat.addMouseListener(new mlRetreat());
		jp_south.add(buttonRetreat);
		this.add(jp_south,BorderLayout.SOUTH);
	}
	public void upadate(){
		this.remove(jp_mid_1);
		hc=new HeroFightExtraComponent(this.fw);
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
	public HeroFightExtraComponent getHc() {
		return hc;
	}
	public void setHc(HeroFightExtraComponent hc) {
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
	public Fight getFight() {
		return fight;
	}
	public void setFight(Fight fight) {
		this.fight = fight;
	}
	
}
