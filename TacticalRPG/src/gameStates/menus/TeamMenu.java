package gameStates.menus;

import java.awt.image.BufferedImage;

import java.util.HashMap;

import game.Cursor;
import game.Game;
import gameObject.Soldier;
import gameObject.soldiers.*;

public class TeamMenu extends Menu{
	private HashMap<Integer,Soldier> soldiers;
	
	public TeamMenu(Game game, Cursor cursor) {	
		super(game, cursor);
		//AJOUT DES SOLDATS
		this.soldiers = new HashMap<Integer,Soldier>();
		
		this.soldiers.put(0,new Archer());
		this.soldiers.put(1,new Daguer());
		this.soldiers.put(2,new Healer());
		this.soldiers.put(3,new Knight());
		this.soldiers.put(4,new KnightArcher());
		this.soldiers.put(5,new Mage());
		this.soldiers.put(6,new Spear());
		this.soldiers.put(7,new Sword());
		this.soldiers.put(8,new Tank());
	
		this.nbButton = this.soldiers.size();
	}

	@Override
	public void initState() {
		// TODO Auto-generated method stub
		this.cursor.setPosition(0, 0);
		this.loadIcone();
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		Soldier soldier;
		int numTeam = this.game.getMatch().getCurrentTeam().getNum()+1;
		this.getSoundManager().play("enter");
		switch(this.cursor.getY()){
		case(0):
			soldier = new Archer();
			soldier.load("ressources/soldier/Archer"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			this.setChanged();
			break;
			
		case(1):
			soldier = new  Daguer();
			soldier.load("ressources/soldier/Daguer"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			this.setChanged();
			break;
			
		case(2):
			soldier = new Healer();
			soldier.load("ressources/soldier/Healer"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			this.setChanged();
			break;
			
		case(3):
			soldier = new Knight();
			soldier.load("ressources/soldier/Knight"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			this.setChanged();
			break;
		
		case(4):
			soldier = new KnightArcher();
			soldier.load("ressources/soldier/KnightArcher"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			this.setChanged();
			break;
		
		case(5):
			soldier = new Mage();
			soldier.load("ressources/soldier/Mage"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			this.setChanged();
			break;
		
		case(6):
			soldier = new Spear();
			soldier.load("ressources/soldier/Spear"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			this.setChanged();
			break;
		
		case(7):
			soldier = new Sword();
			soldier.load("ressources/soldier/Sword"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			this.setChanged();
			break;
		
		case(8):
			soldier = new Tank();
			soldier.load("ressources/soldier/Tank"+numTeam+".png");
			this.game.getMatch().addSoldierToCurrentTeam(soldier);
			this.setChanged();
			break;
		}
		this.notifyObservers();
		
		if (this.game.getMatch().getCurrentTeam().getNbSoldier() == this.game.getMatch().getMode().getNbMaxSoldier()){
			if (this.game.getMatch().getCurrentTeam().getNum() != this.game.getMatch().getNbTeam()-1){
				this.game.getMatch().setNextTeam();
				this.game.setState(HEROMENU);
			} else {
				//match finalization
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
	
	private void loadIcone(){
		for(int i=0; i<this.soldiers.size(); i++){
			Soldier s = this.soldiers.get(i);
			s.load("ressources/soldier/"+s.getName()+(this.game.getMatch().getCurrentTeam().getNum()+1)+".png");
		}
	}
	
	public BufferedImage[] getIcones(){
		BufferedImage[] icones = new BufferedImage[this.soldiers.size()];
		for (int i=0; i<this.soldiers.size(); i++){
			icones[i] = this.soldiers.get(i).getImage();
		}
		return icones;
	}
}
