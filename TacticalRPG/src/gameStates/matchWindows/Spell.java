package gameStates.matchWindows;

import java.util.List;
import java.util.Random;

import game.Cursor;
import gameObject.Character;
import gameObject.Tile;
import gameStates.MatchState;

public class Spell extends StateMatch {
	private Character selectedCharacter;
	private List<Character> listCharacter; 

	public Spell(MatchState matchState, Cursor cursor) {
		super(matchState, cursor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		//fonction de calcul d'attaque
		Tile tileA = this.matchState.getMatch().getMap().getTile(this.selectedCharacter.getX(), this.selectedCharacter.getY());
		Tile tileB = this.matchState.getMatch().getMap().getTile(this.cursor.getX(), this.cursor.getY());
		spellEffect.Spell.whichSpell(listCharacter, selectedCharacter, spell, tileA, tileB);
		this.matchState.setCurrentState(IDLE);
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		this.matchState.setCursorPosition(this.selectedCharacter.getX(), this.selectedCharacter.getY());
		this.matchState.setCurrentState(CHARACTERACTION);
	}

	@Override
	public void moveCursorUp() {
		// TODO Auto-generated method stub
		if (this.cursor.getY() > 0){
			this.cursor.moveUp();
			if (this.cursor.getY() < this.matchState.getScreen().getY1()){
				this.matchState.getScreen().moveUp();
			}
		}
	}

	@Override
	public void moveCursorDown() {
		// TODO Auto-generated method stub
		if (this.cursor.getY() < this.matchState.getMatch().getMap().getNbRows()-1){
			this.cursor.moveDown();
			if (this.cursor.getY() > this.matchState.getScreen().getY2()){
				this.matchState.getScreen().moveDown();
			}
		}
	}

	@Override
	public void moveCursorRight() {
		// TODO Auto-generated method stub
		if (this.cursor.getX() < this.matchState.getMatch().getMap().getNbCols()-1){
			this.cursor.moveRight();
			if (this.cursor.getX() > this.matchState.getScreen().getX2()){
				this.matchState.getScreen().moveRight();
			}
		}
	}

	@Override
	public void moveCursorLeft() {
		// TODO Auto-generated method stub
		if (this.cursor.getX() > 0){
			this.cursor.moveLeft();
			if (this.cursor.getX() < this.matchState.getScreen().getX1()){
				this.matchState.getScreen().moveLeft();
			}
		}
	}
	
	public void setSelectedCharacter(Character character){
		this.selectedCharacter = character;
	}

}
