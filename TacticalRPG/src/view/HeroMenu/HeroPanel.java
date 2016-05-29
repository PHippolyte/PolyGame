package view.HeroMenu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.GameComponent;

@SuppressWarnings("serial")
public class HeroPanel extends GameComponent{
	private int x;
	private int y;
	
	public HeroPanel(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void paint(Graphics g){
		g.drawImage(this.bg, 0, 0, this);
	}
}
