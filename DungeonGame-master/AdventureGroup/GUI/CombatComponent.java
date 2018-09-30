package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import gameEncounter.Card;
import gameEncounter.Hero;

public class CombatComponent extends JComponent{
	private LinkedList<Hero> monsters;
	private JPanel jp;
	private JScrollPane sp;
	private FightWindow fw;
	public CombatComponent(FightWindow fw){
		this.fw=fw;
		setBorder(new LineBorder(Color.RED));
		setLayout(new GridLayout());
		this.monsters= fw.getGame().getRoom().getFight().getMonsters();
		jp=new JPanel();
		for (int i=fw.getGame().getPlayer().getHeroes().size()-1;i>=0;i--) {
			jp.add(new HeroFightComponent(fw,fw.getGame().getPlayer().getHeroes().get(i)));
		}
		jp.add(new FightBorder(fw));
		for (int i=0;i<monsters.size();i++){
			jp.add(new MonsterFightComponent(fw,monsters.get(i)));
		}
		sp= new JScrollPane(jp);
		add(sp,BorderLayout.CENTER);
	}
	private class FightBorder extends JComponent{
		private Image image;
		private FightWindow fw;
		public FightBorder(FightWindow fw) {
			this.fw=fw;
			super.setPreferredSize(new Dimension(40,180));
			setLayout(new BorderLayout());
			setVisible(true);
		}
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.black);
			g.drawString("round", 5, 120);
			if (fw.getGame().getRoom().getFight()!=null) {
				g.drawString(""+fw.getGame().getRoom().getFight().getRound(), 15, 135);
			}
		}
	}
}

