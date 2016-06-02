package gameStates.matchWindows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import game.Cursor;
import gameStates.MatchState;
import gameObject.Character;
import gameObject.Character.TypeAttack;
import gameObject.Tile;

public class Attack extends StateMatch{
	private Character selectedCharacter;
	private HashSet<Tile> attackTiles;
	private ArrayList<Character> attackChar;
	private int currentChar;
	
	public Attack(MatchState matchState, Cursor cursor) {
		super(matchState, cursor);
		// TODO Auto-generated constructor stub
		currentChar = 0;
	}

	public int AttackPhys(Character ennemy, Tile tile){
		Tile posSelectedCharacter = this.matchState.getMatch().getMap().getTile(this.selectedCharacter.getX(), this.selectedCharacter.getY());
		Random rand = new Random();
		matchState.getSoundManager().play("attack");
		int damage = 0;
		int randomPrec = rand.nextInt(100);
		System.out.println("prec : "+randomPrec);

		if(randomPrec <= selectedCharacter.getPrecision()+posSelectedCharacter.getPrecision()){
			int randomDef = rand.nextInt(100);
			System.out.println("def : "+randomDef);

			if(randomDef >= ennemy.getDodge()+tile.getDodge() || randomDef >= ennemy.getBlock()){
				int randomCrit = rand.nextInt(100);
				if(randomCrit <= selectedCharacter.getCritique()){
					System.out.println("Critique!");
					damage =(selectedCharacter.getAttack()+posSelectedCharacter.getAttack()-ennemy.getDefense()-tile.getDefense())*2;
				}else{
					damage =selectedCharacter.getAttack()+posSelectedCharacter.getAttack()-ennemy.getDefense()-tile.getDefense();
				}
			}
		}
		System.out.println("Damage : "+damage);
		if (damage == 0) damage = 1;
		return(damage);
	}
	
	
	public int AttackMagic(Character ennemy, Tile tile){
		Tile posSelectedCharacter = this.matchState.getMatch().getMap().getTile(this.selectedCharacter.getX(), this.selectedCharacter.getY());
		Random rand = new Random();
		matchState.getSoundManager().play("mattack");
		int damage = 0;
		int randomPrec = rand.nextInt(100);
		
		if(randomPrec <= selectedCharacter.getPrecisionMagic()){
			int randomDef = rand.nextInt(100);
			if(randomDef >= ennemy.getResistance()){
				int randomCrit = rand.nextInt(100);
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
	
	private ArrayList<Character> getAttackCharacter(HashSet<Tile> t){
		ArrayList<Character> a = new ArrayList<Character>();
		for (Tile ct : t){
			Character c = ct.getCharacter();
			if (c != null){
				if (!this.selectedCharacter.getTeam().isAlly(c)){
					a.add(c);
				}
			}
		}
		return a;
	}

	@Override
	public void doAction() {
		
		if (this.attackChar.size() != 0){
			//fonction de calcul d'attaque
			Tile tile = this.matchState.getMatch().getMap().getTile(this.cursor.getX(), this.cursor.getY());
			if (this.attackTiles.contains(tile)){
				Character ennemy = tile.getCharacter();
				if(!this.matchState.getMatch().getCurrentTeam().isAlly(ennemy)){//personnage selectionné est un allié
					if(this.selectedCharacter.getTypeAttack() == TypeAttack.PHYSICAL){
						ennemy.doDamage(AttackPhys(ennemy, tile));
					}else if(this.selectedCharacter.getTypeAttack() == TypeAttack.MAGICAL){
						ennemy.doDamage(AttackMagic(ennemy, tile));
					}
					
					this.selectedCharacter.action();//personnage s'épuise
					if (ennemy.getHealth() <= 0) {
						this.matchState.getMatch().removeCharacter(ennemy);
					}
					this.matchState.setCurrentState(IDLE);
				}else{
					
				}
				System.out.println(ennemy.getName()+" : "+ennemy.getHealth()+"/"+ennemy.getMaxHealth());
			}
		} else {
			this.matchState.setCurrentState(CHARACTERACTION);
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
		/*
		if (this.cursor.getY() > 0){
			this.cursor.moveUp();
			if (this.cursor.getY() < this.matchState.getScreen().getY1()){
				this.matchState.getScreen().moveUp();
			}
		}
		*/
		this.moveCursorLeft();
	}

	@Override
	public void moveCursorDown() {
		/*
		if (this.cursor.getY() < this.matchState.getMatch().getMap().getNbRows()-1){
			this.cursor.moveDown();
			if (this.cursor.getY() > this.matchState.getScreen().getY2()){
				this.matchState.getScreen().moveDown();
			}
		}
		*/
		this.moveCursorRight();
	}

	@Override
	public void moveCursorRight() {
		if (this.attackChar.size() != 0){
			if (this.currentChar == this.attackChar.size()-1){
				currentChar = 0;
			} else {
				currentChar ++;
			}
			this.setCursorOnCurrentCharacter();
		}
	}

	@Override
	public void moveCursorLeft() {
		// TODO Auto-generated method stub
		/*
		if (this.cursor.getX() > 0){
			this.cursor.moveLeft();
			if (this.cursor.getX() < this.matchState.getScreen().getX1()){
				this.matchState.getScreen().moveLeft();
			}
		}
		*/
		if (this.attackChar.size() != 0){
			if (this.currentChar == 0){
				currentChar = this.attackChar.size()-1;
			} else {
				currentChar --;
			}
			this.setCursorOnCurrentCharacter();
		}
	}
	
	private void setCursorOnCurrentCharacter(){
		this.cursor.setPosition(this.attackChar.get(currentChar).getX(), this.attackChar.get(currentChar).getY());
	}
	
	public void init(Character character){
		this.selectedCharacter = character;
		this.attackTiles = this.matchState.getMatch().getMap().getAttackTiles(character);
		this.attackChar = this.getAttackCharacter(this.attackTiles);
		
		if (this.attackChar.size() != 0){
			this.currentChar = 0;
			this.setCursorOnCurrentCharacter();
		}
	}
	
	public HashSet<Tile> getAttack(){
		return this.attackTiles;
	}

}
