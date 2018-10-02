package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import GUI.grafics.StaticImageLoader;
import gameEncounter.Card;
import gameEncounter.Hero;

public class MonsterFightComponent extends HeroFightComponent{
	public MonsterFightComponent(FightWindow fw, Hero monster) {
		super(fw, monster);
	}
}
