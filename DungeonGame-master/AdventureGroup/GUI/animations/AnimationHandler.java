package GUI.animations;

import java.io.Serializable;

import GUI.FightAnimationPanel;
import game.Game;
import gameEncounter.Hero;

public class AnimationHandler implements Serializable{
	private Game game;
	private FightAnimationPanel fap;
	private Animation activeAnimation;
	public AnimationHandler(Game game){
		this.game=game;
	}
	public void attachFightAnimationPanel(FightAnimationPanel panel) {
		fap=panel;
	}
	public void produceCombatAnimation(Hero attacker, Hero target) {
		if (fap!=null) {
			activeAnimation=new AttackAnimation(fap);
		}
	}
	public void produceFriendlyAnimation(Hero caster) {
		if (fap!=null) {
			activeAnimation=new FriendlyAnimation(fap);
		}
	}
}
