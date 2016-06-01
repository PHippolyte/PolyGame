package view.matchState;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.GameElementPanel;

@SuppressWarnings("serial")
public class SpellPanel extends GameElementPanel{
	
	
	public void paint(Graphics g){
		if (this.bg != null){
			g.drawImage(this.bg, this.getX(), this.getY(), this);
		}
	}
	
	public void moveWindow(int x, int y){
		this.setBounds(x,y,this.getWidth(),this.getHeight());
	}
	
	public void setImage(BufferedImage img){
		if (img != null){
			this.bg = img;
			this.setBounds(this.getX(), this.getY()	,img.getWidth(), img.getHeight());
		}
	}
}
