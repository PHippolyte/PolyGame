package gameStates;

import java.util.Observable;

import Sound.soundManager;
import game.Cursor;
import game.Game;

public abstract class GameState extends Observable implements GameStateConstant{
	protected Game game;
	protected Cursor cursor;
	private soundManager sounds;
	
	public GameState(Game game, Cursor cursor){
		this.game = game;
		this.cursor = cursor;
		this.sounds = new soundManager(0);
		this.initState();
	}
	
	public void setCursor(Cursor cursor){
		this.setCursor(cursor);
	}
	
	public Cursor getCursor(){
		return this.cursor;
	}
	
	public soundManager getSoundManager(){
		return this.sounds;
	}
	
	public int getCurrentButton(){
		return this.cursor.getY();
	}
	
	public void setCurrentButton(int i){
		sounds.play("cursor");
		this.cursor.setY(i);
		this.setChanged();
		this.notifyObservers();
	}
	
	
	public abstract void initState();
	public abstract void doAction();
	public abstract void cancel();
	
	public abstract void moveCursorUp();
	public abstract void moveCursorDown();
	public abstract void moveCursorRight();
	public abstract void moveCursorLeft();
}
