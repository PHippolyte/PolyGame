package controlers.heroMenu;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gameStates.menus.HeroMenu;
import view.HeroMenu.HeroPanel;

public class HeroPaneListener implements MouseListener{
	private HeroPanel panel;
	private HeroMenu model;
	
	public HeroPaneListener(HeroMenu model, HeroPanel panel){
		this.model = model;
		this.panel = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.model.doAction();		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.model.setCursorPosition(this.panel.getX(), this.panel.getY());
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
