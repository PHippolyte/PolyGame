package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame{
	private GamePanel panel;
	
	
	public Window(){
		this.setTitle("Java Project");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	
		this.setVisible(true);
	}
	
	public void changeScreen(GamePanel panel){
		this.remove(this.panel);
		this.setScreen(panel);
		System.out.println("Changed Screen");
	}
	
	public void setScreen(GamePanel panel){
		this.panel = panel;
		this.panel.init();
		this.setContentPane(panel);
		this.pack();
	}
}
