package GUI.animations;

import java.io.Serializable;
import java.util.LinkedList;

import GUI.FightAnimationPanel;
import game.DungeonMaster;
import game.Game;
import gameEncounter.Hero;

public class AnimationHandler implements Serializable{
	private Game game;
	private int maxFightParticipants = 20;
	private int missileAnimations =1;
	//hero1X(index0), hero1Y, hero2X ... heroLastY(index19), monster1X(index20), monster2X,..
	public int[] animationArray;// TODO put the animation itself in the array
	private LinkedList<Animation> animationStack;
	private LinkedList<MissileAnimation> missiles;
	public AnimationHandler(Game game){
		this.game=game;
		animationArray= new int[3*maxFightParticipants];
		animationStack= new LinkedList<Animation>();
		missiles= new LinkedList<MissileAnimation>();
	}
	public void addAnimation(Animation animation) {
		animationStack.add(animation);
	}
	public void addMissileAnimation(MissileAnimation animation) {
		missiles.add(animation);
	}
	public void runAnimations() {		
		if (animationStack.size()>0) {
			if (animationArray[animationStack.getFirst().animationIndex]==0) {
				animationStack.removeFirst().runAnimation();
			}else {
				animationStack.add(animationStack.removeFirst());				
			}
		}	
		if (missiles.size()>0) {
			missiles.getFirst().runAnimation();
			missiles.add(missiles.removeFirst());
			deleteFinishedAnimations();
		}
	}
	public void deleteFinishedAnimations() {
		for (int i = 0; i < missiles.size(); i++) {
			if (missiles.get(i).over) {
				missiles.remove(i);
			}
		}
	}
	public int getAnimationIndexX(Hero hero) {//use this for animation 
		if (hero.getPlayer() instanceof DungeonMaster) {
			return hero.getPosition()*3+3*maxFightParticipants/2;
		}else {
			return hero.getPosition()*3;
		}
		
	}
	//getters and setters
	public int[] getAnimationArray() {
		return animationArray;
	}
	public void setAnimationArray(int[] animationArray) {
		this.animationArray = animationArray;
	}
	public LinkedList<Animation> getAnimationStack() {
		return animationStack;
	}
	public void setAnimationStack(LinkedList<Animation> animationStack) {
		this.animationStack = animationStack;
	}
	public int getMissileAnimations() {
		return missileAnimations;
	}
	public void setMissileAnimations(int missileAnimations) {
		this.missileAnimations = missileAnimations;
	}
	public LinkedList<MissileAnimation> getMissiles() {
		return missiles;
	}
	public void setMissiles(LinkedList<MissileAnimation> missiles) {
		this.missiles = missiles;
	}
	
}
