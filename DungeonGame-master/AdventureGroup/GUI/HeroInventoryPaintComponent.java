package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import GUI.grafics.StaticImageLoader;
import gameEncounter.Card;
import gameEncounter.Hero;
import gameEncounter.Item;
import gameEncounter.ItemLibrary.usables.ItemConsumable;
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
			super.setPreferredSize(new Dimension(800,200));
			MyMouseListener ml = new MyMouseListener();
			super.addMouseListener(ml);
			setLayout(new BorderLayout());
			setVisible(true);
			if(gw.getGame().getPlayer().getInventory().size()>0) {
				gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
			}
			//rectangles
			rc=new RectangleClicker();
			//Inventory
			rc.addRect(new ClickableRectangle("search inventory",305,120,110,20) {
				@Override
				public void onClick(MouseEvent e) {
				}
				@Override
				public void updateCaption() {
					caption=new LinkedList<>();
					if (gw.getGame().getPlayer().getInventory().size()<1) {
						caption.add("empty inventory");
					}else {
						caption.add(this.name);
					}
				}		
			});
			rc.addRect(new ClickableRectangle("<-",415,120,50,20) {
				@Override
				public void onClick(MouseEvent e) {
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
				}		
			});
			rc.addRect(new ClickableRectangle("->",465,120,50,20) {
				@Override
				public void onClick(MouseEvent e) {
					// TODO Auto-generated method stub
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
			//item description
			rc.addRect(new ClickableRectangle("description",305,10,300,110) {
				@Override
				public void onClick(MouseEvent e) {

				}
				@Override
				public void updateCaption() {
					setFirstLineColor(Color.black);
					if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
						gw.getGame().getPlayer().getSelectedHero().getSelectedItem().generateItemDescription();						
						caption=gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getDescription();
						caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getName());
						if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getNumberOfSuffixes()>0) {
							setFirstLineColor(Color.blue);
							if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getNumberOfSuffixes()>1) {
								setFirstLineColor(Color.orange);
								if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getNumberOfSuffixes()>2) {
									setFirstLineColor(Color.PINK);
								}
							}
						}
					}else {
						caption=new LinkedList<String>();
					}					
				}		
			});
			//item picture
			rc.addRect(new ClickableRectangle("",515,50,80,70) {
				@Override
				public void onClick(MouseEvent e) {

				}
				@Override
				public void updateCaption() {
					
					if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
						this.setImageNumber(gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getImageNumber());
						
					}					
				}		
			});
			//drop item on floor
			rc.addRect(new ClickableRectangle("drop",210,35,55,20) {

				@Override
				public void onClick(MouseEvent e) {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
						if(gw.getGame().getPlayer().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
							//drop item
							gw.getGame().getPlayer().dropItemOnFloor(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
						}else {
							//unequip then drop
							gw.getGame().getPlayer().getSelectedHero().getEquipment().unequipItem(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
							gw.getGame().getPlayer().dropItemOnFloor(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
						}	
						if(gw.getGame().getPlayer().getInventory().size()>0) {
							gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
						}
					}
				}

				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub
					
				}
				
			});
			//use
			rc.addRect(new ClickableRectangle("use",210,60,55,20) {
				@Override
				public void onClick(MouseEvent e) {					
					if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
						Item itemUsable=gw.getGame().getPlayer().getSelectedHero().getSelectedItem();
						if(gw.getGame().getPlayer().getInventory().contains(itemUsable)) {
							if (itemUsable instanceof ItemConsumable) {
								itemUsable.mod(gw.getGame().getPlayer().getSelectedHero());
								gw.getGame().getPlayer().getInventory().remove(itemUsable);								
							}
						}			
					}
				}
				@Override
				public void updateCaption() {
										
				}		
			});
			//equip/unequip
			rc.addRect(new ClickableRectangle("equip",210,10,55,20) {
				@Override
				public void onClick(MouseEvent e) {
					// TODO Auto-generated method stub
					if(gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
						if(gw.getGame().getPlayer().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
							//equip
							gw.getGame().getPlayer().getSelectedHero().getEquipment().equipItem(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
						}else {
							//unequip
							gw.getGame().getPlayer().getSelectedHero().getEquipment().unequipItem(gw.getGame().getPlayer().getSelectedHero().getSelectedItem());
						}				
					}
					if(gw.getGame().getPlayer().getInventory().size()>0) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getInventory().getFirst());
					}
					
				}
				@Override
				public void updateCaption() {					
					if(gw.getGame().getPlayer().getInventory().contains(gw.getGame().getPlayer().getSelectedHero().getSelectedItem())) {
						caption.removeFirst();						
						caption.addFirst(name);
					}else {
						caption.removeFirst();
						caption.addFirst("unequip");
					}
				}		
			});
			//gold
			rc.addRect(new ClickableRectangle("gold",515,120,90,20) {
				@Override
				public void onClick(MouseEvent e) {
					// TODO Auto-generated method stub
				}
				@Override
				public void updateCaption() {
					caption.removeFirst();
					if (gw.getGame().getPlayer().getSelectedHero().getSelectedItem()!=null) {
						caption.addFirst("gold: "+gw.getGame().getPlayer().getGold()+" ("+gw.getGame().getPlayer().getSelectedHero().getSelectedItem().getGoldValue()+")");					
					}else {
						caption.addFirst("gold: "+gw.getGame().getPlayer().getGold());					
					}
					
				}		
			});
			//potion
			rc.addRect(new ClickableRectangle("potion",60,142,50,34) {
				@Override
				public void onClick(MouseEvent e) {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getPotion()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getPotion());
					}
				}
				@Override
				public void updateCaption() {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getPotion()!=null) {
						caption.removeFirst();
						caption.addFirst("");
						this.setImageNumber(gw.getGame().getPlayer().getSelectedHero().getEquipment().getPotion().getImageNumber());
					}else {
						cleanImageNumber();
						caption.removeFirst();
						caption.addFirst(name);
					}					
				}		
			});
			//head
			rc.addRect(new ClickableRectangle("head",60,10,50,50) {
				@Override
				public void onClick(MouseEvent e) {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHead()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHead());
					}
				}
				@Override
				public void updateCaption() {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHead()!=null) {
						caption.removeFirst();
						caption.addFirst("");
						//caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHead().getName());
						this.setImageNumber(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHead().getImageNumber());
					}else {
						this.setImageNumber(1);
						caption.removeFirst();
						caption.addFirst(name);
					}					
				}		
			});
			//body
			rc.addRect(new ClickableRectangle("body",60,70,50,70) {
				@Override
				public void onClick(MouseEvent e) {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getBody()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getBody());
					}
				}
				@Override
				public void updateCaption() {
					// TODO Auto-generated method stub					
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getBody()!=null) {
						caption.removeFirst();	
						caption.addFirst("");
						//caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getEquipment().getBody().getName());
						this.setImageNumber(gw.getGame().getPlayer().getSelectedHero().getEquipment().getBody().getImageNumber());
					}else {
						this.setImageNumber(1);
						caption.removeFirst();
						caption.addFirst(name);
					}
				}		
			});
			//hand1
			rc.addRect(new ClickableRectangle("hand1",5,70,50,70) {
				@Override
				public void onClick(MouseEvent e) {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand1()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand1());
					}
				}
				@Override
				public void updateCaption() {				
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand1()!=null) {
						caption.removeFirst();	
						caption.addFirst("");
						//caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand1().getName());
						this.setImageNumber(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand1().getImageNumber());
					}else {
						this.setImageNumber(1);
						caption.removeFirst();
						caption.addFirst(name);
					}
				}		
			});
			//hand2
			rc.addRect(new ClickableRectangle("hand2",115,70,50,70) {
				@Override
				public void onClick(MouseEvent e) {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand2()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand2());
					}
				}
				@Override
				public void updateCaption() {					
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand2()!=null) {
						caption.removeFirst();	
						caption.addFirst("");
						//caption.addFirst(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand2().getName());
						this.setImageNumber(gw.getGame().getPlayer().getSelectedHero().getEquipment().getHand2().getImageNumber());
					}else {
						this.setImageNumber(1);
						caption.removeFirst();
						caption.addFirst(name);
					}
				}		
			});
			//ring1
			rc.addRect(new ClickableRectangle("ring1",15,142,30,30) {
				@Override
				public void onClick(MouseEvent e) {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getRing1()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getRing1());
					}
				}
				@Override
				public void updateCaption() {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getRing1()!=null) {
						caption.removeFirst();
						caption.addFirst("");					
						this.setImageNumber(gw.getGame().getPlayer().getSelectedHero().getEquipment().getRing1().getImageNumber());
					}else {
						this.setImageNumber(1);
						caption.removeFirst();
						caption.addFirst(name);
					}					
				}		
			});
			//ring2
			rc.addRect(new ClickableRectangle("ring2",125,142,30,30) {
				@Override
				public void onClick(MouseEvent e) {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getRing2()!=null) {
						gw.getGame().getPlayer().getSelectedHero().setSelectedItem(gw.getGame().getPlayer().getSelectedHero().getEquipment().getRing2());
					}
				}
				@Override
				public void updateCaption() {
					if(gw.getGame().getPlayer().getSelectedHero().getEquipment().getRing2()!=null) {
						caption.removeFirst();
						caption.addFirst("");					
						this.setImageNumber(gw.getGame().getPlayer().getSelectedHero().getEquipment().getRing2().getImageNumber());
					}else {
						this.setImageNumber(1);
						caption.removeFirst();
						caption.addFirst(name);
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
			}else{
				if (e.getButton()==3){
					//new CardView(card);
				}
			}
			rc.updateCaptions();
			gw.repaint();
		} 
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		for(int i=0; i<rc.rectAngles.size();i++) {
			g.drawRect(rc.rectAngles.get(i).getX(), rc.rectAngles.get(i).getY(), rc.rectAngles.get(i).getLength(), rc.rectAngles.get(i).getHeight());
			for(int a=0; a<rc.rectAngles.get(i).getCaption().size();a++) {
				if (rc.rectAngles.get(i).getImageNumber()!=1) {
					g.drawImage(StaticImageLoader.getImage(rc.rectAngles.get(i).getImageNumber()).getScaledInstance(120,102, 2),rc.rectAngles.get(i).getX()-35,rc.rectAngles.get(i).getY()-20,null);
				}
				if(a==0) {
					g.setColor(rc.rectAngles.get(i).getFirstLineColor());
				}
				
				g.drawString(rc.rectAngles.get(i).getCaption().get(a), rc.rectAngles.get(i).getX()+3, rc.rectAngles.get(i).getY()+11+a*11);
				g.setColor(Color.black);
			}
		}
		//omit lines with no entry
		int omitted=0;
		if(gw.getGame().getPlayer().getSelectedHero().getSelectedCard()!=null) {
			for (int l=0; l<gw.getGame().getPlayer().getSelectedHero().getSelectedCard().getCardText(gw.getGame().getPlayer().getSelectedHero()).size();l++) {
				g.drawString(gw.getGame().getPlayer().getSelectedHero().getSelectedCard().getCardText(gw.getGame().getPlayer().getSelectedHero()).get(l), 610, 20+16*(l-omitted));
				if ("".equals(gw.getGame().getPlayer().getSelectedHero().getSelectedCard().getCardText(gw.getGame().getPlayer().getSelectedHero()).get(l))) {
					omitted++;
				}
			}			
		}
	}
}

