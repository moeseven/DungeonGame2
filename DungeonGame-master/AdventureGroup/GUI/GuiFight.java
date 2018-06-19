package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import game.Player;
import gameEncounter.Fight;

public class GuiFight extends JPanel{
	private Fight fight;
	private FightWindow fw;
	private HeroComponent hc;
	private CombatComponent mc;
	private JButton b;
	private JPanel jp_mid_1;
	private JTextField tf;
	private Player player;
	public GuiFight(FightWindow fw) {
		this.fw=fw;
		if(this.fw.getGame().getRoom().getFight()!=null) {
			this.fight=this.fw.getGame().getRoom().getFight();	
			
			setLayout(new BorderLayout());
//			// Player dialog
//			tf= new CommandLine(gf,player);//new JTextField(player.getMessage());
//			//
			myUpdate();
			setVisible(true);
		}		
	}
	private class ml extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
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
		jp_mid_1= new JPanel();
		jp_mid_1.setLayout(new BorderLayout());
		jp_mid_1.add(mc,BorderLayout.NORTH);
		jp_mid_1.add(hc,BorderLayout.CENTER);
		this.add(jp_mid_1,BorderLayout.CENTER);
		b=new JButton("done");
		b.addMouseListener(new ml());
		this.add(b,BorderLayout.SOUTH);
	}
	public void upadate(){
		this.remove(jp_mid_1);
		hc=new HeroComponent(this.fw);
		mc=new CombatComponent(this.fw);
		jp_mid_1= new JPanel();
		jp_mid_1.setLayout(new BorderLayout());
		jp_mid_1.add(mc,BorderLayout.NORTH);
		jp_mid_1.add(hc,BorderLayout.CENTER);
		this.add(jp_mid_1,BorderLayout.CENTER);
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
	
}
