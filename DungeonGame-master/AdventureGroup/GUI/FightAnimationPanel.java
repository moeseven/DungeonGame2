package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.LinkedList;


import javax.swing.JPanel;
import javax.swing.Timer;

import GUI.animations.Animation;
import GUI.animations.AnimationHandler;
import GUI.grafics.StaticImageLoader;
import game.DungeonMaster;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import tools.ClickableRectangle;
import tools.RectangleClicker;

public class FightAnimationPanel extends JPanel implements ActionListener{
	private FightWindow fw;
	private AnimationHandler ah;
	private RectangleClicker heroes;
	private RectangleClicker monsters;
	private final int heroWidth=120;
	private final int heroHeight=170;
	private final int heroMonsterSpace=100;
	private final int missileHeight=55;
	private final int heroY=30; //y positon of hero in panel
	private Timer animationTimer;
	private int cycleTime=5;
	public FightAnimationPanel(final FightWindow fw) {
		this.fw=fw;	
		this.ah= fw.getGame().getAnimationHandler();
		super.setPreferredSize(new Dimension(40,220));		
		generateRectanglesForLivingHeroes();
		this.addMouseListener(new MyMouseListener());
		animationTimer = new Timer(cycleTime,this);
		animationTimer.start();
	}
	private void generateRectanglesForLivingHeroes(){
		//heroes as clickable rightangles
		heroes= new RectangleClicker();
		monsters= new RectangleClicker();
		int heroCount = fw.getGame().getPlayer().getHeroes().size();
		for (int h = 0; h < heroCount ; h++) {
			if (!fw.getGame().getPlayer().getHeroes().get(h).isDead()) {
				heroes.addRect(new AnimatedClickableRectangleHero(fw.getGame().getPlayer().getHeroes().get(h),(heroCount-h-1)*heroWidth, heroY, heroWidth, heroHeight));
			}
		}
		for (int m = 0; m < fw.getGame().getRoom().getFight().getMonsters().size(); m++) {
			if (!fw.getGame().dungeonMaster.getHeroes().get(m).isDead()) {
				monsters.addRect(new AnimatedClickableRectangleHero(fw.getGame().dungeonMaster.getHeroes().get(m),heroMonsterSpace+(m+heroCount)*heroWidth, heroY, heroWidth, heroHeight));		
			}
		}
	}
	public void stopAnimations() {
		animationTimer.stop();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ah.runAnimations();
		repaint();
		if (fw.getGame().getRoom().getFight().isFightOver()) {
			animationTimer.stop();
		}else {
			generateRectanglesForLivingHeroes();	
		}
		
	}
	private void paintHeroRect(Graphics g,AnimatedClickableRectangleHero rect){
		Hero hero = rect.getHero();
		int xShift,yShift;
		if (hero.isDead()) {
			xShift=rect.getX();
			yShift=rect.getY();
		}else {
			if (hero.getPlayer() instanceof DungeonMaster) {
				xShift=rect.getX()-ah.animationArray[ah.getAnimationIndexX(hero)];
			}else {
				xShift=rect.getX()+ah.animationArray[ah.getAnimationIndexX(hero)];
			}
			yShift = rect.getY()+ah.animationArray[ah.getAnimationIndexX(hero)+1];
		}				
		g.drawImage(StaticImageLoader.getImage(hero.getImageNumber()).getScaledInstance(60*hero.getImageScale(), 51*hero.getImageScale(), hero.getImageScale()),-40+xShift,yShift,null);
		if(fw.getGame().getPlayer().getSelectedHero()==hero){
			g.setColor(Color.green);
			g.drawRect(1+xShift, 1+yShift, 98, 148);
		}
		if(hero.isDead()){
			g.setColor(Color.BLACK);
			g.fillRect(50+xShift, 30+yShift, 10, 60);
			g.fillRect(35+xShift, 45+yShift, 40, 10);
		}
		for(int i=0; i<hero.getBuffs().size();i++) {
			g.setColor(Color.YELLOW);
			g.fillOval(10+i*6+xShift,95+yShift, 6, 6);
		}
		g.setColor(Color.black);
		g.drawString(hero.getName(), 8+xShift, 15+yShift);
		if(hero.getPoison()>0) {
			g.setColor(Color.GREEN);
			g.drawString(""+hero.getPoison(), 10+xShift, 35+yShift);
		}
		if(hero.getBleed()>0) {
			g.setColor(Color.RED);
			g.drawString(""+hero.getBleed(), 25+xShift, 35+yShift);
		}
		if(hero.getCold()>0) {
			g.setColor(Color.WHITE);
			g.drawString(""+hero.getCold(), 40+xShift, 35+yShift);
		}
		if(hero.getFire()>0) {
			g.setColor(Color.ORANGE);
			g.drawString(""+hero.getFire(), 40+xShift, 35+yShift);
		}
		if(hero.getBlock()>0) {
			g.setColor(Color.blue);
			g.drawString(""+hero.getBlock()+"/"+hero.getArmor(), 14+xShift, 140+yShift);
		}
		g.setColor(Color.red);
		g.drawString(""+hero.getHp()+"/"+GameEquations.maxHealthCalc(hero), 30+xShift, 155+yShift);		

		g.setColor(Color.GRAY);
		g.drawString(""+hero.getStress()+"/"+hero.getStressCap(), 30+xShift, 170+yShift);
		int number=fw.getGuiFight().getFight().getTurnOrder().indexOf(hero)-fw.getGuiFight().getFight().getTurnOrderCounter();
		g.drawString("moves in "+number+" turns", 8+xShift, 25+yShift);
		if (!(hero.getPlayer() instanceof DungeonMaster)) {
			if (fw.getGame().getPlayer().getSelectedHero().getTarget()!=null&&fw.getGame().getRoom().getFight().getTargetMap().containsKey(fw.getGame().getPlayer().getSelectedHero().getTarget())) {
				if (fw.getGame().getRoom().getFight().getTargetMap().get(fw.getGame().getPlayer().getSelectedHero().getTarget()).containsValue(hero)) {
					g.setColor(Color.RED);
					g.drawOval(35+xShift, 35+yShift, 40, 40);
					g.drawOval(40+xShift, 40+yShift, 30, 30);
					g.drawOval(47+xShift, 47+yShift, 15, 15);
				}
			}
		}
		if (hero.isStunned()) {
			g.setColor(Color.WHITE);
			g.drawOval(35+xShift, 35+yShift, 50, 40);
			g.drawOval(40+xShift, 40+yShift, 40, 30);
			g.drawOval(47+xShift, 47+yShift, 20, 15);
		}
	}
	private void paintMissiles(Graphics g, AnimatedClickableRectangleHero rect) {
		for (int i = 2; i < ah.animationArray.length; i+=3) {
			if (ah.animationArray[i]!=0) {
				int missileImage = ah.getMissileImage()[ah.getAnimationIndexX(rect.getHero())];
				g.drawImage(StaticImageLoader.getImage(missileImage).getScaledInstance(60, 51, 1),(int) (-40+ah.animationArray[i]/100.0*computeShootingDistance(rect.getHero(), rect.getHero().getTarget())),missileHeight,null);
			}
		}
	}
	private int computeShootingDistance(Hero shooter, Hero shot) {
		int shootingDistance; int heroCount=shooter.getPlayer().getGame().getPlayer().getHeroes().size();
		if (shooter.getPlayer() instanceof DungeonMaster) {
			shootingDistance=(heroCount-shot.getPosition()-1)*heroWidth-(heroMonsterSpace+(shooter.getPosition()+heroCount)*heroWidth);
		}else {
			shootingDistance=heroMonsterSpace+(shot.getPosition()+heroCount)*heroWidth-(heroCount-shooter.getPosition()-1)*heroWidth;
		}
		return shootingDistance;
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//paint all fight participants
		int heroCount = heroes.getRectAngles().size();
		AnimatedClickableRectangleHero rect;
		for (int h = 0; h < heroCount; h++) {
			rect=(AnimatedClickableRectangleHero) heroes.getRectAngles().get(h);
			paintHeroRect(g,rect);			
		}
		for (int m = 0; m < monsters.getRectAngles().size(); m++) {
			rect=(AnimatedClickableRectangleHero) monsters.getRectAngles().get(m);
			paintHeroRect(g, rect);		
		}
		//paint missile animations
		for (int h = 0; h < heroCount; h++) {
			rect=(AnimatedClickableRectangleHero) heroes.getRectAngles().get(h);
			paintMissiles(g,rect);			
		}
		for (int m = 0; m < monsters.getRectAngles().size(); m++) {
			rect=(AnimatedClickableRectangleHero) monsters.getRectAngles().get(m);
			paintMissiles(g,rect);	
		}
		
	}
	private class MyMouseListener extends MouseAdapter{
		public void mousePressed(MouseEvent e){	
			if(e.getButton()==1||e.getButton()==3){
				heroes.triggerClick(e);
				monsters.triggerClick(e);
				revalidate();
				repaint();	
			}
		} 
	}
	private class AnimatedClickableRectangleHero extends ClickableRectangle{
		private Hero hero;
		private LinkedList<Animation> animations;
		public AnimatedClickableRectangleHero(Hero hero, int x, int y, int length, int height) {
			super(hero.getName(), x, y, length, height);
			this.hero=hero;
			animations=new LinkedList<Animation>();
		}

		@Override
		public void onClick(MouseEvent e) {
			if(e.getButton()==3){
				fw.getGame().getPlayer().getSelectedHero().setNewTarget(hero);
				if (fw.getGame().getPlayer().getSelectedHero().getSelectedCard().playable(fw.getGame().getPlayer().getSelectedHero())) {
					fw.getGame().getPlayer().getSelectedHero().getSelectedCard().cast(fw.getGame().getPlayer().getSelectedHero());
				}
			}else if (e.getButton()==1) {
				fw.getGame().getPlayer().getSelectedHero().setNewTarget(hero);
			}
			fw.revalidate();
			fw.repaint();
			fw.getGuiFight().upadate();
			
		}

		@Override
		public void updateCaption() {
			// TODO Auto-generated method stub
			
		}

		public Hero getHero() {
			return hero;
		}

		public void setHero(Hero hero) {
			this.hero = hero;
		}
		public LinkedList<Animation> getAnimations() {
			return animations;
		}
		public void addAnimation(Animation animation) {
			animations.add(animation);
		}
		public void runAnimation() {
			//TODO
		}
	}


 
}
