package gameStates.menus;

import game.Cursor;
import game.Game;
import gameObject.heros.*;

public class HeroMenu extends Menu{

	public HeroMenu(Game game, Cursor cursor) {
		super(game, cursor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		this.cursor.setPosition(0, 0);
		this.nbButton = 10;//provisoire
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		switch(this.cursor.getY()){
		case(0):
			this.game.getMatch().addHeroToCurrentTeam(new HeroLyndis(0,0));
			break;
		}
		if (this.game.getMatch().getCurrentTeam().getNbHero() == this.game.getMatch().getMode().getNbMaxHero()){
			this.game.setState(TEAMMENU);
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	public void cancel(){
		this.game.destroyMatch();
		this.game.setState(MAINMENU);
	}

	@Override
	public void moveCursorUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveCursorDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveCursorRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveCursorLeft() {
		// TODO Auto-generated method stub
		
	}

}
