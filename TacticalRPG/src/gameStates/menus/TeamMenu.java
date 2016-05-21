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
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		Soldier soldier;
		int numTeam = this.game.getMatch().getCurrentTeam().getNum()+1;
		switch(this.cursor.getY()){
		case(0):
			soldier = new Archer();
			soldier.load("ressources/soldier/Archer"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			break;
			
		case(1):
			soldier = new  Daguer();
			soldier.load("ressources/soldier/Daguer"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			break;
			
		case(2):
			soldier = new Healer();
			soldier.load("ressources/soldier/Healer"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			break;
			
		case(3):
			soldier = new Knight();
			//soldier.load("ressources/soldier/Archer.png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			break;
		
		case(4):
			soldier = new KnightArcher();
			//soldier.load("ressources/soldier/Archer.png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			break;
		
		case(5):
			soldier = new Mage();
			//soldier.load("ressources/soldier/Archer.png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			break;
		
		case(6):
			soldier = new Spear();
			//soldier.load("ressources/soldier/Archer.png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			break;
		
		case(7):
			soldier = new Sword();
			//soldier.load("ressources/soldier/Archer.png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			break;
		
		case(8):
			soldier = new Tank();
			//soldier.load("ressources/soldier/Archer.png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
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
		if (this.cursor.getY() == this.nbButton-1){
			this.cursor.setY(0);
		} else {
			this.cursor.moveDown();
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
