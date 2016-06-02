package gameStates.matchWindows;

import java.util.HashSet;

import game.Cursor;
import gameObject.Character;
import gameObject.Hero;
import gameObject.Tile;
import gameStates.MatchState;

import spellEffect.Spell;

public class SpellState extends StateMatch {

	private Hero selectedHero;
	private HashSet<Tile> selectedTile;
	private HashSet<Tile> rangedTile;
	private Spell selectedSpell;
	
	public SpellState(MatchState matchState, Cursor cursor) {
		super(matchState, cursor);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
		
	}

	//FONCTION D'APPLICATION DU SORT
	public void doAction() {
		if (this.selectedSpell != null){
			if ((Math.abs(this.selectedHero.getX()-cursor.getX())+(Math.abs(this.selectedHero.getY()-cursor.getY()))) <= this.selectedSpell.getRange()){
				for (Tile t : this.selectedTile){
					Character c = t.getCharacter();
					if (c != null) {
						
						this.selectedSpell.action(c, this.selectedHero);
					}
					this.matchState.switchCancelSound();
					String spellname = this.selectedSpell.getClass().getSimpleName();
					System.out.println(this.selectedSpell.getClass().getSimpleName());
					if (spellname.equals("DodgeBoost") || spellname.equals("MoreAction") || spellname.equals("MagicBoost") || spellname.equals("RangeBoost")){
						this.matchState.getSoundManager().play("spellBoost");
					}else if (spellname.equals("LongAttack") || spellname.equals("UnstopableAttack")){
						this.matchState.getSoundManager().play("attack");
					}else if (spellname.equals("MultiAttack")){
						this.matchState.getSoundManager().play("attack");
						this.matchState.getSoundManager().play("attack");
						this.matchState.getSoundManager().play("attack");
						this.matchState.getSoundManager().play("attack");
					}else if (spellname.equals("PowerHeal") || spellname.equals("ZoneHeal")){
						this.matchState.getSoundManager().play("spellHeal");
					}else this.matchState.getSoundManager().play("spell"+spellname);
				}
				this.selectedHero.action();
				this.matchState.setCurrentState(IDLE);
			} else {
				this.matchState.getSoundManager().play("error");
				System.out.println("Not in range dude");
			}
		} else {
			System.out.println("Spell unavailable...for now <3");
		}
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		this.matchState.setCursorPosition(this.selectedHero.getX(), this.selectedHero.getY());
		this.matchState.setCurrentState(CHARACTERACTION);
	}

	@Override
	public void moveCursorUp() {
		// TODO Auto-generated method stub
		if (this.cursor.getY() > 0){
			this.cursor.moveUp();
			this.getSelectedTiles();
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
			this.getSelectedTiles();
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
			this.getSelectedTiles();
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
			this.getSelectedTiles();
			if (this.cursor.getX() < this.matchState.getScreen().getX1()){
				this.matchState.getScreen().moveLeft();
			}
		}
	}
	
	public void setSelectedHero(Hero hero){
		this.selectedHero= hero; 
	}
	
	public void setSpell(Spell spell){
		this.selectedSpell = spell;
		this.getSelectedTiles();
		this.rangedTile = this.matchState.getMatch().getMap().getRangeTile(this.selectedHero.getX(), this.selectedHero.getY(), this.selectedSpell.getRange());
	}
	
	private void getSelectedTiles(){
		this.selectedTile = this.matchState.getMatch().getMap().getRangeTile(this.cursor.getX(), this.cursor.getY(), this.selectedSpell.getSlashRange());
	}
	
	public HashSet<Tile> getTiles(){
		return this.selectedTile;
	}
	public HashSet<Tile> getRangeTiles(){
		return this.rangedTile;
	}

}
