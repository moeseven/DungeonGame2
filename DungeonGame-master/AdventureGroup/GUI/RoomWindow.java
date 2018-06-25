package GUI;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.Game;

public class RoomWindow extends JFrame{
	private Game game;
	private StatsWindow sw;
	private FightWindow fw;
	private MainMenu mm;
	private GuiRoom guiRoom;
	public RoomWindow(Game game,MainMenu mm) {
		this.mm=mm;
		setTitle("room");
		this.game=game;		
		this.setSize(1300, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocation(10, 10);
		guiRoom=new GuiRoom(this);
		add(guiRoom,BorderLayout.NORTH);
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
		if(fw!=null){
			fw.setVisible(false);
		}		
		sw.myUpdate();
		sw.setVisible(true);
		this.setVisible(false);
	}
	public void openMenu() {
		this.setVisible(false);
		mm.setVisible(true);
	}
	public StatsWindow getSw() {
		return sw;
	}
	public void setSw(StatsWindow sw) {
		this.sw = sw;
	}
	public FightWindow getFw() {
		return fw;
	}
	public void setFw(FightWindow fw) {
		this.fw = fw;
	}
	public GuiRoom getGuiRoom() {
		return guiRoom;
	}
	public void setGr(GuiRoom gr) {
		this.guiRoom = gr;
	}
	
}
