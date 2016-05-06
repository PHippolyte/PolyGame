package gameStates.menus;

import game.Cursor;
import game.Game;
import gameStates.modes.*;

public class ModeMenu extends Menu{
	
	public ModeMenu(Game game, Cursor cursor) {
		super(game, cursor);
		// TODO Auto-generated constructor stub
		this.nbButton = 1;
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
		this.game.initMatch();
		switch(this.cursor.getY()){
		case(0):
			this.game.getMatch().setMode(new DeathMatch());
			break;
		}
		this.game.setState(HEROMENU);
	}
	
	public void cancel(){
		this.game.setState(MAINMENU);
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
