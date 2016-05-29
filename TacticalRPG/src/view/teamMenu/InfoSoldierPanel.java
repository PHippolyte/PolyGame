package view.teamMenu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class InfoSoldierPanel extends JPanel{
public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
}
