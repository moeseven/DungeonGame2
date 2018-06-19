package GUI;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.Room;

public class GuiRoom extends JPanel{
	private RoomWindow rw;
	private JPanel jp_buttons;
	private JPanel jp_south;
	private JPanel jp_north;
	private JButton buttonLeaveRoom;
	private JButton buttonInventory;
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


}
