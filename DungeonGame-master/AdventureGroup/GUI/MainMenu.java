package GUI;


import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import game.CharacterBuilder;
import game.Game;



public class MainMenu extends JFrame{
	private JPanel jp01;
	private JButton buttonStart;
	private JButton buttonCharacterBuilder;
	private JButton buttonSaveGame;
	private JButton buttonLoadGame;
	private Game game;
	protected StatsWindow gw;
	protected RoomWindow rw;
	protected MainMenu mm;
	public MainMenu(){
		this.setTitle("Menu");
		setSize(650,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		mm=this;
		jp01= new JPanel();
		buttonSaveGame= new JButton("Save");
		buttonSaveGame.addMouseListener(new ButtonSaveUserListener());
		buttonLoadGame= new JButton("Load");
		buttonLoadGame.addMouseListener(new ButtonLoadUserListener());
		buttonStart=new JButton("Play");
		buttonStart.addMouseListener(new ButtonStartListener());
		buttonCharacterBuilder= new JButton("Charakter Builder");
		buttonCharacterBuilder.addMouseListener(new ButtonBuildCharacterListener());
		jp01.add(buttonStart);
		//jp01.add(buttonCharacterBuilder); integrated in start of game
		jp01.add(buttonSaveGame);
		jp01.add(buttonLoadGame);
		add(jp01);
		setVisible(true);
	}
	private class ButtonStartListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if(game.getPlayer().getHeroes().size()>0) {
				game.getPlayer().setSelectedHero(game.getPlayer().getHeroes().getFirst());
				game.enterRoom(game.getRoom());			
				rw=new RoomWindow(game,mm);
				
			}else {
				new FrameCharacterBuilder(new CharacterBuilder(game),mm);
			}
			mm.setVisible(false);
		} 
	}
	private class ButtonBuildCharacterListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			new FrameCharacterBuilder(new CharacterBuilder(game),mm);
		} 
	}
	private class ButtonSaveUserListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			//save game;
			ObjectOutputStream oos=null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream("./resources/game.dat"));
				oos.writeObject(game);
			} catch (FileNotFoundException e1) {			
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			finally{
				try {
					oos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} 
	}
	private class ButtonLoadUserListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			//load from file;
			ObjectInputStream ois=null;
			try {
				ois=new ObjectInputStream(new FileInputStream("./resources/game.dat"));
				game=(Game)ois.readObject();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally{
				try {
					ois.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		} 
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}
