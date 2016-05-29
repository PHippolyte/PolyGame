package gameStates.menus;

import game.Cursor;
import game.Game;

public class SaveMenu extends Menu{
	private boolean saving;
	public SaveMenu(Game game, Cursor cursor) {
		super(game, cursor);
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
		this.getSoundManager().play("enter");
		//tout est a faire
		if (saving) {
			//on sauvegarde au slot choisit
			//this.save(this.selectedSlot);
			
			//ensuite on retourne au menu principal
			//this.game.setCurrentState(MAINMENU);
		} else {
			//on charge la partie
			//this.load(this.selecteSlot);
			//this.game.setMatch(loadedMatch);
			
			//on lance la partie
			//this.game.setCurrentState(MATCHSTATE);
			//this.game.getMatch().startMatch();
		}
		
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
