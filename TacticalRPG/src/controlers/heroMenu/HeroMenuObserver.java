package controlers.heroMenu;

import java.util.Observable;
import java.util.Observer;

import gameStates.menus.HeroMenu;
import view.HeroMenu.HeroMenuPanel;

public class HeroMenuObserver implements Observer{
	private HeroMenuPanel view;
	
	public HeroMenuObserver(HeroMenuPanel view){
		this.view = view;
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		HeroMenu model = (HeroMenu)arg0;
		int num = model.getCursor().getX()+(model.getNbCol()*model.getCursor().getY());
		
		view.resetPanel();	
		view.getHero(num).setSelected(true);
		
		this.view.repaint();
		
	}

}
