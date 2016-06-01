package view.matchState;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.GameElementPanel;

@SuppressWarnings("serial")
public class SpellSelectionPanel extends GameElementPanel{
	private SpellPanel[] spells;
	private int posCursor;
	
	public SpellSelectionPanel(){
		this.setBounds(0, 0, 200, 200);
		this.loadBackground("ressources/match/spellSelectBg.png");
		this.bgSelected = this.load("ressources/match/spellSelector.png");
		spells = new SpellPanel[4];
		this.createPanel();
		
	}
	
	private void createPanel(){
		for (int i=0; i<spells.length; i++){
			spells[i] = new SpellPanel();
		}
	}
	
	private void repaintPanel(Graphics g){
		for (SpellPanel p : spells){
			p.paint(g);
		}
	}
	
	public void setSpellsImages(BufferedImage[] imgs){
		for (int i=0; i<this.spells.length; i++){
			this.getSpellPanel(i).setImage(imgs[i]);
		}
	}

	public void paint(Graphics g){
		if (this.bg != null){
			g.drawImage(this.bg, this.getX(), this.getY(), this.getWidth(), this.getHeight(), this);
		}
		if (this.bgSelected != null){
			int x = this.getX()+((this.getWidth()-this.bgSelected.getWidth())/2);
			int y = this.spells[this.posCursor].getY()+this.spells[this.posCursor].getHeight()+5;
			g.drawImage(this.bgSelected,x,y,this);
		}
		
		this.repaintPanel(g);
	}
	
	public void moveWindow(int x, int y){
		this.setBounds(x,y,this.getWidth(),this.getHeight());
		int height = this.getHeight()/this.spells.length;
		
		int dx, dy;
		for (SpellPanel p : this.spells){
			dx = (this.getWidth()-p.getWidth())/2;
			dy = (height-p.getHeight())/2;
			p.setBounds(x+dx, y+dy, p.getWidth(), p.getHeight());
			y+=height;
		}
	}
	
	public SpellPanel getSpellPanel(int i){
		return this.spells[i];
	}
	
	public void setPosCursor(int i){
		this.posCursor = i;
	}
}
