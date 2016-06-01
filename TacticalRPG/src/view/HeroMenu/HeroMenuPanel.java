package view.HeroMenu;

import java.awt.Graphics;
import java.util.ArrayList;

import view.GamePanel;

@SuppressWarnings("serial")
public class HeroMenuPanel extends GamePanel{
	private int nx;
	private int ny;
	private int nbHero;
	private ArrayList<HeroPanel> heros;
	
	public HeroMenuPanel(int nbHero){
		this.init = true;
		
		this.heros = new ArrayList<HeroPanel>();
		this.nbHero = nbHero;
		this.setLayout(null);
	
		this.loadBackground("ressources/menu/heroMenu/Background.png");
		
		
		//creation des boutons
		this.createPanels();
		this.positionPanel();
		
		
		//ajouts boutons
		this.addHeroPanel();
		
		this.init = false;
	}
	
	private void positionPanel(){
		int width = this.getWidth()/3;
		int height = this.getHeight()/(1+this.nbHero%3);
		System.out.println(width+','+height);
	}
	
	private void createPanels(){
		for (int i=0; i<this.nbHero; i++){
			this.heros.add(new HeroPanel(i));
		}
	}
	
	private void addHeroPanel(){
		for (HeroPanel p : this.heros){
			this.add(p);
		}
	}
	
	public ArrayList<HeroPanel> getHeroPanels(){
		return this.heros;
	}
	
	public HeroPanel getHero(int num){
		return this.heros.get(num);
	}
	
	public int getNbHeroPanel(){
		return this.nbHero;
	}
	
	public void paint(Graphics g){
		if (this.init){
			g.drawImage(this.bg, 0, 0,this);
		}
		this.resetPanel();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.init = true;
	}
	
	public void resetPanel(){
		
	}
}
