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
			height=16;
			setBorder(new LineBorder(Color.GREEN));
			super.setPreferredSize(new Dimension(300,height*15));
			setVisible(true);
		}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawImage(image,0,0,null);
		//paint Hero info all interesting stats about the hero
		LinkedList<String> lines=new LinkedList<String>();
		lines.add(player.getSelectedHero().getName()+" ("+player.getSelectedHero().getCharRace().getName()+", "+player.getSelectedHero().getCharClass().getName()+")");
		lines.add("");
		lines.add("HP: "+player.getSelectedHero().getHp()+"/"+player.getSelectedHero().computeMaxHp());
		if(player.getSelectedHero().getEquipment().getHand1() instanceof Weapon) {
			Weapon weapon= (Weapon) player.getSelectedHero().getEquipment().getHand1();
			lines.add("damage: "+weapon.AttackDamageToString(player.getSelectedHero().getStrength()));
		}else {
			lines.add("damage: "+GameEquations.FistDamageToString(player.getSelectedHero().getStrength(), player.getSelectedHero().getDexterity()));
		}
		//main stats
		lines.add("");
		lines.add("strength: "+player.getSelectedHero().getStrength());
		lines.add("dexterity: "+player.getSelectedHero().getDexterity());
		lines.add("intelligence: "+player.getSelectedHero().getIntelligence());
		lines.add("vitality: "+player.getSelectedHero().getVitality());		
		lines.add("");
		//
		lines.add("speed: "+player.getSelectedHero().getSpeed()+" ("+player.getSelectedHero().computeSpeed()+")");
		lines.add("attack skill: "+player.getSelectedHero().getAttackSkill()+" ("+player.getSelectedHero().computeAttackSkill()+")");
		lines.add("block skill: "+player.getSelectedHero().getBlockSkill()+" ("+player.getSelectedHero().computeBlockSkill()+")");
		lines.add("accuracy: "+player.getSelectedHero().getAccuracy()+" ("+player.getSelectedHero().computeAccuracy()+")");
		lines.add("dodge: "+player.getSelectedHero().getDodge()+" ("+player.getSelectedHero().computeDodge()+")");
		lines.add("spell power: "+player.getSelectedHero().getSpellPower()+" ("+player.getSelectedHero().computeSpellPower()+")");
		lines.add("spell resist: "+player.getSelectedHero().getSpellResist()+" ("+player.getSelectedHero().computeSpellResist()+")");
		lines.add("armor: "+player.getSelectedHero().getArmor());
		lines.add("thorns: "+player.getSelectedHero().getThorns());
		lines.add("wisdom: "+player.getSelectedHero().getDraw());
		lines.add("mana: "+player.getSelectedHero().getManaPower());						
		for(int i=0; i<lines.size();i++) {
			if(i<=height) {
				g.drawString(lines.get(i), 10, 10+12*i);
			}else {
				g.drawString(lines.get(i), 150, 10+12*(i-height+2));
			}
			
		}
		
	}
}

