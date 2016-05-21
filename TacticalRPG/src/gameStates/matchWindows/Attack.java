package gameStates.matchWindows;

import game.Cursor;
import gameStates.MatchState;
import gameObject.Character;
import gameObject.Character.TypeAttack;
import gameObject.Tile;

public class Attack extends StateMatch{
	private Character selectedCharacter;
	
	public Attack(MatchState matchState, Cursor cursor) {
		super(matchState, cursor);
		// TODO Auto-generated constructor stub
	}

	public int AttackPhys(Character ennemy, Tile tile){
		Tile posSelectedCharacter = this.matchState.getMatch().getMap().getTile(this.selectedCharacter.getX(), this.selectedCharacter.getY());
		int damage = 0;
		int randomPrec = (int)Math.random()*(101);
		if(randomPrec <= selectedCharacter.getPrecision()+posSelectedCharacter.getPrecision()){
			int randomDef = (int)Math.random()*(101);
			if(randomDef <= ennemy.getDodge()+tile.getDodge() || randomDef <= ennemy.getBlock()){
				int randomCrit = (int)Math.random()*(101);
				if(randomCrit <= selectedCharacter.getCritique()){
					damage =(selectedCharacter.getAttack()+posSelectedCharacter.getAttack()-ennemy.getDefense()-tile.getDefense())*2;
				}else{
					damage =selectedCharacter.getAttack()+posSelectedCharacter.getAttack()-ennemy.getDefense()-tile.getDefense();
				}
			}
		}
		return(damage);
	}
	
	
	public int AttackMagic(Character ennemy, Tile tile){
		Tile posSelectedCharacter = this.matchState.getMatch().getMap().getTile(this.selectedCharacter.getX(), this.selectedCharacter.getY());
		int damage = 0;
		int randomPrec = (int)Math.random()*(101);
		if(randomPrec <= selectedCharacter.getPrecisionMagic()){
			int randomDef = (int)Math.random()*(101);
			if(randomDef <= selectedCharacter.getResistance()){
				int randomCrit = (int)Math.random()*(101);
				if(randomCrit <= selectedCharacter.getCritique()){
					damage =(selectedCharacter.getAttackMagic()+posSelectedCharacter.getAttackMagic()-ennemy.getDefenseMagic()-tile.getDefenseMagic())*2;
				}else{
					damage =selectedCharacter.getAttackMagic()+posSelectedCharacter.getAttackMagic()-ennemy.getDefenseMagic()-tile.getDefenseMagic();
				}
			}
		}
		return(damage);
	}
	
	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		//fonction de calcul d'attaque
		Tile tile = this.matchState.getMatch().getMap().getTile(this.cursor.getX(), this.cursor.getY());
		Character ennemy = tile.getCharacter();
		if(!this.matchState.getMatch().getCurrentTeam().isAlly(ennemy)){//personnage selectionné est un allié
			if(this.selectedCharacter.getTypeAttack() == TypeAttack.PHYSICAL){
				ennemy.doDamage(AttackPhys(ennemy, tile));
			}else if(this.selectedCharacter.getTypeAttack() == TypeAttack.MAGICAL){
				ennemy.doDamage(AttackMagic(ennemy, tile));
			}
			
			this.selectedCharacter.setDone(true);//personnage devient inactif
			
			
			if (ennemy.getHealth() <= 0) {
				this.matchState.getMatch().removeCharacter(ennemy);
			}
			this.matchState.setCurrentState(IDLE);
		}else{
			
		}
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
