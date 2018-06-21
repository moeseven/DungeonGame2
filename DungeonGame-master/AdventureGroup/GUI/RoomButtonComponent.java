package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
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
		public RoomButtonComponent(RoomWindow rw){
			this.rw=rw;
			this.setLayout(new FlowLayout());
			buttonLeaveRoom=new JButton("leave room");
			buttonLeaveRoom.addMouseListener(new ml());
			buttonInventory=new JButton("inventory");
			buttonInventory.addMouseListener(new mouseListenerInventory());
			buttonMove=new JButton("move hero to front");
			buttonMove.addMouseListener(new mHTF());
			this.add(buttonMove);
			this.add(buttonInventory);
			this.add(buttonLeaveRoom);
			
			setVisible(true);
			
		}
		private class mouseListenerInventory extends MouseAdapter{
			public void mouseClicked(MouseEvent e){
				//show inventory
				rw.windowswitch();
			}
		}
		private class ml extends MouseAdapter{
			public void mouseClicked(MouseEvent e){
				//leave room			
				rw.getGame().enterNextRoom();
				rw.getGuiRoom().upadate();
				rw.setVisible(true);
				if(rw.getGame().getRoom().isHasFight()){
					rw.setUpFightWindow();
					rw.setVisible(false);
				}
			}
		}
		private class mHTF extends MouseAdapter{
			public void mouseClicked(MouseEvent e){
				//move Hero to front
				Hero hero= rw.getGame().getPlayer().getSelectedHero();
				rw.getGame().getPlayer().getHeroes().remove(rw.getGame().getPlayer().getSelectedHero());
				rw.getGame().getPlayer().getHeroes().addFirst(hero);
				rw.getGuiRoom().upadate();
			}
		}
}

