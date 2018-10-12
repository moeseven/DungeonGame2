package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
		private JPanel jp_Deck;
		private JPanel jp_Equip_Stats;
		private JScrollPane sp;
		private StatsWindow gf;
		protected boolean removeCard;
		protected boolean addCard;
		protected boolean decide;
		public HeroInfoComponent(StatsWindow gf,Hero hero){
			this.gf=gf;
			this.hero=hero;
			
			setBorder(new LineBorder(Color.GREEN));
			super.setPreferredSize(new Dimension(500,900));
			MyMouseListener ml = new MyMouseListener();
			super.addMouseListener(ml);
			setLayout(new BorderLayout());
			jp_Equip_Stats=new JPanel();
			jp_Equip_Stats.setLayout(new BorderLayout());
			jp_Equip= new JPanel();
			jp_Equip.add(new HeroInventoryPaintComponent(gf));
			jp_Stats=new JPanel();
			jp_Stats.add(new HeroStatsPaintComponent(gf.getGame().getPlayer()));
			jp_Equip_Stats.add(jp_Stats,BorderLayout.NORTH);
			jp_Equip_Stats.add(jp_Equip,BorderLayout.SOUTH);
			jp_Deck=new JPanel();
			jp_Deck.setLayout(new BorderLayout());			
			jp=new JPanel();
			sp=new JScrollPane(jp);
			sp.setPreferredSize(new Dimension(115, 900));
			jp.add(new DeckPaintComponent(gf,this, hero));
			jp_Deck.add(sp,BorderLayout.EAST);
			if (hero.getLvlUpCards().size()>0) {
				decide=true;
			}
			if(hero.getLvlUpCards().size()>0&&decide) {
				jp_Deck.add(new removeOrAddPaintComponent(this),BorderLayout.WEST);
			}	
			if (addCard||removeCard) {
				jp_Deck.add(new LvlUpCardRewardPaintComponent(gf,this, hero),BorderLayout.WEST);
			}
			if(hero.getSkillPoints()>0) {
				jp_Deck.add(new StatsSkillComponent(gf, hero),BorderLayout.NORTH);
			}
			this.add(jp_Deck, BorderLayout.LINE_END);
			this.add(jp_Equip_Stats, BorderLayout.CENTER);
			setVisible(true);
		}

	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){	
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
	private class removeOrAddPaintComponent extends JComponent{
		private JButton buttonAdd;
		private JButton buttonRemove;
		private HeroInfoComponent hic;
		public removeOrAddPaintComponent(HeroInfoComponent hic) {
			super();
			this.hic=hic;
			setVisible(true);
			super.setPreferredSize(new Dimension(60,120));
			buttonAdd=new JButton("add a new card");
			buttonAdd.addMouseListener(new MouseListenerButtonAdd());
			this.add(buttonAdd);
			buttonRemove=new JButton("remove a card");
			buttonRemove.addMouseListener(new MouseListenerButtonRemove());
			this.add(buttonRemove);
		}
		private class MouseListenerButtonAdd extends MouseAdapter{
			public void mousePressed(MouseEvent e){	
				hic.addCard=true;
				hic.decide=false;
			}
		}
		private class MouseListenerButtonRemove extends MouseAdapter{
			public void mousePressed(MouseEvent e){	
				hic.removeCard=true;
				hic.decide=false;
			}
		}
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			if (hic.removeCard) {
				g.drawString("click a card in your deck to remove", 10, 15);
			}
			if (hic.addCard) {
				g.drawString("choose a card to add to your deck", 10, 15);
			}
			g.drawString("is this component even there?", 0, 45);
		}	
	}
	
	private class LvlUpCardRewardPaintComponent extends JComponent{
		private Hero hero;
		private StatsWindow gw;
		private int cardHeight=100;
		private int cardWidth=80;
		private HeroInfoComponent hic;
		public LvlUpCardRewardPaintComponent(StatsWindow gw, HeroInfoComponent hic,Hero hero){
			this.gw=gw;
			this.hic=hic;
			this.hero=hero;
			setBorder(new LineBorder(Color.ORANGE));
			super.setPreferredSize(new Dimension(cardWidth+1,hero.getLvlUpCards().size()*cardHeight+210));
			MyMouseListener ml = new MyMouseListener();
			addMouseListener(ml);
			setVisible(true);
		}

	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){	
			if(e.getButton()==1){
				int x=e.getX();
				int y=e.getY();
				//get card position from click
				int i=Math.round(y/cardHeight);
				if (gw.getGame().getPlayer().getSelectedHero().getSelectedCard()==hero.getLvlUpCards().get(i)) {
					if (i<hero.getCharClass().getCardPool().size()) {					
						gw.getGame().getPlayer().getSelectedHero().setSelectedCard(hero.getLvlUpCards().get(i));
						gw.getGame().getPlayer().getSelectedHero().getDeck().getCards().addFirst(gw.getGame().getPlayer().getSelectedHero().getSelectedCard());
						hic.addCard=false;
						gw.getGame().getPlayer().getSelectedHero().setCardPoints(gw.getGame().getPlayer().getSelectedHero().getCardPoints()-1);
					}						
					gw.getGame().getPlayer().getSelectedHero().setLvlUpCards(new LinkedList<Card>());
					if(gw.getGame().getPlayer().getSelectedHero().getCardPoints()>0) {
						gw.getGame().getPlayer().getSelectedHero().generatelvlUpCards();
					}
				}else {
					if (i<hero.getCharClass().getCardPool().size()) {					
						gw.getGame().getPlayer().getSelectedHero().setSelectedCard(hero.getLvlUpCards().get(i));									
					}
				}
				
				gw.myUpdate();
				gw.repaint();			
			}else{
				if (e.getButton()==3){
					//new CardView(card);
				}
			}
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for (int i=0;i<hero.getLvlUpCards().size();i++){
			g.setColor(Color.black);
			g.drawString(hero.getLvlUpCards().get(i).getName(), 10, 15+i*cardHeight);
			g.drawString(""+hero.getLvlUpCards().get(i).computeManaCost(hero), 5, 10+i*cardHeight);
			if(gw.getGame().getPlayer().getSelectedHero().getSelectedCard()==hero.getLvlUpCards().get(i)){
				g.setColor(Color.red);
				g.drawRect(1, 1+i*cardHeight, cardWidth, cardHeight);
			}
		}
		g.drawString("skip", 10, 15+3*cardHeight);
	}
}
}

