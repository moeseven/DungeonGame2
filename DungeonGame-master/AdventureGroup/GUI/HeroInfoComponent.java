package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import gameEncounter.Card;
import gameEncounter.Hero;

public class HeroInfoComponent extends JComponent{
		private Hero hero;
		private JPanel jp;
		private JPanel jp_Equip;
		private JPanel jp_Stats;
		private JScrollPane sp;
		private StatsWindow gf;
		public HeroInfoComponent(StatsWindow gf,Hero hero){
			this.gf=gf;
			this.hero=hero;
			setBorder(new LineBorder(Color.GREEN));
			super.setPreferredSize(new Dimension(1000,600));
			MyMouseListener ml = new MyMouseListener();
			super.addMouseListener(ml);
			setLayout(new BorderLayout());
			jp_Equip= new JPanel();
			jp_Equip.add(new HeroInventoryPaintComponent(gf));
			jp_Stats=new JPanel();
			jp_Stats.add(new HeroStatsPaintComponent(gf));
			jp=new JPanel();
			sp=new JScrollPane();
			sp.add(jp);
			jp.add(new DeckPaintComponent(gf, hero));
			this.add(sp, BorderLayout.LINE_END);
			this.add(jp_Equip, BorderLayout.CENTER);
			this.add(jp_Stats, BorderLayout.NORTH);
			setVisible(true);
		}

	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){	
			if(e.getButton()==1){
				int x=e.getX();
				int y=e.getY();
				//get card position from click
				int i=Math.round(x/100);
				//handle clicks in hero info
			}else{
				if (e.getButton()==3){
					//new CardView(card);
				}
			}
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}

