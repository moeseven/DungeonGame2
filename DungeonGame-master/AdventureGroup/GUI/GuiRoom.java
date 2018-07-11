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
import javax.swing.border.LineBorder;

import game.RoomInteractionLibrary.MedicineMan;
import game.RoomInteractionLibrary.Shop;
import game.RoomInteractionLibrary.Tavern;
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
		rc.addRect(new ClickableRectangle("search inventory",455,10,90,40) {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
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
				// TODO Auto-generated method stub					
			}		
		});
		//Inventory shop
		rc.addRect(new ClickableRectangle("search shop",455,80,90,40) {
			@Override
			public void onClick() {
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
		
		//item description
		rc.addRect(new ClickableRectangle("description",305,10,150,110) {
			@Override
			public void onClick() {

			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
					gw.getGame().getPlayer().getSelectedHero().getSelectedItem().generateItemDescription();						
					caption=gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getDescription();
					caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getName());
				}else {
					caption=new LinkedList<String>();
				}					
			}		
		});
		//buy/sell
		rc.addRect(new ClickableRectangle("sell",210,10,55,20) {
			@Override
			public void onClick() {
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
					}else {
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
					caption.removeFirst();						
					caption.addFirst(name);
				}else {
					if(shop.getItems().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						caption.removeFirst();
						caption.addFirst("buy");
					}			
				}					
			}		
		});
		//gold
		rc.addRect(new ClickableRectangle("gold",305,120,150,20) {
			@Override
			public void onClick() {
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
				rc.triggerClick(e.getX(), e.getY());
				rc.updateCaptions();
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
		for(int i=0; i<rc.rectAngles.size();i++) {
			g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
			for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
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
		setVisible(true);
		//rectangles
		rc=new RectangleClicker();
		//Tavern Heroes
		rc.addRect(new ClickableRectangle("look around in tavern",545,30,145,40) {
			@Override
			public void onClick() {
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
			public void onClick() {
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
		//dismiss hero
		rc.addRect(new ClickableRectangle("dismiss hero",545,110,145,20) {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getSelectedHero()!=null) {
					Hero hero=gw.getGame().getPlayer().getSelectedHero();
					if(gw.getGame().getPlayer().getHeroes().contains(hero)&&gw.getGame().getPlayer().getHeroes().size()>1) {
						//dismiss from roster
						gw.getGame().getPlayer().removeHero(hero);
						if(gw.getGame().getPlayer().getHeroes().size()>0) {
							gw.getGame().getPlayer().setSelectedHero(gw.getGame().getPlayer().getHeroes().getFirst());
						}
					}else {
						if(tavern.getHeroes().contains(hero)) {
							//dismiss from tavern
							tavern.getHeroes().remove(hero);				
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
						caption.addFirst(name);
					}			
				}					
			}		
		});
		//hero name
		rc.addRect(new ClickableRectangle("hero",545,70,145,20) {
			@Override
			public void onClick() {

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
			rc.triggerClick(e.getX(), e.getY());
			rc.updateCaptions();
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
	for(int i=0; i<rc.rectAngles.size();i++) {
		g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
		for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
			g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()+3, rc.rectAngles.get(i).getY()+11+a*11);
		}
	}
}
	}
	private class MedicineInterface extends JComponent{
		private RectangleClicker rc;
		private RoomWindow gw;
		private MedicineMan mm;
		private int woundhealfee=110;
		private int stresshealfee=30;
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
		//wound heal
		rc.addRect(new ClickableRectangle("woundheal hero",405,40,220,40) {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getHeroes().contains(gw.getGame().getPlayer().getSelectedHero())) {
					if(gw.getGame().getPlayer().getGold()>=woundhealfee*(gw.getGame().getPlayer().getSelectedHero().getLevel()+2)) {
						if(gw.getGame().getPlayer().getHeroes().size()>1) {
							Hero selectedHero=gw.getGame().getPlayer().getSelectedHero();
							gw.getGame().getPlayer().getHeroes().remove(selectedHero);
							mm.getHeroeswound().add(selectedHero);
							gw.getGame().getPlayer().gainGold(-woundhealfee*(gw.getGame().getPlayer().getSelectedHero().getLevel()+2));
						}else {
							gw.getGame().log.addLine("you have to keep at least one hero in your adventure Group!");
						}						
					}
				}										
			}
			@Override
			public void updateCaption() {
				caption=new LinkedList<String>();
				caption.add("treat "+gw.getGame().getPlayer().getSelectedHero().getName()+" for wound healing.");
				caption.add("("+gw.getGame().getPlayer().getSelectedHero().getWounds()+" wounds)");
				caption.add("cost: "+woundhealfee*(gw.getGame().getPlayer().getSelectedHero().getLevel()+2)+" gold");
			}		
		});
		//stress heal
		rc.addRect(new ClickableRectangle("stressheal hero",405,80,220,40) {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				if(gw.getGame().getPlayer().getHeroes().contains(gw.getGame().getPlayer().getSelectedHero())) {			
					if(gw.getGame().getPlayer().getHeroes().size()>1) {
						if(gw.getGame().getPlayer().getGold()>=stresshealfee*(gw.getGame().getPlayer().getSelectedHero().getLevel()+2)) {
							Hero selectedHero=gw.getGame().getPlayer().getSelectedHero();
							gw.getGame().getPlayer().getHeroes().remove(selectedHero);
							mm.getHeroestress().add(selectedHero);
							gw.getGame().getPlayer().gainGold(-stresshealfee*(gw.getGame().getPlayer().getSelectedHero().getLevel()+2));
						}
					}else {
						gw.getGame().log.addLine("you have to keep at least one hero in your adventure Group!");
					}	
				}										
			}
			@Override
			public void updateCaption() {
				caption=new LinkedList<String>();
				caption.add("treat "+gw.getGame().getPlayer().getSelectedHero().getName()+" for stress healing.");
				caption.add("("+gw.getGame().getPlayer().getSelectedHero().getStress()+" stress)");
				caption.add("cost: "+stresshealfee*(gw.getGame().getPlayer().getSelectedHero().getLevel()+2)+" gold");
			}		
		});
		//gold
		rc.addRect(new ClickableRectangle("gold",405,120,220,20) {
			@Override
			public void onClick() {
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
				rc.triggerClick(e.getX(), e.getY());
				rc.updateCaptions();
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
		for(int i=0; i<rc.rectAngles.size();i++) {
			g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
			for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
				g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()+3, rc.rectAngles.get(i).getY()+11+a*11);
			}
		}
	}
	}
}
