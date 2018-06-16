package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.Room;

public class GuiRoom extends JPanel{
	private RoomWindow rw;
	private JPanel jp_center;
	private JPanel jp_south;
	private JButton buttonLeaveRoom;
	private JButton buttonInventory;
	public GuiRoom(RoomWindow rw) {
		this.rw=rw;
		setLayout(new BorderLayout());
		jp_south= new JPanel();
		jp_south.setLayout(new BorderLayout());
		jp_south.add(new RoomHeroesComponent(rw));		
		add(jp_south,BorderLayout.SOUTH);
		jp_center=new JPanel();
		jp_center.setLayout(new BorderLayout());
		jp_center.add(new RoomButtonComponent(rw));
		add(jp_center, BorderLayout.CENTER);
		setVisible(true);
	}


}
