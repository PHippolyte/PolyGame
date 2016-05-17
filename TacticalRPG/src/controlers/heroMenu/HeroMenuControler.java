package controlers.heroMenu;

import javax.swing.JPanel;

import controlers.GameStateControler;
import gameStates.menus.HeroMenu;
import view.HeroMenu.HeroMenuPanel;

public class HeroMenuControler extends GameStateControler{
	private HeroMenuPanel view;
	private HeroMenu model;
	
	private HeroMenuObserver observer;
	
	public HeroMenuControler(HeroMenu model){
		this.model = model;
		this.view = new HeroMenuPanel(this.model.getNbCol(),this.model.getNbRow());
		
		this.observer = new HeroMenuObserver(this.view);
		this.model.addObserver(this.observer);
		
		this.addListener();
		
		
	}
	
	private void addListener(){
		for (int i=0; i<this.model.getNbCol(); i++){
			for (int j=0; j<this.model.getNbRow(); j++){
				this.view.getHero(i, j).addMouseListener(new HeroPaneListener(this.model,this.view.getHero(i, j)));
			}
		}
	}
	
	
	@Override
	public JPanel getView() {
		// TODO Auto-generated method stub
		return this.view;
	}

}
