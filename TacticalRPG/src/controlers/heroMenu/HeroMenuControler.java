package controlers.heroMenu;

import controlers.GameStateControler;
import gameStates.menus.HeroMenu;
import view.GamePanel;
import view.HeroMenu.HeroMenuPanel;

public class HeroMenuControler extends GameStateControler{
	private HeroMenu model;
	private HeroMenuPanel view;
	
	private HeroMenuObserver observer;
	
	public HeroMenuControler(HeroMenu model){
		this.model = model;
		this.view = new HeroMenuPanel(this.model.getNbButton());
		
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
	
	public GamePanel getView(){
		return this.view;
	}
	
	public void init(){
		
	}

	@Override
	public void updateObserver() {
		// TODO Auto-generated method stub
		
	}
}
