package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;

public class RoomWindow extends JFrame{
	private Game game;
	private StatsWindow sw;
	private FightWindow fw;
	private GuiRoom gr;
	public RoomWindow(Game game) {
		setTitle("room");
		this.game=game;		
		this.setSize(1300, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocation(10, 10);
		gr=new GuiRoom(this);
		add(gr,BorderLayout.NORTH);
		this.setVisible(true);
		this.sw=new StatsWindow(game,this);
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void setUpFightWindow() {
		fw=new FightWindow(game,this);
	}
	public void windowswitch() {
		sw.setVisible(true);
		this.setVisible(false);
	}
	
}
