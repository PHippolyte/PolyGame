package view;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GamePanel extends JPanel{
	public GamePanel(){
		this.setPreferredSize(new Dimension(640,480));
	}

}
