package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import game.Game;

public class RoomWindow extends JFrame{
	private Game game;
	private StatsWindow gw;
	private GuiRoom gr;
	public RoomWindow(Game game, StatsWindow gw) {
		this.game=game;
		this.gw=gw;
		this.setVisible(true);
		this.setSize(1300, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocation(10, 10);
		gr=new GuiRoom(this);
		add(gr,BorderLayout.CENTER);
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void windowswitch() {
		gw.setVisible(true);
		this.setVisible(false);
	}
}
