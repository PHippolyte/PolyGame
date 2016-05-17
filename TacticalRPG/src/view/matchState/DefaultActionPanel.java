package view.matchState;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import gameStates.matchWindows.DefaultAction;

@SuppressWarnings("serial")
public class DefaultActionPanel extends JPanel{
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
		g.fillRect(this.getX()+((this.getWidth()+this.buttonWidth)/2),(this.getY()+10)+(this.action.getCurrentButton()*(this.getHeight()+5)) ,this.buttonWidth ,this.getHeight()-20 );
	}
	
	public void moveWindow(int x, int y){
		this.setBounds(x,y,this.getWidth(),this.getHeight());
	}
}
