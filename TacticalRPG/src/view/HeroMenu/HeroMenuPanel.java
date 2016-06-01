package view.HeroMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
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
		this.ny = 3;
		
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
		int width = this.getWidth()/ny;
		int height = (this.getHeight()-60)/3;
		int x = 0;
		int y = 60;
		int counter = 0;
		for (HeroPanel p : this.heros){
			p.setBounds(x, y, width, height);
			x+=width;
			counter++;
			if (counter == ny){
				counter = 0;
				y+=height;
				x = 0;
			}
		}
	}
	
	private void createPanels(){
		BufferedImage heroBg = this.load("ressources/menu/heroMenu/HeroBackground.png");
		BufferedImage heroSelect = this.load("ressources/menu/heroMenu/HeroSelected.png");
		for (int i=0; i<this.nbHero; i++){
			HeroPanel p = new HeroPanel(i);
			p.setBackgroundImage(heroBg);
			p.setBgSelected(heroSelect);
			this.heros.add(p);
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
		
		this.paintPanels(g);
	}

	@Override
	public void init() {
		this.init = true;
	}
	
	public void paintPanels(Graphics g){
		for (HeroPanel p : this.heros){
			p.paint(g);
		}
	}
	
	
	public void resetPanel(){
		for (HeroPanel p : this.heros){
			p.setSelected(false);
		}
	}
}
