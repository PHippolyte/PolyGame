package view.HeroMenu;

import java.awt.Color;
import java.awt.GridLayout;

import view.GamePanel;

@SuppressWarnings("serial")
public class HeroMenuPanel extends GamePanel{
	private int nbHeroPanel;
	private int nx;
	private int ny;
	private HeroPanel[][] heros;
	private GridLayout layout;
	
	public HeroMenuPanel(int nx, int ny){
		this.setBackground(Color.ORANGE);
		this.nx = nx;
		this.ny = ny;
		this.heros = new HeroPanel[nx][ny];
		
		//ajout du layout
		this.createLayout();
		
		//contrainte du layout
		
		//creation des boutons
		this.createHeroPanel();
		
		//ajout contrainte aux boutons
		
		//ajouts boutons
		this.addHeroPanel();
	}
	
	private void createLayout(){
		this.layout = new GridLayout(this.ny,this.nx,10,10);
		this.setLayout(this.layout);
	}
	
	private void createHeroPanel(){
		for (int j=0; j < this.nx; j++){
			for (int k=0; k < this.ny; k++){
				this.heros[j][k] = new HeroPanel(j,k);
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
				this.getHero(j, k).setBackground(Color.LIGHT_GRAY);
			}
		}
	}
	
	public HeroPanel getHero(int x, int y){
		return this.heros[x][y];
	}
	
	public int getNbHeroPanel(){
		return this.nbHeroPanel;
	}

}
