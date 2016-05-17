package gameStates.menus;

import java.util.ArrayList;

import game.Cursor;
import game.Game;
import gameObject.Soldier;
import gameObject.soldiers.*;

public class TeamMenu extends Menu{
	private ArrayList<Soldier> soldiers;
	
	public TeamMenu(Game game, Cursor cursor) {	
		super(game, cursor);
		// TODO Auto-generated constructor stub
		this.soldiers = new ArrayList<Soldier>();
		
		//ajout des soldats
		this.soldiers.add(new Archer(0,0));
		
		this.nbButton = this.soldiers.size();
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
			System.out.println("Added Soldier\n"+this.game.getMatch().getCurrentTeam());
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
