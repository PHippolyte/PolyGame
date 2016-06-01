package gameStates.matchWindows;

import java.awt.image.BufferedImage;

import game.Cursor;
import gameObject.Hero;
import gameStates.MatchState;
import spellEffect.Spell;

public class SpellSelection extends StateMatch{
	private int nbButton; 
	private int currentButton;
	private Hero selectedHero;
	
	public SpellSelection(MatchState matchState, Cursor cursor) {
		super(matchState, cursor);
		// TODO Auto-generated constructor stub
		this.nbButton = 4;
	}

	@Override
	public void initWindow() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doAction() {
		Spell spell = this.selectedHero.getSpell(this.currentButton);
		System.out.println(spell);
		this.matchState.getSpellState().setSelectedHero(this.selectedHero);
		this.matchState.getSpellState().setSpell(spell);
		this.matchState.setCurrentState(SPELLSTATE);
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		this.matchState.setCurrentState(CHARACTERACTION);
	}

	@Override
	public void moveCursorUp() {
		if (this.currentButton > 0){
			this.currentButton--;
		} else {
			this.currentButton = this.nbButton-1;
		}
	}


	@Override
	public void moveCursorDown() {
		// TODO Auto-generated method stub
		if (this.currentButton < this.nbButton-1){
			this.currentButton++;
		} else {
			this.currentButton = 0;
		}
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
	
	public void setHero(Hero hero){
		this.selectedHero = hero;
		this.currentButton = 0;
	}
	
	public int getCurrentButton(){
		return this.currentButton;
	}
	
	public BufferedImage[] getSpellsImage(){
		BufferedImage[] imgs = new BufferedImage[this.selectedHero.getNbSpells()];
		for (int i=0; i<imgs.length; i++){
			imgs[i] = this.selectedHero.getSpell(i).getNameImage();
		}
		return imgs;
	}
}
