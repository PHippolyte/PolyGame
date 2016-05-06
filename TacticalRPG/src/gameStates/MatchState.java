package gameStates;

import game.Cursor;
import game.Game;
import game.Match;

public class MatchState extends GameState{
	private Match match;
	
	public MatchState(Game game, Cursor cursor){
		super(game,cursor);
	}
	
	@Override
	public void initState() {
		// TODO Auto-generated method stub
		this.cursor.setPosition(0, 0);
		this.match = this.game.getMatch();
	}
	
	public void setMatch(Match match){
		this.match = match;
	}
	
	public Match getMatch(){
		return this.match;
	}

	@Override
	public void doAction() {
		System.out.println(this.cursor);
		this.match.getMap().printInfoTile(this.cursor.getX(), this.cursor.getY());
		//Plein de truc à faire!!
	}
	
	public void cancel(){
		//Plein de truc a faire!! :D
	}

	@Override
	public void moveCursorUp() {
		// TODO Auto-generated method stub
		if (this.cursor.getY() > 0) {
			this.cursor.moveUp();
		}
	}

	@Override
	public void moveCursorDown() {
		// TODO Auto-generated method stub
		if (this.cursor.getY() < this.match.getMap().getNbRows()-1){
			this.cursor.moveDown();
		}
	}

	@Override
	public void moveCursorRight() {
		// TODO Auto-generated method stub
		if (this.cursor.getX() < this.match.getMap().getNbCols()-1){
			this.cursor.moveRight();
		}
	}

	@Override
	public void moveCursorLeft() {
		// TODO Auto-generated method stub
		if (this.cursor.getX() > 0 ){
			this.cursor.moveLeft();
		}
	}
}
