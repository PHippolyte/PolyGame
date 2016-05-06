package gameStates.menus;

import game.Cursor;
import game.Game;

public class MainMenu extends Menu{
	
	public MainMenu(Game game, Cursor cursor){
		super(game,cursor);
		this.nbButton = 3;
	}
	
	@Override
	public void initState() {
		this.cursor.setPosition(0, 0);
		this.setChanged();
		this.notifyObservers();
	}

	

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		switch(this.cursor.getY()){
		case(0):
			this.game.setState(MODEMENU);
			break;
		case(1):
			this.game.setState(SAVEMENU);//en chargement
			break;
		case(2):
			this.game.quit();
			break;
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
	}

	@Override
	public void moveCursorUp() {
		if (this.cursor.getY() > 0){
			this.cursor.moveUp();
		} else {
			this.cursor.setY(this.nbButton-1);
		}
		this.setChanged();
		this.notifyObservers();
		
	}


	@Override
	public void moveCursorDown() {
		// TODO Auto-generated method stub
		if (this.cursor.getY() < this.nbButton-1){
			this.cursor.moveDown();
		} else {
			this.cursor.setY(0);
		}
		this.setChanged();
		this.notifyObservers();
	}


	@Override
	public void moveCursorRight() {
		// TODO Auto-generated method stub
		this.moveCursorDown();
	}


	@Override
	public void moveCursorLeft() {
		// TODO Auto-generated method stub
		this.moveCursorUp();
	}
}
