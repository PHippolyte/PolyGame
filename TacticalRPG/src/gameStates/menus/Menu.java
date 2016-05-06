package gameStates.menus;

import game.Cursor;
import game.Game;
import gameStates.GameState;

public abstract class Menu extends GameState{
	protected int nbButton;
	
	public Menu(Game game, Cursor cursor){
		super(game,cursor);
	}
	
	public int getCurrentButton(){
		return this.cursor.getY();
	}
}
