package GUI.animations;

import java.io.Serializable;
import java.util.LinkedList;

import GUI.FightAnimationPanel;
import game.DungeonMaster;
import game.Game;
import gameEncounter.Hero;

public class AnimationHandler implements Serializable{
	private Game game;
	private int monsterShift = 20;
	//hero1X(index0), hero1Y, hero2X ... heroLastY(index19), monster1X(index20), monster2X,..
	public int[] animationArray;
	private LinkedList<Animation> animationStack;
	public AnimationHandler(Game game){
		this.game=game;
		animationArray= new int[2*monsterShift];
		animationStack= new LinkedList<Animation>();
	}
	public void addAnimation(Animation animation) {
		animationStack.add(animation);
	}
	public void runAnimations() {		
		if (animationStack.size()>0) {
			if (animationArray[animationStack.getFirst().animationIndex]==0) {
				animationStack.removeFirst().runAnimation();
			}else {
				animationStack.add(animationStack.removeFirst());				
			}
		}		
	}
	public int getAnimationIndexX(Hero hero) {//use this for animation 
		if (hero.getPlayer() instanceof DungeonMaster) {
			return hero.getPosition()*2+monsterShift;
		}else {
			return hero.getPosition()*2;
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
	
}
