package gameStates.menus;

import java.util.ArrayList;

import game.Cursor;
import game.Game;
import gameObject.Soldier;
import gameObject.soldiers.*;

public class TeamMenu extends Menu{
	
	public TeamMenu(Game game, Cursor cursor) {	
		super(game, cursor);
		this.nbButton = 9;
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
			this.game.getMatch().addSoldierToCurrentTeam(new Archer());
			break;
			
		case(1):
			this.game.getMatch().addSoldierToCurrentTeam(new Daguer());
			break;
			
		case(2):
			this.game.getMatch().addSoldierToCurrentTeam(new Healer());
			break;
			
		case(3):
			this.game.getMatch().addSoldierToCurrentTeam(new Knight());
			break;
		
		case(4):
			this.game.getMatch().addSoldierToCurrentTeam(new KnightArcher());
			break;
		
		case(5):
			this.game.getMatch().addSoldierToCurrentTeam(new Mage());
			break;
		
		case(6):
			this.game.getMatch().addSoldierToCurrentTeam(new Spear());
			break;
		
		case(7):
			this.game.getMatch().addSoldierToCurrentTeam(new Sword());
			break;
		
		case(8):
			this.game.getMatch().addSoldierToCurrentTeam(new Tank());
			break;
		}
		
		if (this.game.getMatch().getCurrentTeam().getNbSoldier() == this.game.getMatch().getMode().getNbMaxSoldier()){
			if (this.game.getMatch().getCurrentTeam().getNum() != this.game.getMatch().getNbTeam()-1){
				this.game.getMatch().setNextTeam();
				this.game.setState(HEROMENU);
			} else {
				//match finalization
				this.game.getMatch().printTeams();
				this.game.setState(MATCHSTATE);
				this.game.getMatch().startMatch();
			}
		}

		
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
