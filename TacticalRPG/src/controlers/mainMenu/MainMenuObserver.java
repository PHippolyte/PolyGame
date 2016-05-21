package controlers.mainMenu;

import java.util.Observable;
import java.util.Observer;

import gameStates.menus.MainMenu;
import view.mainMenu.MainMenuPanel;

import java.awt.Color;


public class MainMenuObserver implements Observer{
	private MainMenuPanel view;

	public MainMenuObserver(MainMenuPanel view){
		this.view = view;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		MainMenu model = (MainMenu)arg0;
		int button = model.getCursor().getY();

		this.view.repaint();

	}

}
