package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import game.Player;
import gameEncounter.Card;
import gameEncounter.GameEquations;
import gameEncounter.Hero;
import gameEncounter.ModableHeroStats;
import gameEncounter.Weapon;

public class HeroStatsPaintComponent extends JComponent{
		private Player player;
		protected int height;
		public HeroStatsPaintComponent(Player player){
			this.player=player;
			height=24;
			setBorder(new LineBorder(Color.GREEN));
			super.setPreferredSize(new Dimension(440,height*15));
			setVisible(true);
		}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawImage(image,0,0,null);
		//paint Hero info all interesting stats about the hero
		LinkedList<String> lines=new LinkedList<String>();
		lines.add(player.getSelectedHero().getName()+" ("+player.getSelectedHero().getCharRace().getName()+", "+player.getSelectedHero().getCharClass().getName()+")");
		lines.add("");
		lines.add("health: "+player.getSelectedHero().getHp()+"/"+GameEquations.maxHealthCalc(player.getSelectedHero())+" ("+player.getSelectedHero().getWounds()+")");
		lines.add("stress: "+player.getSelectedHero().getStress()+"/"+player.getSelectedHero().getStressCap());
		lines.add("");
//		if(player.getSelectedHero().getEquipment().getHand1() instanceof Weapon) {
//			Weapon weapon= (Weapon) player.getSelectedHero().getEquipment().getHand1();
//			lines.add("damage: "+weapon.AttackDamageToString(player.getSelectedHero().getStrength(),player.getSelectedHero().getDexterity()));
//		}else {
//			lines.add("damage: "+GameEquations.FistDamageToString(player.getSelectedHero().getStrength(), player.getSelectedHero().getDexterity()));
//		}
		//main stats
		lines.add("strength: "+player.getSelectedHero().getStrength());
		lines.add("dexterity: "+player.getSelectedHero().getDexterity());
		lines.add("intelligence: "+player.getSelectedHero().getIntelligence());
		lines.add("vitality: "+player.getSelectedHero().getVitality());		
		lines.add("");
		//			
		lines.add("speed: "+player.getSelectedHero().getSpeed()+" ("+GameEquations.speedCalc(player.getSelectedHero())+")");
		lines.add("attack skill: "+player.getSelectedHero().getAttackSkill()+" ("+GameEquations.attackSkillCalc(player.getSelectedHero())+")");
		lines.add("block skill: "+player.getSelectedHero().getBlockSkill()+" ("+GameEquations.blockSkillCalc(player.getSelectedHero())+")");
		lines.add("accuracy: "+player.getSelectedHero().getAccuracy()+" ("+GameEquations.accuracyCalc(player.getSelectedHero())+")");
		lines.add("dodge: "+player.getSelectedHero().getDodge()+" ("+GameEquations.dodgeCalc(player.getSelectedHero())+")");
		lines.add("spell power: "+player.getSelectedHero().getSpellPower()+" ("+GameEquations.spellPowerCalc(player.getSelectedHero())+")");		
		
		lines.add("thorns: "+player.getSelectedHero().getThorns());
		lines.add("");
		//offensive
		lines.add("crit chance: "+ player.getSelectedHero().getCritChance());
		lines.add("crit damage: "+ (GameEquations.critDamageCalc(player.getSelectedHero())+100)+"%");	
		lines.add("magic damage: "+player.getSelectedHero().getMagicDmg());
		lines.add("fire damage: "+player.getSelectedHero().getFireDmg());
		lines.add("cold damage: "+player.getSelectedHero().getColdDmg());
		lines.add("lightning damage: "+player.getSelectedHero().getLightningDmg());
		lines.add("poison damage: "+player.getSelectedHero().getPoisonDmg());
		lines.add("bleed damage: "+player.getSelectedHero().getBleedDmg());
		lines.add("");
		//defensive
		lines.add("armor: "+player.getSelectedHero().getArmor()+"("+(100-GameEquations.damageReducedByArmor(100, player.getSelectedHero().getArmor()))+"%)");
		lines.add("spell resist: "+player.getSelectedHero().getSpellResist());
		lines.add("fire resistance: "+player.getSelectedHero().getResistFire());
		lines.add("cold resistance: "+player.getSelectedHero().getResistCold());
		lines.add("poison resistance: "+player.getSelectedHero().getResistPoison());
		lines.add("bleed resistance: "+player.getSelectedHero().getResistBleed());
		lines.add("stun resistance: "+player.getSelectedHero().getResistStun());
		lines.add("stress resistance: "+player.getSelectedHero().getResistStress());
		lines.add("trap disarm: "+player.getSelectedHero().getTrapDisarm());
		lines.add("");		
		lines.add("wisdom: "+player.getSelectedHero().getDraw());
		lines.add("mana: "+player.getSelectedHero().getManaPower());
		lines.add("");
		lines.add("Level: "+player.getSelectedHero().getLevel());
		lines.add("experience: "+player.getSelectedHero().getExperience()+"/"+GameEquations.experienceThresholdForLevelUp(player.getSelectedHero().getLevel()));		
		//Quirks
		lines.add("");
		if(player.getSelectedHero().getQuirks().size()>0) {
			lines.add("Quirks:");
			for(int a=0; a<player.getSelectedHero().getQuirks().size();a++) {
				String quirkString=player.getSelectedHero().getQuirks().get(a).getName()+"(";
				for(int b=0; b<player.getSelectedHero().getQuirks().get(a).getDescription().size();b++) {
					quirkString+=player.getSelectedHero().getQuirks().get(a).getDescription().get(b);
				}
				quirkString+=")";
				lines.add(quirkString);
			}
			lines.add("");
		}
		g.drawImage(player.getSelectedHero().getImage().getScaledInstance(300, 255, 5),200,0,null);	
		//
		for(int i=0; i<lines.size();i++) {
			if(i<=height+1) {
				g.drawString(lines.get(i), 10, 10+12*i);
			}else {
				g.drawString(lines.get(i), 150, 10+12*(i-height+2));
			}
			
		}
		
	}
}

