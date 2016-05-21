package view.saveMenu;

import java.awt.Graphics;

import javax.swing.JPanel;

import view.GamePanel;

@SuppressWarnings("serial")
public class SaveMenuPanel extends GamePanel{
	private SaveButtonPanel save1;
	private SaveButtonPanel save2;
	private SaveButtonPanel save3;
	
	public SaveMenuPanel(){
		this.loadBackground("ressources/menu/saveMenu/Background.png");
		
		//ajout du layout
		this.setLayout(null);
	
		
		//creation des boutons
		this.save1 = new SaveButtonPanel();
		this.save2 = new SaveButtonPanel();
		this.save3 = new SaveButtonPanel();
		
		//configuration des boutons
		this.save1.setBounds(70, 90, 500, 100);
		this.save2.setBounds(70, 220, 500, 100);
		this.save3.setBounds(70, 350, 500, 100);
		
		//ajouts des composents 
		this.add(this.save1);
		this.add(this.save2);
		this.add(this.save3);
		
		this.init = false;
	}
	
	public void paint(Graphics g){
		if (this.init){
			g.drawImage(this.bg, 0, 0, this);
			this.init = false;
		}
		
		this.save1.repaint();
		this.save2.repaint();
		this.save3.repaint();
		
	}

	public void init(){
		this.init = true;
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

