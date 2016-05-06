package view.mainMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import view.GamePanel;

@SuppressWarnings("serial")
public class MainMenuPanel extends GamePanel{
	private JPanel modeButton;
	private JPanel loadButton;
	private JPanel exitButton;
	
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	
	public MainMenuPanel(){
		this.setBackground(Color.WHITE);
		
		//ajout du layout
		this.layout = new GridBagLayout();
		this.setLayout(this.layout);
		
		//contraintes du layout
		this.constraints = new GridBagConstraints();
		this.constraints.gridx = 1;
		this.constraints.insets.bottom = 30;
		
		//creation des boutons
		this.modeButton = new ModeButtonPanel();
		this.loadButton = new JPanel();
		this.exitButton = new JPanel();
		
		//configuration des boutons
		this.modeButton.setPreferredSize(new Dimension(200,80));
		this.loadButton.setPreferredSize(new Dimension(200,80));
		this.exitButton.setPreferredSize(new Dimension(200,80));
		
		this.layout.setConstraints(this.modeButton, this.constraints);
		this.layout.setConstraints(this.loadButton, this.constraints);
		this.layout.setConstraints(this.exitButton, this.constraints);
		
		//ajouts des composents 
		this.add(this.modeButton);
		this.add(this.loadButton);
		this.add(this.exitButton);
	}

	public JPanel getModeButton() {
		return modeButton;
	}

	public JPanel getLoadButton() {
		return loadButton;
	}

	public JPanel getExitButton() {
		return exitButton;
	}
}
