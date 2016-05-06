package gameStates.modes;

public class DeathMatch extends Mode{
	
	public DeathMatch() {
		this.nbMaxSoldier = 1;
		this.nbMaxTeam = 2;
		this.nbMaxHero = 1;
	}
	
	public boolean isWon(){
		return true;
	}
}
