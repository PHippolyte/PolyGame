package gameStates.modes;

import game.Match;

public abstract class Mode {
	protected int nbMaxTeam;
	protected int nbMaxSoldier;
	protected int nbMaxHero;
	
	protected Match match;
	
	public abstract boolean isWon();
	
	public int getNbMaxSoldier(){
		return this.nbMaxSoldier;
	}
	public int getNbMaxHero(){
		return this.nbMaxHero;
	}
	public int getNbMaxTeam(){
		return this.nbMaxTeam;
	}
	
	public void setMatch(Match match){
		this.match = match;
	}
	
}
