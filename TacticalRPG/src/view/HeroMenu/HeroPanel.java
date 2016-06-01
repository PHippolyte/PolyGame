package view.HeroMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.GameComponent;

@SuppressWarnings("serial")
public class HeroPanel extends GameComponent{
	private int num;
	private BufferedImage text;
	
	public HeroPanel(int num){
		this.num = num;
	}
	
	
	
	public int getNum(){
		return this.num;
	}
	
	public void paint(Graphics g){
		g.drawImage(this.bg, 0, 0, this);
	}
}
