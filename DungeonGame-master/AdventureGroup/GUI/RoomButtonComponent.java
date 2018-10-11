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

import game.RoomLibrary.Town;
import gameEncounter.Card;
import gameEncounter.Hero;

public class RoomButtonComponent extends JComponent{
		private JPanel jp;
		private JScrollPane sp;
		private RoomWindow rw;
		private JButton buttonLeaveRoom;
		private JButton buttonInventory;
		private JButton buttonMoveForward;
		private JButton buttonMoveBack;
		private JButton buttonRetreat;
		private JButton buttonTownPortal;
		private JButton buttonMenu;
		public RoomButtonComponent(RoomWindow rw){
			this.rw=rw;
			this.setLayout(new FlowLayout());
			buttonLeaveRoom=new JButton("leave");
			buttonLeaveRoom.addMouseListener(new mouselistenerLeave());
			buttonInventory=new JButton("inventory");
			buttonInventory.addMouseListener(new mouseListenerInventory());
			buttonMoveForward=new JButton("move hero forward");
			buttonMoveForward.addMouseListener(new mouselistenerMoveForward());
			buttonMoveBack=new JButton("move hero back");
			buttonMoveBack.addMouseListener(new mouselistenerMoveBack());
			//retreat option maybe not needed here
//			buttonRetreat=new JButton("retreat");
//			buttonRetreat.addMouseListener(new mouseListenerRetreat());
//			this.add(buttonRetreat);
			buttonTownPortal=new JButton("town portal");
			buttonTownPortal.addMouseListener(new mouseListenerTp());
			buttonMenu=new JButton("menu");
			buttonMenu.addMouseListener(new mouseListenerMenu());
			this.add(buttonMenu);
				
			this.add(buttonTownPortal);
			this.add(buttonMoveBack);
			this.add(buttonMoveForward);
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
		private class mouseListenerRetreat extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				//back to previous room
				rw.getGame().retreatHeroes();
				rw.getGuiRoom().upadate();
			}
		}
		private class mouseListenerTp extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				//back to town
				rw.getGame().tpHeroes();
				rw.getGuiRoom().upadate();
			}
		}
		private class mouselistenerLeave extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				//leave room
				if(rw.getGame().getRoom().isShopOpen()||rw.getGame().getRoom().isTavernOpen()||rw.getGame().getRoom().isMedicineOpen()||rw.getGame().getRoom().isAltarOpen()) {
					rw.getGame().getRoom().setShopOpen(false);
					rw.getGame().getRoom().setTavernOpen(false);
					rw.getGame().getRoom().setMedicineOpen(false);
					rw.getGame().getRoom().setAltarOpen(false);
					rw.getGame().getPlayer().setSelectedHero(rw.getGame().getPlayer().getHeroes().getFirst());
					rw.getGuiRoom().upadate();
				}else {
					if(rw.getGame().getPlayer().getHeroes().size()>0) {
						new MapWindow(rw.getGame(), rw);
//						rw.getGame().enterNextRoom();
//						rw.getGuiRoom().upadate();
//						rw.setVisible(true);
//						if(rw.getGame().getRoom().isHasFight()){
//							rw.setUpFightWindow();
//							rw.setVisible(false);
//						}
					}else {
						rw.getGame().log.addLine("mission failed!");
						rw.getGame().tpHeroes();
						rw.getGuiRoom().upadate();
						rw.setVisible(true);
					}								
				}
			}
		}
		private class mouselistenerMoveForward extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				//move Hero forward
				rw.getGame().getPlayer().getSelectedHero().moveForward();
				rw.getGuiRoom().upadate();
			}
		}
		private class mouselistenerMoveBack extends MouseAdapter{
			public void mousePressed(MouseEvent e){
				//move Hero forward
				rw.getGame().getPlayer().getSelectedHero().moveBack();
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

