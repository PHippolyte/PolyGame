package gameStates.menus;

import game.Cursor;
import game.Game;
import gameObject.Hero;
import gameObject.heros.*;

public class HeroMenu extends Menu{
	private int[][] heros;
	private int nbColHero;
	private int nbRowHero;

	public HeroMenu(Game game, Cursor cursor) {
		super(game, cursor);
		// TODO Auto-generated constructor stub
		this.addHero();
		
	}
	
	private void addHero(){
		int num = 0;
		this.createHerosArray(9);
		for (int i=0; i<this.nbColHero; i++){
			for (int j=0; i<this.nbRowHero; i++){
				this.heros[i][j] = num;
				num++;
			}
		}
	}
	

	private void createHerosArray(int i){
		int n = 1;
		while (n*n < i) n++;
		
		this.heros = new int[n][n];
		this.nbButton = i;
		this.nbColHero = n;
		this.nbRowHero = n;
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
		int numHero = this.heros[this.cursor.getX()][this.cursor.getY()];
		
		switch(numHero){
		case(0):
			this.game.getMatch().addHeroToCurrentTeam(new HeroLyndis());
			break;
		}
		
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
		if (this.cursor.getY() > 0){
			this.cursor.moveUp();
		} else {
			this.cursor.setY(this.nbRowHero-1);
		}
		this.setChanged();
		this.notifyObservers();
		
	}


	@Override
	public void moveCursorDown() {
		// TODO Auto-generated method stub
		if (this.cursor.getY() < this.nbRowHero-1){
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
		if (this.cursor.getX() < this.nbColHero-1){
			this.cursor.moveRight();
		} else {
			this.cursor.setX(0);
		}
		this.setChanged();
		this.notifyObservers();
	}


	@Override
	public void moveCursorLeft() {
		// TODO Auto-generated method stub
		if (this.cursor.getX() > 0){
			this.cursor.moveLeft();
		} else {
			this.cursor.setX(this.nbColHero-1);
		}
		this.setChanged();
		this.notifyObservers();
	}

	public int getNbCol() {
		// TODO Auto-generated method stub
		return this.nbColHero;
	}

	public int getNbRow() {
		// TODO Auto-generated method stub
		return this.nbRowHero;
	}

	public void setCursorPosition(int x, int y) {
		this.cursor.setPosition(x, y);
		this.setChanged();
		this.notifyObservers();
	}

}
