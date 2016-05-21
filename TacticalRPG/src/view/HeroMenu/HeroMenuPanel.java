package view.HeroMenu;

import java.awt.Graphics;

import view.GamePanel;

@SuppressWarnings("serial")
public class HeroMenuPanel extends GamePanel{
	private int nbHeroPanel;
	private int nx;
	private int ny;
	private int nbHero;
	private HeroPanel[][] heros;
	
	public HeroMenuPanel(int nbHero){
		this.init = true;
		
		this.nbHero = nbHero;
		this.setLayout(null);
	
		this.loadBackground("ressources/menu/heroMenu/Background.png");
		
		
		//creation des boutons
		this.createPanels();
		this.createHeroPanel();
		
		//ajout contrainte aux boutons
		
		//ajouts boutons
		this.addHeroPanel();
		
		this.init = false;
	}
	
	private void createPanels(){
		this.nx = 3;
		this.ny = this.nbHero/this.nx;
		if (this.nbHero%this.nx != 0) this.ny++;
		this.heros = new HeroPanel[nx][ny];
	}
	
	private void createHeroPanel(){
		for (int j=0; j < this.ny; j++){
			for (int k=0; k < this.nx; k++){
				HeroPanel panel = new HeroPanel(j,k);
				panel.setBounds(k*210,60+j*140,210,140);
				panel.loadBackground("ressources/Heros/FaceLyndis.png");
				this.heros[j][k] = panel;
			}
		}
		this.nbHeroPanel = nx*ny;
	}
	
	private void addHeroPanel(){
		for (int j=0; j < ny; j++){
			for (int k=0; k < nx; k++){
				this.add(this.heros[k][j]);
			}
		}
	}
	
	public void resetButton(){
		for (int j=0; j < nx; j++){
			for (int k=0; k < ny; k++){
				this.getHero(j, k).repaint();
			}
		}
	}
	
	public HeroPanel getHero(int x, int y){
		return this.heros[x][y];
	}
	
	public int getNbHeroPanel(){
		return this.nbHeroPanel;
	}
	
	public void paint(Graphics g){
		if (this.init){
			g.drawImage(this.bg, 0, 0,this);
		}
		this.resetButton();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		this.init = true;
	}
}
