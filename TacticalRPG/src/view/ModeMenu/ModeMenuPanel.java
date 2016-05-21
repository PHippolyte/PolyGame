package view.ModeMenu;

import java.awt.Graphics;

import javax.swing.JPanel;

import view.GamePanel;

@SuppressWarnings("serial")
public class ModeMenuPanel extends GamePanel{
	private JPanel mode1;
	
	public ModeMenuPanel(){
		this.init = true;
		
		this.loadBackground("ressources/menu/modeMenu/Background.png");

		
		//ajout du layout
		this.setLayout(null);
		
		//creation des boutons
		this.mode1 = new JPanel();
		
		//config bouton
		this.mode1.setBounds(170, 220, 300, 100);
		
		//ajouts boutons
		this.add(this.mode1);
		
		this.init = false;
	}
	public void init(){
		this.init = true;
	}
	
	public JPanel getMode1(){
		return this.mode1;
	}
	
	public void paint(Graphics g){
		if (this.init){
			g.drawImage(this.bg, 0, 0,this.width,this.height, this);
			this.init = false;
		}
		this.mode1.repaint();
	}
}
