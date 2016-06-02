package view.ModeMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.GameElementPanel;

@SuppressWarnings("serial")
public class ModePanel extends GameElementPanel{
	private BufferedImage text;
	
	public ModePanel(String path){
		this.text = this.load(path);
	}
	
	public void paint(Graphics g){
		if (selected)g.drawImage(this.bgSelected, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
		else g.drawImage(this.bg, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
		
		if (this.text != null){
			int dx = (this.getWidth()-this.text.getWidth())/2;
			int dy = (this.getHeight()-this.text.getHeight())/2;
			g.drawImage(this.text, this.getX()+dx, this.getY()+dy, this);
		}
	}
	
	public void setText(BufferedImage img){
		this.text = img;
	}
}
