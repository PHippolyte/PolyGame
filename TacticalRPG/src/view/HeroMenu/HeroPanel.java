package view.HeroMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.GameElementPanel;

@SuppressWarnings("serial")
public class HeroPanel extends GameElementPanel{
	private int num;
	private BufferedImage text;
	
	public HeroPanel(int num){
		this.num = num;
	}
	
	
	
	public int getNum(){
		return this.num;
	}
	
	public void paint(Graphics g){
		if (this.selected) g.drawImage(this.bgSelected, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
		else g.drawImage(this.bg, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
	}
}
