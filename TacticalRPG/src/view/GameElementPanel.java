package view;

import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class GameElementPanel extends GameComponent{
	protected BufferedImage bgSelected;
	
	protected boolean selected;
	
	public void setBgSelected(BufferedImage img){
		this.bgSelected = img;
	}
	
	public void setSelected(boolean b){
		this.selected = b;
	}
}
