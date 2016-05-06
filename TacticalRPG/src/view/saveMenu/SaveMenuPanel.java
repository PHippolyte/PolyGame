package view.saveMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import view.GamePanel;

@SuppressWarnings("serial")
public class SaveMenuPanel extends GamePanel{
	private JPanel save1;
	private JPanel save2;
	private JPanel save3;
	
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	
	public SaveMenuPanel(){
		this.setBackground(Color.CYAN);
		
		//ajout du layout
		this.layout = new GridBagLayout();
		this.setLayout(this.layout);
		
		//contraintes du layout
		this.constraints = new GridBagConstraints();
		this.constraints.gridx = 1;
		this.constraints.insets.bottom = 30;
		
		//creation des boutons
		this.save1 = new JPanel();
		this.save2 = new JPanel();
		this.save3 = new JPanel();
		
		//configuration des boutons
		this.save1.setPreferredSize(new Dimension(500,100));
		this.save2.setPreferredSize(new Dimension(500,100));
		this.save3.setPreferredSize(new Dimension(500,100));
		
		this.layout.setConstraints(this.save1, this.constraints);
		
		this.layout.setConstraints(this.save2, this.constraints);
		this.layout.setConstraints(this.save3, this.constraints);
		
		//ajouts des composents 
		this.add(this.save1);
		this.add(this.save2);
		this.add(this.save3);
	}

	public JPanel getSave1() {
		return save1;
	}

	public JPanel getSave2() {
		return save2;
	}

	public JPanel getSave3() {
		return save3;
	}
	
	
}

