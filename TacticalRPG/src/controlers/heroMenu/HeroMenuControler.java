package controlers.heroMenu;

import javax.swing.JPanel;

import controlers.GameStateControler;
import gameStates.menus.HeroMenu;
import view.HeroMenu.HeroMenuPanel;

public class HeroMenuControler extends GameStateControler{
	private HeroMenuPanel view;
	private HeroMenu model;
	
	public HeroMenuControler(HeroMenu model){
		this.view = new HeroMenuPanel();
		this.model = model;
	}
	
	
	@Override
	public JPanel getView() {
		// TODO Auto-generated method stub
		return this.view;
	}

}
