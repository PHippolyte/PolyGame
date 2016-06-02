package gameStates.menus;

import java.util.ArrayList;

import game.Cursor;
import game.Game;
import gameStates.modes.*;

public class ModeMenu extends Menu{
	private ArrayList<Mode> modes;
	
	public ModeMenu(Game game, Cursor cursor) {
		super(game, cursor);
		// TODO Auto-generated constructor stub
		this.modes = new ArrayList<Mode>();
		this.modes.add(new DeathMatch());
		this.nbButton = this.modes.size();
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
		this.getSoundManager().play("enter");
		switch(this.cursor.getY()){
		case(0):
			Mode mode = this.modes.get(0);
			mode.setMatch(this.game.getMatch());
			this.game.getMatch().setMode(mode);
		}
		
		this.game.setState(HEROMENU);
	}
	
	public void cancel(){
		this.game.setState(MAINMENU);
	}

	@Override
	public void moveCursorUp() {
		this.getSoundManager().play("cursor");
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
		this.getSoundManager().play("cursor");
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
