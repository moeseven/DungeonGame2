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

public class GuiInventory extends JPanel{
	private StatsWindow gf;
	private HeroFightExtraComponent hc;
	private CombatComponent mc;
	private JButton b;
	private JPanel jp_center;
	private JPanel jp_south;
	private JTextField tf;
	public GuiInventory(StatsWindow gf) {
		this.gf=gf;
		setLayout(new BorderLayout());
		jp_center= new JPanel();
		jp_center.setLayout(new BorderLayout());
		this.add(jp_center,BorderLayout.CENTER);
		jp_center.add(new HeroInfoComponent(gf,gf.getGame().getPlayer().getSelectedHero()));
		b=new JButton("done");
		b.addMouseListener(new ml());
		this.add(b,BorderLayout.SOUTH);
		setVisible(true);
	}
	private class ml extends MouseAdapter{
		public void mousePressed(MouseEvent e){
			//done
			gf.windowswitch();
			gf.getRw().getGuiRoom().upadate();
//			gf.revalidate();
//			gf.repaint();
		}
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
	
}
