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
		public RoomButtonComponent(RoomWindow rw){
			this.rw=rw;
			this.setLayout(new FlowLayout());
			buttonLeaveRoom=new JButton("leave room");
			buttonLeaveRoom.addMouseListener(new ml());
			buttonInventory=new JButton("inventory");
			buttonInventory.addMouseListener(new mouseListenerInventory());
			this.add(buttonInventory);
			this.add(buttonLeaveRoom);
			setVisible(true);
			
		}
		private class mouseListenerInventory extends MouseAdapter{
			public void mouseClicked(MouseEvent e){
				//leave room
				rw.windowswitch();
			}
		}
		private class ml extends MouseAdapter{
			public void mouseClicked(MouseEvent e){
				//leave room			
				rw.getGame().enterNextRoom();
				rw=new RoomWindow(rw.getGame());				
				if(rw.getGame().getRoom().isHasFight()){
					rw.setUpFightWindow();
					rw.setVisible(false);
				}
			}
		}
}

