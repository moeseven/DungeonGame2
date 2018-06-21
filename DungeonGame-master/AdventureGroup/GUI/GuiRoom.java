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

import game.RoomInteractionLibrary.Shop;
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
		jp_south= new JPanel();
		jp_south.setLayout(new BorderLayout());
		jp_south.add(new RoomHeroesComponent(rw));		
		add(jp_south,BorderLayout.CENTER);
		jp_buttons=new JPanel();
		jp_buttons.setLayout(new BorderLayout());
		jp_buttons.add(new RoomButtonComponent(rw));
		add(jp_buttons, BorderLayout.PAGE_END);
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
		}else {
			jp_north=new JPanel();
			jp_north.setLayout(new BorderLayout());
			jp_north.add(new RoomInteractionComponent(rw));
			add(jp_north, BorderLayout.NORTH);
			jp_south= new JPanel();
			jp_south.setLayout(new BorderLayout());
			jp_south.add(new RoomHeroesComponent(rw));		
		add(jp_south,BorderLayout.CENTER);
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
					gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getInventory().getFirst());
					if(gw.getGame().getPlayer().getSelectedHero().getInventory().size()>1) {
						gw.getGame().getPlayer().getSelectedHero().getInventory().addLast(gw.getGame().getPlayer().getSelectedHero().getInventory().removeFirst());
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getInventory().getFirst());
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
					if(gw.getGame().getPlayer().getSelectedHero().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						//sell
						shop.getItems().add(item);
						gw.getGame().getPlayer().getInventory().remove(item);
						gw.getGame().getPlayer().setGold((int)(gw.getGame().getPlayer().getGold()+item.getGoldValue()/3.5));//maybe Charisma of heroes can improve ratio
					}else {
						if(shop.getItems().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
							//buy
							if(gw.getGame().getPlayer().getGold()>=gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getGoldValue()) {
								gw.getGame().getPlayer().setGold(gw.getGame().getPlayer().getGold()-gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getGoldValue());
								gw.getGame().getPlayer().getInventory().add(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
								shop.getItems().remove(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
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
		//close shop	
		rc.addRect(new ClickableRectangle("done",210,100,55,20) {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				gw.getGame().getRoom().setShopOpen(false);
				gw.getGuiRoom().upadate();
				gw.setVisible(true);
			}
			@Override
			public void updateCaption() {
				// TODO Auto-generated method stub					
			}		
		});
		
		rc.updateCaptions();
	}

private class MyMouseListener extends MouseAdapter{
	public void mouseClicked(MouseEvent e){	
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
