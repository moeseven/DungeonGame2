package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import GUI.grafics.StaticImageLoader;
import game.RoomInteractionLibrary.Altar;
import game.RoomInteractionLibrary.MedicineMan;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Tavern;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.Item;
import tools.ClickableRectangle;
import tools.RectangleClicker;


public class GuiRoom extends JPanel{
	private RoomWindow rw;
	private JPanel jp_buttons;
	private JPanel jp_south;
	private JPanel jp_north;
	public GuiRoom(RoomWindow rw) {
		this.rw=rw;
		setLayout(new BorderLayout());		
		jp_buttons=new JPanel();
		jp_buttons.setLayout(new BorderLayout());
		jp_buttons.add(new RoomButtonComponent(rw));
		add(jp_buttons, BorderLayout.PAGE_END);
		jp_south= new JPanel();
		jp_south.setLayout(new BorderLayout());
		jp_south.add(new RoomHeroesComponent(rw));		
		add(jp_south,BorderLayout.CENTER);		
		jp_north=new JPanel();
		jp_north.setLayout(new BorderLayout());
		jp_north.add(new RoomInteractionComponent(rw));
		add(jp_north, BorderLayout.NORTH);	
		setVisible(true);
	}
	public void upadate(){
		this.remove(jp_north);
		this.remove(jp_south);		
		if(rw.getGame().getRoom().isShopOpen()) {
			jp_north=new JPanel();
			jp_north.setLayout(new BorderLayout());
			jp_north.add(new ShopInterface(rw,rw.getGame().getRoom().getShop()));
			add(jp_north, BorderLayout.NORTH);
			jp_south= new JPanel();
			jp_south.setLayout(new BorderLayout());
			jp_south.add(new RoomHeroesComponent(rw),BorderLayout.CENTER);		
			add(jp_south,BorderLayout.CENTER);
		}else {
			if(rw.getGame().getRoom().isTavernOpen()) {
				jp_north=new JPanel();
				jp_north.setLayout(new BorderLayout());
				jp_north.add(new TavernInterface(rw,rw.getGame().getRoom().getTavern()));
				add(jp_north, BorderLayout.NORTH);
				jp_south= new JPanel();
				jp_south.setLayout(new BorderLayout());
				jp_south.add(new RoomHeroesComponent(rw),BorderLayout.CENTER);		
				add(jp_south,BorderLayout.CENTER);
			}else {
				if(rw.getGame().getRoom().isMedicineOpen()) {
					jp_north=new JPanel();
					jp_north.setLayout(new BorderLayout());
					jp_north.add(new MedicineInterface(rw,rw.getGame().getRoom().getMedicine()));
					add(jp_north, BorderLayout.NORTH);
					jp_south= new JPanel();
					jp_south.setLayout(new BorderLayout());
					jp_south.add(new RoomHeroesComponent(rw),BorderLayout.CENTER);		
					add(jp_south,BorderLayout.CENTER);
				}else {
					if(rw.getGame().getRoom().isAltarOpen()) {
						jp_north=new JPanel();
						jp_north.setLayout(new BorderLayout());
						jp_north.add(new AltarInterface(rw,rw.getGame().getRoom().getAltar()));
						add(jp_north, BorderLayout.NORTH);
						jp_south= new JPanel();
						jp_south.setLayout(new BorderLayout());
						jp_south.add(new RoomHeroesComponent(rw),BorderLayout.CENTER);		
						add(jp_south,BorderLayout.CENTER);
					}else {
						jp_north=new JPanel();
						jp_north.setLayout(new BorderLayout());
						jp_north.add(new RoomInteractionComponent(rw));
						add(jp_north, BorderLayout.NORTH);
						jp_south= new JPanel();
						jp_south.setLayout(new BorderLayout());
						jp_south.add(new RoomHeroesComponent(rw),BorderLayout.CENTER);		
						add(jp_south,BorderLayout.CENTER);
					}
				}
			}			
		}		
		rw.setVisible(true);
	}
	private class ShopInterface extends JComponent{
		private RectangleClicker rc;
		private RoomWindow gw;
		private Shop shop;
		private ShopInterface(RoomWindow roomWindow, Shop s) {
		this.gw=roomWindow;
		this.shop=s;
		setBorder(new LineBorder(Color.WHITE));
		super.setPreferredSize(new Dimension(600,200));
		MyMouseListener ml = new MyMouseListener();
		super.addMouseListener(ml);
		setLayout(new BorderLayout());
		setVisible(true);
		//rectangles
		rc=new RectangleClicker();
		//Inventory player
		rc.addRect(new ClickableRectangle("inventory",375,80,90,20) {
			@Override
			public void onClick(MouseEvent e) {	
			}
			@Override
			public void updateCaption() {					
			}		
		});
		rc.addRect(new ClickableRectangle("<-",375,100,45,20) {
			@Override
			public void onClick(MouseEvent e) {
				if(gw.getGame().getPlayer().getInventory().size()>0) {
					gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
					if(gw.getGame().getPlayer().getInventory().size()>1) {
						gw.getGame().getPlayer().getInventory().addLast(gw.getGame().getPlayer().getInventory().removeFirst());
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
					}
				}					
					
			}
			@Override
			public void updateCaption() {					
			}		
		});
		rc.addRect(new ClickableRectangle("->",420,100,45,20) {
			@Override
			public void onClick(MouseEvent e) {
				if(gw.getGame().getPlayer().getInventory().size()>0) {
					gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
					if(gw.getGame().getPlayer().getInventory().size()>1) {
						gw.getGame().getPlayer().getInventory().addFirst(gw.getGame().getPlayer().getInventory().removeLast());
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
					}
				}					
					
			}
			@Override
			public void updateCaption() {					
			}		
		});
		//Inventory shop
		rc.addRect(new ClickableRectangle("shop",465,80,90,20) {
			@Override
			public void onClick(MouseEvent e) {									
			}

			@Override
			public void updateCaption() {
			}		
		});
		rc.addRect(new ClickableRectangle("<-",465,100,45,20) {
			@Override
			public void onClick(MouseEvent e) {
				// TODO Auto-generated method stub
				if(shop.getItems().size()>0) {
					gw.getGame().getPlayer().getSelectedHero().setSelectedItem(shop.getItems().getFirst());
					if(shop.getItems().size()>1) {
						shop.getItems().addLast(shop.getItems().removeFirst());
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(shop.getItems().getFirst());					}
				}					
					
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub					
			}		
		});
		rc.addRect(new ClickableRectangle("->",510,100,45,20) {
			@Override
			public void onClick(MouseEvent e) {
				// TODO Auto-generated method stub
				if(shop.getItems().size()>0) {
					gw.getGame().getPlayer().getSelectedHero().setSelectedItem(shop.getItems().getFirst());
					if(shop.getItems().size()>1) {
						shop.getItems().addFirst(shop.getItems().removeLast());
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(shop.getItems().getFirst());					}
				}					
					
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub					
			}		
		});
		
		//item description
		rc.addRect(new ClickableRectangle("description",305,10,250,110) {
			@Override
			public void onClick(MouseEvent e) {

			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub
				setFirstLineColor(Color.black);
				if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
					gw.getGame().getPlayer().getSelectedHero().getSelectedItem().generateItemDescription();						
					caption=gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getDescription();
					caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getName());
					//color
					if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getNumberOfSuffixes()>0) {
						setFirstLineColor(Color.blue);
						if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getNumberOfSuffixes()>1) {
							setFirstLineColor(Color.orange);
							if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getNumberOfSuffixes()>2) {
								setFirstLineColor(Color.PINK);
							}
						}
					}
					//
				}else {
					caption=new LinkedList<String>();
				}					
			}		
		});
		//sell
		rc.addRect(new ClickableRectangle("sell",510,35,45,20) {
			@Override
			public void onClick(MouseEvent e) {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
					Item item=gw.getGame().getPlayer().getSelectedHero().getSelectedItem();
					if(gw.getGame().getPlayer().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						//sell
						shop.getItems().add(item);
						gw.getGame().getPlayer().getInventory().remove(item);
						gw.getGame().getPlayer().gainGold((int) (item.getGoldValue()/3.5));//maybe Charisma of heroes can improve ratio
						if(gw.getGame().getPlayer().getInventory().size()>0) {
							gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
						}
					}	
				}

			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
					this.setFirstLineColor(Color.black);
				}else {
					if(shop.getItems().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						this.setFirstLineColor(Color.GRAY);
					}			
				}					
			}		
		});
		rc.addRect(new ClickableRectangle("buy",510,10,45,20) {
			@Override
			public void onClick(MouseEvent e) {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
					Item item=gw.getGame().getPlayer().getSelectedHero().getSelectedItem();
					if(!gw.getGame().getPlayer().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						if(shop.getItems().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
							//buy
							if(gw.getGame().getPlayer().getGold()>=gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getGoldValue()) {
								if(gw.getGame().getPlayer().addItemtoInventory(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
									gw.getGame().getPlayer().gainGold(-gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getGoldValue());
									shop.getItems().remove(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
								}								
							}
							if(shop.getItems().size()>0) {
								gw.getGame().getPlayer().getSelectedHero().setSelectedItem(shop.getItems().getFirst());
							}
						}
					}				
				}

			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
					this.setFirstLineColor(Color.GRAY);
				}else {
					if(shop.getItems().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						this.setFirstLineColor(Color.black);
					}			
				}					
			}		
		});
		//gold
		rc.addRect(new ClickableRectangle("gold",305,120,250,20) {
			@Override
			public void onClick(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub	
				if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
					if(shop.getItems().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						caption.removeFirst();
						caption.addFirst("gold: "+gw.getGame().getPlayer().getGold()+" ("+gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getGoldValue()+")");	
					}else {
						caption.removeFirst();
						caption.addFirst("gold: "+gw.getGame().getPlayer().getGold()+" ("+(int)(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getGoldValue()/3.5)+")");	
					}
					
				}								
			}		
		});
		rc.updateCaptions();
	}

	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){	
			if(e.getButton()==1){
				//get equipment position from click
				rc.triggerClick(e);
				rc.updateCaptions();
				upadate();
				revalidate();
				repaint();			
			}else{
				if (e.getButton()==3){
					//new CardView(card);
				}
			}
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);				
		g.drawImage(StaticImageLoader.getImage(shop.getImageNumber()).getScaledInstance(180, 153, 3),-40,0,null);
		if (gw.getGame().getPlayer().getSelectedHero()!=null&&gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
				g.drawImage(StaticImageLoader.getImage(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getImageNumber()).getScaledInstance(180,153, 3),150,10,null);				
		}
		for(int i=0; i<rc.rectAngles.size();i++) {
			g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
			
			for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
				g.setColor(Color.black);
				if(a==0) {
					g.setColor(rc.rectAngles.get(i).getFirstLineColor());
				}
				g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()+3, rc.rectAngles.get(i).getY()+11+a*11);
			}
		}
	}
	}
	private class TavernInterface extends JComponent{
		private RectangleClicker rc;
		private RoomWindow gw;
		private Tavern tavern;
		private TavernInterface(RoomWindow roomWindow, Tavern t) {
		this.gw=roomWindow;
		this.tavern=t;
		setBorder(new LineBorder(Color.WHITE));
		super.setPreferredSize(new Dimension(600,200));
		MyMouseListener ml = new MyMouseListener();
		super.addMouseListener(ml);
		setLayout(new BorderLayout());
		JScrollPane scroll= new JScrollPane(new HeroStatsPaintComponent(gw.getGame().getPlayer()));
		add(scroll,BorderLayout.EAST);
		setVisible(true);
		//rectangles
		rc=new RectangleClicker();
		//Tavern Heroes
		rc.addRect(new ClickableRectangle("look around in tavern",545,30,145,40) {
			@Override
			public void onClick(MouseEvent e) {
				// TODO Auto-generated method stub
				if(tavern.getHeroes().size()>0) {
					gw.getGame().getPlayer().setSelectedHero(tavern.getHeroes().getFirst());
					if(tavern.getHeroes().size()>1) {
						tavern.getHeroes().addLast(tavern.getHeroes().removeFirst());
						gw.getGame().getPlayer().setSelectedHero(tavern.getHeroes().getFirst());				
					}
				}										
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub					
			}		
		});
		//hire/release to tavern
		rc.addRect(new ClickableRectangle("release to tavern",545,90,145,20) {
			@Override
			public void onClick(MouseEvent e) {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getSelectedHero()!=null) {
					Hero hero=gw.getGame().getPlayer().getSelectedHero();
					if(gw.getGame().getPlayer().getHeroes().contains(hero)&&gw.getGame().getPlayer().getHeroes().size()>1) {
						//release to tavern
						tavern.getHeroes().add(hero);
						gw.getGame().getPlayer().removeHero(hero);
						if(gw.getGame().getPlayer().getHeroes().size()>0) {
							gw.getGame().getPlayer().setSelectedHero(gw.getGame().getPlayer().getHeroes().getFirst());
						}
					}else {
						if(tavern.getHeroes().contains(hero)) {
							//hire
							if(gw.getGame().getPlayer().addHero(hero)) {
								tavern.getHeroes().remove(hero);
								gw.getGame().log.addLine(hero.getName()+" joined your Quest!");
							}else {
								gw.getGame().log.addLine("you cant field more than "+gw.getGame().getPlayer().getHeroes().size()+" heroes!");
							}
							if(tavern.getHeroes().size()>0) {
								gw.getGame().getPlayer().setSelectedHero(tavern.getHeroes().getFirst());
							}
						}
					}				
				}
				
				gw.getGuiRoom().upadate();
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getHeroes().contains(gw.getGame().getPlayer().getSelectedHero())) {
					caption.removeFirst();						
					caption.addFirst(name);
				}else {
					if(tavern.getHeroes().contains(gw.getGame().getPlayer().getSelectedHero())) {
						caption.removeFirst();
						caption.addFirst("hire");
					}			
				}					
			}		
		});
		//increase Tavern size
		rc.addRect(new ClickableRectangle("increase Tavern slots",545,130,145,20) {
			int goldcost=(gw.getGame().getPlayer().getHeroes().size()+gw.getGame().getPlayer().getAvailableHeroes().size())*18-15;
			@Override
			public void onClick(MouseEvent e) {
				if (gw.getGame().getPlayer().getGold()>= goldcost){
					gw.getGame().getPlayer().gainGold(-goldcost);
					gw.getGame().getPlayer().getAvailableHeroes().add(gw.getGame().generator.generateRandomHero(gw.getGame().getPlayer()));
				}
				
				gw.getGuiRoom().upadate();
			}
			@Override
			public void updateCaption() {
				caption.removeFirst();						
				caption.addFirst(name+"("+goldcost+" gold)");						
			}		
		});
		//dismiss hero //disabled for now
		rc.addRect(new ClickableRectangle("",545,110,145,20) {
			@Override
			public void onClick(MouseEvent e) {				
//				if(gw.getGame().getPlayer().getSelectedHero()!=null) {
//					Hero hero=gw.getGame().getPlayer().getSelectedHero();
//					if(gw.getGame().getPlayer().getHeroes().contains(hero)&&gw.getGame().getPlayer().getHeroes().size()>1) {
//						//dismiss from roster
//						gw.getGame().getPlayer().removeHero(hero);						
//						if(gw.getGame().getPlayer().getHeroes().size()>0) {
//							gw.getGame().getPlayer().setSelectedHero(gw.getGame().getPlayer().getHeroes().getFirst());
//						}
//					}else {
//						if(tavern.getHeroes().contains(hero)) {
//							//dismiss from tavern
//							tavern.getHeroes().remove(hero);				
//							if(tavern.getHeroes().size()>0) {
//								gw.getGame().getPlayer().setSelectedHero(tavern.getHeroes().getFirst());
//							}
//						}
//					}				
//				}
				
//				gw.getGuiRoom().upadate();
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getHeroes().contains(gw.getGame().getPlayer().getSelectedHero())) {
					caption.removeFirst();						
					caption.addFirst(name);
				}else {
					if(tavern.getHeroes().contains(gw.getGame().getPlayer().getSelectedHero())) {
						caption.removeFirst();
						caption.addFirst(name);
					}			
				}					
			}		
		});
		//hero name
		rc.addRect(new ClickableRectangle("hero",545,70,145,20) {
			@Override
			public void onClick(MouseEvent e) {

			}
			@Override
			public void updateCaption() {
				if(gw.getGame().getPlayer().getSelectedHero()!=null) {
					caption.removeFirst();
					caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getName());
				}
			}		
		});		
		rc.updateCaptions();
	}

private class MyMouseListener extends MouseAdapter{
	public void mousePressed(MouseEvent e){	
		if(e.getButton()==1){
			//get equipment position from click
			rc.triggerClick(e);
			rc.updateCaptions();
			upadate();
			revalidate();
			repaint();			
		}else{
			if (e.getButton()==3){
				//new CardView(card);
			}
		}
	} 
}
protected void paintComponent(Graphics g){
	super.paintComponent(g);
	g.drawImage(StaticImageLoader.getImage(tavern.getImageNumber()).getScaledInstance(180, 153, 3),-40,0,null);
	//g.drawImage(StaticImageLoader.getImage(gw.getGame().getPlayer().getSelectedHero().getImageNumber()).getScaledInstance(180, 153, 3),300,0,null);
	for(int i=0; i<rc.rectAngles.size();i++) {
		g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
		for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
			g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()+3, rc.rectAngles.get(i).getY()+11+a*11);
		}
	}
	for (int i = 0; i < this.gw.getGame().getPlayer().getAvailableHeroes().size(); i++) {
		g.drawImage(StaticImageLoader.getImage(gw.getGame().getPlayer().getAvailableHeroes().get(i).getImageNumber()),80+25*i,53,null);
	}
}
	}
	private class MedicineInterface extends JComponent{
		private RectangleClicker rc;
		private RoomWindow gw;
		private MedicineMan mm;
		
		private MedicineInterface(RoomWindow roomWindow, MedicineMan s) {
		this.gw=roomWindow;
		this.mm=s;
		
		setBorder(new LineBorder(Color.WHITE));
		super.setPreferredSize(new Dimension(600,200));
		MyMouseListener ml = new MyMouseListener();
		super.addMouseListener(ml);
		setLayout(new BorderLayout());
		setVisible(true);
		//rectangles
		rc=new RectangleClicker();
		//health heal
				rc.addRect(new ClickableRectangle("heal hero",405,120,220,30) {
					@Override
					public void onClick(MouseEvent e) {
						mm.purchaseHealing(gw.getGame().getPlayer().getSelectedHero());										
					}
					@Override
					public void updateCaption() {
						caption=new LinkedList<String>();
						caption.add("heal "+gw.getGame().getPlayer().getSelectedHero().getName()+".");
						caption.add("cost: "+mm.computeHealFee(gw.getGame().getPlayer().getSelectedHero())+" gold");
					}		
				});
		//wound heal
		rc.addRect(new ClickableRectangle("woundheal hero",405,40,220,40) {
			@Override
			public void onClick(MouseEvent e) {
				mm.purchaseWoundHealing(gw.getGame().getPlayer().getSelectedHero());										
			}
			@Override
			public void updateCaption() {
				caption=new LinkedList<String>();
				caption.add("treat "+gw.getGame().getPlayer().getSelectedHero().getName()+" for wound healing.");
				caption.add("("+gw.getGame().getPlayer().getSelectedHero().getWounds()+" wounds)");
				caption.add("cost: "+mm.computeWoundHealFee(gw.getGame().getPlayer().getSelectedHero())+" gold");
			}		
		});
		//stress heal
		rc.addRect(new ClickableRectangle("stressheal hero",405,80,220,40) {
			@Override
			public void onClick(MouseEvent e) {
				mm.purchaseStressHealing(gw.getGame().getPlayer().getSelectedHero());										
			}
			@Override
			public void updateCaption() {
				caption=new LinkedList<String>();
				caption.add("treat "+gw.getGame().getPlayer().getSelectedHero().getName()+" for stress healing.");
				caption.add("("+gw.getGame().getPlayer().getSelectedHero().getStress()+" stress)");
				caption.add("cost: "+mm.computeStressHealFee(gw.getGame().getPlayer().getSelectedHero())+" gold");
			}		
		});
		//gold
		rc.addRect(new ClickableRectangle("gold",405,150,220,20) {
			@Override
			public void onClick(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub	
				caption.removeFirst();
				caption.addFirst("gold: "+gw.getGame().getPlayer().getGold());							
			}		
		});
		rc.updateCaptions();
	}

	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){	
			if(e.getButton()==1){
				//get equipment position from click
				rc.triggerClick(e);
				rc.updateCaptions();
				upadate();
				revalidate();
				repaint();			
			}else{
				if (e.getButton()==3){
					//new CardView(card);
				}
			}
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(StaticImageLoader.getImage(mm.getImageNumber()).getScaledInstance(180, 153, 3),-40,0,null);
		for(int i=0; i<rc.rectAngles.size();i++) {
			g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
			for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
				g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()+3, rc.rectAngles.get(i).getY()+11+a*11);
			}
		}
	}
	}
	private class AltarInterface extends JComponent{
		private RectangleClicker rc;
		private RoomWindow gw;
		private Altar altar;
		private AltarInterface(RoomWindow roomWindow, Altar s) {
		this.gw=roomWindow;
		this.altar=s;
		setBorder(new LineBorder(Color.WHITE));
		super.setPreferredSize(new Dimension(600,200));
		MyMouseListener ml = new MyMouseListener();
		super.addMouseListener(ml);
		setLayout(new BorderLayout());
		setVisible(true);
		//rectangles
		rc=new RectangleClicker();
		///from shop
		rc.addRect(new ClickableRectangle("search inventory",455,10,90,40) {
			@Override
			public void onClick(MouseEvent e) {
				if(gw.getGame().getPlayer().getInventory().size()>0) {
					gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
					if(gw.getGame().getPlayer().getInventory().size()>1) {
						gw.getGame().getPlayer().getInventory().addLast(gw.getGame().getPlayer().getInventory().removeFirst());
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
					}
				}					
					
			}
			@Override
			public void updateCaption() {					
			}		
		});
		//item description
		rc.addRect(new ClickableRectangle("description",305,10,145,110) {
			@Override
			public void onClick(MouseEvent e) {

			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub
				setFirstLineColor(Color.black);
				if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
					gw.getGame().getPlayer().getSelectedHero().getSelectedItem().generateItemDescription();						
					caption=gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getDescription();
					caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getName());
					//color
					if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getNumberOfSuffixes()>0) {
						setFirstLineColor(Color.blue);
						if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getNumberOfSuffixes()>1) {
							setFirstLineColor(Color.orange);
							if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getNumberOfSuffixes()>2) {
								setFirstLineColor(Color.PINK);
							}
						}
					}
					//
				}else {
					caption=new LinkedList<String>();
				}					
			}		
		});
		//pray
		rc.addRect(new ClickableRectangle("pray",455,50,90,25) {
			@Override
			public void onClick(MouseEvent e) {
				// TODO Auto-generated method st
				altar.pray(gw.getGame().getPlayer().getSelectedHero());
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub					
			}		
		});
		//sacrifice
		rc.addRect(new ClickableRectangle("sacrifice item",455,75,90,25) {
			@Override
			public void onClick(MouseEvent e) {
				if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
					Hero hero=gw.getGame().getPlayer().getSelectedHero();
					Item item=gw.getGame().getPlayer().getSelectedHero().getSelectedItem();
					if(gw.getGame().getPlayer().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						//sacrifice
						altar.itemForExperience(hero, item);
						rc.rectAngles.remove(this);
						if(gw.getGame().getPlayer().getInventory().size()>0) {
							gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
						}
					}else {
					}				
				}

			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub				
			}		
		});
		//sacrifice blood
		rc.addRect(new ClickableRectangle("sacrifice blood",455,100,90,25) {
			@Override
			public void onClick(MouseEvent e) {
				altar.goldForBlood(gw.getGame().getPlayer().getSelectedHero());
				rc.rectAngles.remove(this);
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub				
			}		
		});
		rc.updateCaptions();
	}

	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){	
			if(e.getButton()==1){
				//get equipment position from click
				rc.triggerClick(e);
				rc.updateCaptions();
				upadate();
				revalidate();
				repaint();				
			}else{
				if (e.getButton()==3){
					//new CardView(card);
				}
			}
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);				
		g.drawImage(StaticImageLoader.getImage(altar.getImageNumber()).getScaledInstance(180, 153, 3),-40,0,null);
		if (gw.getGame().getPlayer().getSelectedHero()!=null&&gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
				g.drawImage(StaticImageLoader.getImage(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getImageNumber()).getScaledInstance(180,153, 3),150,10,null);				
		}
		g.setColor(Color.black);
		for(int i=0; i<rc.rectAngles.size();i++) {
			g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
			
			for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
				g.setColor(Color.black);
				if(a==0) {
					g.setColor(rc.rectAngles.get(i).getFirstLineColor());
				}
				g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()+3, rc.rectAngles.get(i).getY()+11+a*11);
			}
		}
	}
	}
}
