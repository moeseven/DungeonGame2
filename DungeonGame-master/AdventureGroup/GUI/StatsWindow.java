package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import game.Game;

public class StatsWindow extends JFrame{
	private Game game;
	private GuiInventory guiRoom;
	private FightWindow fw;
	public StatsWindow(Game game) {
		fw=new FightWindow(game,this);
		this.game=game;
		this.setVisible(true);
		this.setSize(1300, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		guiRoom=new GuiInventory(this);
		this.add(guiRoom);
		setLocation(10, 10);	
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void windowswitch() {
		fw.setVisible(true);
		this.setVisible(false);
	}
}
