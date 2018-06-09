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
	private JButton b;
	public GuiRoom(RoomWindow rw) {
		this.rw=rw;
		setLayout(new BorderLayout());
		jp_center= new JPanel();
		jp_center.setLayout(new BorderLayout());
		this.add(jp_center,BorderLayout.CENTER);
		//jp_center.add(new HeroInfoComponent(gf,gf.getGame().getPlayer().getSelectedHero()));
		jp_south= new JPanel();
		jp_south.setLayout(new BorderLayout());
		this.add(jp_south,BorderLayout.SOUTH);
		jp_south.add(new RoomHeroesComponent(rw));
		b=new JButton("leave room");
		b.addMouseListener(new ml());
		this.add(b,BorderLayout.SOUTH);
		setVisible(true);
	}
	private class ml extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			//leave room
			rw.revalidate();
			rw.repaint();
		}
	}

}
