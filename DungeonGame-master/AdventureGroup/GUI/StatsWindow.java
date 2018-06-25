package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import game.Game;

public class StatsWindow extends JFrame{
	private Game game;
	private GuiInventory guiInv;
	private RoomWindow rw;
	public StatsWindow(Game game, RoomWindow rw) {
		setTitle("inventory");
		this.rw=rw;
		this.game=game;
		this.setVisible(false);
		this.setSize(1300, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		guiInv=new GuiInventory(this);
		this.add(guiInv);
		setLocation(10, 10);	
	}
	public void myUpdate() {
		this.remove(guiInv);
		guiInv=new GuiInventory(this);
		this.add(guiInv);
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public void windowswitch() {
		rw.setVisible(true);
		this.setVisible(false);
	}
	public RoomWindow getRw() {
		return rw;
	}
	public void setRw(RoomWindow rw) {
		this.rw = rw;
	}
	
}
