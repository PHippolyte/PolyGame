package view.matchState;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import gameStates.matchWindows.DefaultAction;
import view.GameElementPanel;

@SuppressWarnings("serial")
public class DefaultActionPanel extends GameElementPanel{
	private DefaultAction action;
	private int buttonWidth;
	private int buttonHeight;
	
	public DefaultActionPanel(DefaultAction a){
		this.setBounds(0, 0, 70, 100);
		this.action = a;
		this.buttonWidth = 60;
		this.buttonHeight = 30;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g.setColor(Color.YELLOW);
		g.fillRect(this.getX()+5, this.getY()+5 + this.action.getCurrentButton()*(this.getHeight()/2), this.getWidth()-10, (this.getHeight()/2)-10);
	}
	
	public void moveWindow(int x, int y){
		this.setBounds(x,y,this.getWidth(),this.getHeight());
	}
}
