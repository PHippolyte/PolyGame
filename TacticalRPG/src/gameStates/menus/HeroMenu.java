package gameStates.menus;

import java.util.HashMap;

import game.Cursor;
import game.Game;
import gameObject.Hero;
import gameObject.heros.*;

public class HeroMenu extends Menu{
	private int nbColHero;
	private int nbRowHero;

	private HashMap<Integer,Hero> h;
	
	public HeroMenu(Game game, Cursor cursor) {
		super(game, cursor);
		
		//ENREGISTREMENT DE TOUT LES HEROS
		this.h = new HashMap<Integer,Hero>();
		
		//AJOUTS DES HEROS
		this.h.put(0, new HeroLyndis());
		this.h.put(1, new HeroDagharr());
		this.h.put(2, new HeroHiberius());
		this.h.put(3, new HeroIsylwenn());
		this.h.put(4, new HeroOlgred());
		
		this.nbButton = this.h.size();
		
		this.nbColHero = 3;
		this.nbRowHero = 3;
	}

	
	@Override
	public void initState() {
		// TODO Auto-generated method stub
		this.cursor.setPosition(0, 0);
		this.setChanged();
		this.notifyObservers();
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		int numHero = this.cursor.getX()+this.cursor.getY()*this.nbColHero;
		int numTeam = this.game.getMatch().getCurrentTeam().getNum()+1;
		this.getSoundManager().play("enter");
		
		Hero hero = null;
		switch(numHero){
		case(0):
			hero = new HeroLyndis();
			hero.load("ressources/Heros/Lyndis"+numTeam+".png");
			break;
			
		case(1):
			hero = new HeroDagharr();
			hero.load("ressources/Heros/Dagharr"+numTeam+".png");
			break;
			
		case(2):
			hero = new HeroHiberius();
			hero.load("ressources/Heros/Hiberius"+(numTeam-1)+".png");
			break;
			
		case(3):
			hero = new HeroIsylwenn();
			hero.load("ressources/Heros/Isylwenn"+numTeam+".png");
			break;
			
		case(4):
			hero = new HeroOlgred();
			hero.load("ressources/Heros/Olgred"+numTeam+".png");
			break;
		}
		this.game.getMatch().addHeroToCurrentTeam(hero);
		
		//verification de la condition de fin
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
		this.getSoundManager().play("cursor");
		int num = this.cursor.getX()+(this.nbColHero*(this.cursor.getY()-1));
		
		if (num >= 0){
			this.cursor.moveUp();
		} else {
			int aimedY = cursor.getY()+1;
			while (this.cursor.getX()+(this.nbColHero*aimedY) > this.h.size()-1) aimedY--;
			this.cursor.setY(aimedY);
		}
		
		this.setChanged();
		this.notifyObservers();
		
	}


	@Override
	public void moveCursorDown() {
		this.getSoundManager().play("cursor");
		int num = this.cursor.getX()+(this.nbColHero*(this.cursor.getY()+1));
		
		if (num < this.h.size()){
			this.cursor.moveDown();
		} else this.cursor.setY(0);
		
		this.setChanged();
		this.notifyObservers();
	}


	@Override
	public void moveCursorRight() {
		this.getSoundManager().play("cursor");
		int num = this.cursor.getX()+(this.nbColHero*(this.cursor.getY()))+1;
		
		if (this.cursor.getX() < this.nbColHero-1 && num < this.h.size()){
			this.cursor.moveRight();
		} else {
			this.cursor.setX(0);	
		}
		
		this.setChanged();
		this.notifyObservers();
	}


	@Override
	public void moveCursorLeft() {
		this.getSoundManager().play("cursor");

		if (this.cursor.getX() > 0){
			this.cursor.moveLeft();
		} else {
			int aimedX = cursor.getX()+this.nbColHero-1;
			while (aimedX+(this.nbColHero*this.cursor.getY()) > this.h.size()-1) aimedX--;
			this.cursor.setX(aimedX);
		}
		this.setChanged();
		this.notifyObservers();
	}

	public int getNbCol() {
		return this.nbColHero;
	}

	public int getNbRow() {
		return this.nbRowHero;
	}

	public void setCursorPosition(int x, int y) {
		this.cursor.setPosition(x, y);
		this.setChanged();
		this.notifyObservers();
	}

}
