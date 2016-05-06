package game;

import map.Map;
import team.Team;

import java.util.ArrayList;

import gameObject.*;
import gameStates.modes.*;

public class Match{
	private int currentTeam;
	
	private Map map;
	private Mode mode;
	private ArrayList<Team> teams;
	
	public Match(){
		this.teams = new ArrayList<Team>();
		this.currentTeam = 0;
		this.createMap();//PROVISOIRE!!
	}
	
	public void createMap(){
		this.map = new Map(10,10);
	}
	
	public Mode getMode(){
		return this.mode;
	}
	
	public void setMode(Mode mode){
		this.mode = mode;
		for (int i=0; i <this.mode.getNbMaxTeam(); i++){
			this.teams.add(new Team(i));
		}
	}
	public void setCurrentTeam(int i){
		this.currentTeam = i;
	}
	
	public Team getCurrentTeam(){
		return this.teams.get(this.currentTeam);
	}
	
	public void setNextTeam(){
		if (this.currentTeam != this.getNbTeam()-1){
			this.currentTeam += 1;
		} else {
			this.currentTeam = 0;
		}
	}
	
	//a revoir! pour une meilleur étape de placement des personages
	//c'est que du brouillon la
	public void addHeroToCurrentTeam(Hero hero){
		this.getCurrentTeam().addHero(hero);
		this.map.getTile(hero.getX(), hero.getY()).setCharacter(hero);
	}
	public void addSoldierToCurrentTeam(Soldier soldier){
		this.getCurrentTeam().addSoldier(soldier);
		this.map.getTile(soldier.getX(), soldier.getY()).setCharacter(soldier);
	}
	
	public Map getMap(){
		return this.map;
	}
	
	public int getNbTeam(){
		return this.teams.size();
	}
	public void startMatch(){
		this.setCurrentTeam(0);
	}
	
}
