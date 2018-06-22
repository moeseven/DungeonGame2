package GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JTextField;

import gameEncounter.GameEquations;
import gameEncounter.Weapon;

public class CharcterBuilderInfoComponent extends JComponent{
	private FrameCharacterBuilder fcb;
	private JTextField tf;
	public CharcterBuilderInfoComponent(FrameCharacterBuilder fcb) {
		this.fcb=fcb;
		this.setLayout(new BorderLayout());
		tf=new JTextField();
		tf.setText("type name here");
		this.add(tf, BorderLayout.NORTH);
		this.setVisible(true);
	}
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("create your starting hero", 100, 10);
//		g.drawString("hero class: "+fcb.getCb().getCharClass().getInfo(), 10, 50);
//		g.drawString("hero race : "+fcb.getCb().getCharRace().getInfo(), 10, 64);
		g.drawString(fcb.getCb().getHero().getName()+" ("+fcb.getCb().getHero().getCharRace().getName()+", "+fcb.getCb().getHero().getCharClass().getName()+")", 10, 80);
		g.drawString("HP: "+fcb.getCb().getHero().getHp()+"/"+fcb.getCb().getHero().computeMaxHp(), 10, 80+1*11);
		if(fcb.getCb().getHero().getEquipment().getHand1() instanceof Weapon) {
			Weapon weapon= (Weapon) fcb.getCb().getHero().getEquipment().getHand1();
			g.drawString("damage: "+weapon.AttackDamageToString(fcb.getCb().getHero().getStrength()), 10, 80+2*11);
		}else {
			g.drawString("damage: "+GameEquations.FistDamageToString(fcb.getCb().getHero().getStrength(), fcb.getCb().getHero().getDexterity()), 10, 80+2*11);
		}
		//g.drawString("block skill: "+fcb.getCb().getHero().getBlockSkill(), 10, 80+3*11);
		g.drawString("wisdom: "+fcb.getCb().getHero().getDraw(), 10, 80+7*11);
		g.drawString("mana: "+fcb.getCb().getHero().getManaPower(), 10, 80+5*11);
		g.drawString("thorns: "+fcb.getCb().getHero().getThorns(), 10, 80+6*11);
		g.drawString("armor: "+fcb.getCb().getHero().getArmor(), 10, 80+4*11);
		g.drawString("strength: "+fcb.getCb().getHero().getStrength(), 10, 80+8*11);
		g.drawString("dexterity: "+fcb.getCb().getHero().getDexterity(), 10, 80+9*11);
		g.drawString("intelligence: "+fcb.getCb().getHero().getIntelligence(), 10, 80+10*11);
		g.drawString("vitality: "+fcb.getCb().getHero().getVitality(), 10, 80+11*11);
		g.drawString("speed: "+fcb.getCb().getHero().getSpeed(), 10, 80+12*11);
		g.drawString("attack skill: "+fcb.getCb().getHero().getAttackSkill(), 10, 80+13*11);
		g.drawString("block skill: "+fcb.getCb().getHero().getBlockSkill(), 10, 80+14*11);
		g.drawString("accuracy: "+fcb.getCb().getHero().getAccuracy(), 10, 80+15*11);
		g.drawString("dodge: "+fcb.getCb().getHero().getDodge(), 10, 80+16*11);
		g.drawString("spell power: "+fcb.getCb().getHero().getSpellPower(), 10, 80+17*11);
		g.drawString("spell resist: "+fcb.getCb().getHero().getSpellResist(), 10, 80+18*11);
	}
	public JTextField getTf() {
		return tf;
	}
	public void setTf(JTextField tf) {
		this.tf = tf;
	}
	
}
