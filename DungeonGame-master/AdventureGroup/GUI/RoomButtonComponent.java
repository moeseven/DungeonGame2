package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import gameEncounter.Card;
import gameEncounter.Hero;

public class RoomButtonComponent extends JComponent{
		private JPanel jp;
		private JScrollPane sp;
		private RoomWindow rw;
		private JButton buttonLeaveRoom;
		private JButton buttonInventory;
		private JButton buttonMove;
		private JButton buttonMenu;
		public RoomButtonComponent(RoomWindow rw){
			this.rw=rw;
			this.setLayout(new FlowLayout());
			buttonLeaveRoom=new JButton("leave");
			buttonLeaveRoom.addMouseListener(new mouselistenerLeave());
			buttonInventory=new JButton("inventory");
			buttonInventory.addMouseListener(new mouseListenerInventory());
			buttonMove=new JButton("move hero to front");
			buttonMove.addMouseListener(new mHTF());
			buttonMenu=new JButton("menu");
			buttonMenu.addMouseListener(new mouseListenerMenu());
			this.add(buttonMenu);
			this.add(buttonMove);
			this.add(buttonInventory);
			this.add(buttonLeaveRoom);
			super.setPreferredSize(new Dimension(300,50));
			setVisible(true);
			
		}
		private class mouseListenerInventory extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				//show inventory
				rw.windowswitch();
			}
		}
		private class mouselistenerLeave extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				//leave room
				if(rw.getGame().getPlayer().getHeroes().size()>0) {
					if(rw.getGame().getRoom().isShopOpen()||rw.getGame().getRoom().isTavernOpen()) {
						rw.getGame().getRoom().setShopOpen(false);
						rw.getGame().getRoom().setTavernOpen(false);
						rw.getGuiRoom().upadate();
					}else {
						rw.getGame().enterNextRoom();
						rw.getGuiRoom().upadate();
						rw.setVisible(true);
						if(rw.getGame().getRoom().isHasFight()){
							rw.setUpFightWindow();
							rw.setVisible(false);
						}
					}
				}else {
					rw.getGame().log.addLine("mission failed!");
					rw.getGame().enterNextRoom();
					rw.getGuiRoom().upadate();
					rw.setVisible(true);
				}								
			}
		}
		private class mHTF extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				//move Hero to front
				Hero hero= rw.getGame().getPlayer().getSelectedHero();
				rw.getGame().getPlayer().getHeroes().remove(rw.getGame().getPlayer().getSelectedHero());
				rw.getGame().getPlayer().getHeroes().addFirst(hero);
				rw.getGuiRoom().upadate();
			}
		}
		private class mouseListenerMenu extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				//open menu 
				rw.openMenu();
			}
		}
}

