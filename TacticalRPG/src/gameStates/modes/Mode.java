package gameStates.modes;

public abstract class Mode {
	protected int nbMaxTeam;
	protected int nbMaxSoldier;
	protected int nbMaxHero;
	
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
	
}
