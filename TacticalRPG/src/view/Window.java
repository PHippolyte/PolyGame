package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Window extends JFrame{
	private JPanel panel;
	
	
	public Window(){
		this.setTitle("Java Project");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	
		this.setVisible(true);
	}
	
	public void changeScreen(JPanel panel){
		this.remove(this.panel);
		this.panel = panel;
		this.setContentPane(panel);
		this.pack();
	}
	
	public void setScreen(JPanel panel){
		this.panel = panel;
		this.add(panel);
	}
}
