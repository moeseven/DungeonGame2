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
		private Hero hero;
		private JPanel jp;
		private JScrollPane sp;
		private StatsWindow gw;
		private RectangleClicker rc;
		public HeroInventoryPaintComponent(StatsWindow gw,Hero h){
			this.gw=gw;
			this.hero=h;
			setBorder(new LineBorder(Color.YELLOW));
			super.setPreferredSize(new Dimension(600,200));
			MyMouseListener ml = new MyMouseListener();
			super.addMouseListener(ml);
			setLayout(new BorderLayout());
			setVisible(true);
			//rectangles
			rc=new RectangleClicker();
			//Inventory
			rc.addRect(new ClickableRectangle("inventory",330,10,60,60) {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					if(hero.getInventory().size()>1) {
						hero.getInventory().addLast(hero.getInventory().removeFirst());
					}	
					System.out.println("clicked inventory");
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub
					if(hero.getSelectedItem()!=null) {
						caption.removeFirst();						
						caption.addFirst(hero.getSelectedItem().getName());
					}else {
						caption.removeFirst();
						caption.addFirst(name);
					}					
				}		
			});
			//item description
			rc.addRect(new ClickableRectangle("description",305,70,110,60) {
				@Override
				public void onClick() {

				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub
					if(hero.getSelectedItem()!=null) {
						hero.getSelectedItem().generateItemDescription();
						caption=hero.getSelectedItem().getDescription();
					}else {
						caption=new LinkedList<String>();
					}					
				}		
			});
			//head
			rc.addRect(new ClickableRectangle("head",60,10,40,40) {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					if(hero.getSelectedItem()!=null) {
						hero.getEquipment().equipHead(hero.getSelectedItem());
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub
					if(hero.getEquipment().getHead()!=null) {
						caption.removeFirst();						
						caption.addFirst(hero.getEquipment().getHead().getName());
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
					if(hero.getSelectedItem()!=null) {
						hero.getEquipment().equipBody(hero.getSelectedItem());
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub					
					if(hero.getEquipment().getBody()!=null) {
						caption.removeFirst();						
						caption.addFirst(hero.getEquipment().getBody().getName());
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
					if(hero.getSelectedItem()!=null) {
						hero.getEquipment().equipHand1(hero.getSelectedItem());
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub					
					if(hero.getEquipment().getHand1()!=null) {
						caption.removeFirst();						
						caption.addFirst(hero.getEquipment().getHand1().getName());
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
					if(hero.getSelectedItem()!=null) {
						hero.getEquipment().equipHand2(hero.getSelectedItem());
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub					
					if(hero.getEquipment().getHand2()!=null) {
						caption.removeFirst();						
						caption.addFirst(hero.getEquipment().getHand2().getName());
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
				if(hero.getInventory().size()>0){
					hero.setSelectedItem(hero.getInventory().getFirst());
				}else {
					hero.setSelectedItem(null);
				}
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

