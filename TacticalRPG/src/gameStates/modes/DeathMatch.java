package gameStates.modes;

import team.Team;

public class DeathMatch extends Mode{
	
	public DeathMatch() {
		this.nbMaxSoldier = 2;
		this.nbMaxTeam = 2;
		this.nbMaxHero = 1;
	}
	
	public boolean isWon(){
		boolean won = true;
		for (Team team : this.match.getTeams()){
			if (team.getCharacters().size() != 0 && team.getNum() != this.match.getCurrentTeam().getNum()){
				won = false;
			}
		}
		return won;
	}
}
