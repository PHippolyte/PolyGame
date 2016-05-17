package view.HeroMenu;

import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HeroPanel extends JPanel{
	private int x;
	private int y;
	public HeroPanel(int x, int y){
		this.x = x;
		this.y = y;
		this.setBackground(Color.LIGHT_GRAY);
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
}
