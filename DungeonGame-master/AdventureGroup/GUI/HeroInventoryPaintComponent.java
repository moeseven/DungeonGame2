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
import tools.ClickableRectangle;
import tools.RectangleClicker;

public class HeroInventoryPaintComponent extends JComponent{
		private JPanel jp;
		private JScrollPane sp;
		private StatsWindow gw;
		private RectangleClicker rc;
		public HeroInventoryPaintComponent(StatsWindow sw){
			this.gw=sw;
			setBorder(new LineBorder(Color.YELLOW));
			super.setPreferredSize(new Dimension(600,200));
			MyMouseListener ml = new MyMouseListener();
			super.addMouseListener(ml);
			setLayout(new BorderLayout());
			setVisible(true);
			//rectangles
			rc=new RectangleClicker();
			//Inventory
			rc.addRect(new ClickableRectangle("search inventory",435,10,90,40) {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getInventory().size()>0) {
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
			//item description
			rc.addRect(new ClickableRectangle("description",305,10,130,110) {
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
			//equip/unequip
			rc.addRect(new ClickableRectangle("equip",210,10,55,20) {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
						if(gw.getGame().getPlayer().getSelectedHero().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
							gw.getGame().getPlayer().getSelectedHero().getEquipment().equipItem(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
						}else {
							gw.getGame().getPlayer().getSelectedHero().getEquipment().unequipItem(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
						}				
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						caption.removeFirst();						
						caption.addFirst(name);
					}else {
						caption.removeFirst();
						caption.addFirst("unequip");
					}					
				}		
			});
			//head
			rc.addRect(new ClickableRectangle("head",60,10,40,40) {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHead()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHead());
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHead()!=null) {
						caption.removeFirst();						
						caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHead().getName());
					}else {
						caption.removeFirst();
						caption.addFirst(name);
					}					
				}		
			});
			//body
			rc.addRect(new ClickableRectangle("body",60,60,40,40) {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getBody()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getBody());
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub					
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getBody()!=null) {
						caption.removeFirst();						
						caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getEquipment().getBody().getName());
					}else {
						caption.removeFirst();
						caption.addFirst(name);
					}
				}		
			});
			//hand1
			rc.addRect(new ClickableRectangle("hand1",10,20,40,40) {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand1()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand1());
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub					
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand1()!=null) {
						caption.removeFirst();						
						caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand1().getName());
					}else {
						caption.removeFirst();
						caption.addFirst(name);
					}
				}		
			});
			//hand2
			rc.addRect(new ClickableRectangle("hand2",110,20,40,40) {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand2()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand2());
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub					
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand2()!=null) {
						caption.removeFirst();						
						caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand2().getName());
					}else {
						caption.removeFirst();
						caption.addFirst(name);
					}
				}		
			});
			rc.updateCaptions();
		}

	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){	
			if(e.getButton()==1){
				//get equipment position from click
				rc.triggerClick(e.getX(), e.getY());
//				if(gw.getGame().getPlayer().getSelectedHero().getInventory().size()>0){
//					gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getInventory().getFirst());
//				}else {
//					gw.getGame().getPlayer().getSelectedHero().setSelectedItem(null);
//				}
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

