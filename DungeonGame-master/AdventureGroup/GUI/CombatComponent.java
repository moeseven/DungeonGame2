package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import gameEncounter.Card;
import gameEncounter.Card_new;
import gameEncounter.Hero;

public class CombatComponent extends JComponent{
	protected LinkedList<Hero> monsters;
	protected LinkedList<Hero> heroes;
	private JPanel jp2;
	private JPanel jp;
	private JScrollPane sp;
	private FightWindow fw;
	public CombatComponent(FightWindow fw){
		this.fw=fw;
		setBorder(new LineBorder(Color.RED));
		
		setLayout(new GridLayout());
		this.monsters= fw.getGame().getRoom().getFight().getMonsters();
		this.heroes=fw.getGame().getPlayer().getHeroes();
		jp=new JPanel();
		//jp.setLayout(new GridLayout());
		for (int i=fw.getGame().getPlayer().getHeroes().size()-1;i>=0;i--) {
			jp.add(new HeroFightComponent(fw,fw.getGame().getPlayer().getHeroes().get(i)));
		}
		jp.add(new FightBorder(fw,this));
		for (int i=0;i<monsters.size();i++){
			jp.add(new HeroFightComponent(fw,monsters.get(i)));
		}
		sp= new JScrollPane(jp);
		add(sp,BorderLayout.CENTER);
//		jp2=new JPanel();
//		jp2.add(new AttackIndication());
//		add(jp2,BorderLayout.SOUTH);
		setVisible(true);
	}
	private class FightBorder extends JComponent{
		private FightWindow fw;
		private CombatComponent cc;
		public static final int width=40;
		public FightBorder(FightWindow fw,CombatComponent cc) {
			this.fw=fw;
			this.cc=cc;
			super.setPreferredSize(new Dimension(width,180));
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
	private class AttackIndication extends JComponent{
		protected void paintComponent(Graphics g){
			//draw attack arrows here
			super.setPreferredSize(new Dimension(600,50));
			g.drawLine(10, 10, 70, 20);
				Map<Hero, HashMap<Card, Hero>> map =fw.getGame().getRoom().getFight().getTargetMap();
				Iterator it = map.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        //
			        int start_x=(HeroComponent.WIDTH*(heroes.size()+monsters.indexOf(pair.getKey()))+FightBorder.WIDTH);//calculate starting x position
			        int y= 13;
			        HashMap<Card, Hero> map2=(HashMap<Card, Hero>) pair.getValue();
			        Iterator it2 = map2.entrySet().iterator();
				    while (it2.hasNext()) {
				        Map.Entry pair2 = (Map.Entry)it2.next();
				        //
				        int end_x=HeroComponent.WIDTH*(heroes.size()-heroes.indexOf(pair2.getValue()));
				        Card_new card= (Card_new) pair2.getKey();
				        if (card.getSpellDamage()>0||card.getAttackDamage()>0&&heroes.contains(pair2.getValue())){
							g.setColor(Color.RED);
				        	g.drawLine(start_x, y, end_x, y);
						}		
				        it2.remove(); // avoids a ConcurrentModificationException
				    }
			        //System.out.println(pair.getKey() + " = " + pair.getValue());
			        it.remove(); // avoids a ConcurrentModificationException
			    }
			}		
	}
	
}

