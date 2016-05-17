package view.ModeMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import view.GamePanel;

@SuppressWarnings("serial")
public class ModeMenuPanel extends GamePanel{
	private JPanel mode1;
	
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	
	public ModeMenuPanel(){
		this.setBackground(Color.RED);

		
		//ajout du layout
		this.layout = new GridBagLayout();
		this.setLayout(this.layout);
		
		
		//contrainte du layout
		this.constraints = new GridBagConstraints();
		this.constraints.gridx = 1;
		this.constraints.insets.bottom = 30;
		
		//creation des boutons
		this.mode1 = new JPanel();
		
		//config bouton
		this.mode1.setPreferredSize(new Dimension(300,100));
		
		//ajout contrainte aux boutons
		this.layout.setConstraints(this.mode1,this.constraints);
		
		//ajouts boutons
		this.add(this.mode1);
	}

	public JPanel getMode1(){
		return this.mode1;
	}
}
