package game;

import map.Map;
import team.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import gameObject.*;
import gameObject.Character;
import gameObject.Character.Type;
import gameObject.Tile.TypeTile;

import gameStates.modes.*;

public class Match{
	private int currentTeam;
	private int nbCurrentCharacter;
	
	private Map map;
	private Mode mode;
	private ArrayList<Team> teams;
	
	public Match(){
		this.teams = new ArrayList<Team>();
		this.currentTeam = 0;
		this.createMap();//PROVISOIRE!!
		
		
	}
	
	public void createMap(){
		this.map = new Map(30,30);
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
	
	public ArrayList<Team> getTeams(){
		return this.teams;
	}
	
	public void addHeroToCurrentTeam(Hero hero){
		this.nbCurrentCharacter++;
		this.getCurrentTeam().addHero(hero);
		hero.setTeam(this.getCurrentTeam());
	}
	public void addSoldierToCurrentTeam(Soldier soldier){
		//incrementation nombre soldat 
		this.nbCurrentCharacter++;
		//ajout du soldat a l'équipe courante
		this.getCurrentTeam().addSoldier(soldier);
		//sens inverse, associade l'équipe courante au soldat
		soldier.setTeam(this.getCurrentTeam());
	}
	
	public Map getMap(){
		return this.map;
	}
	
	public void removeCharacter(Character character){
		this.nbCurrentCharacter--;
		for (Team team : teams){
			if (character.getType() == Type.HERO) team.removeHero(character);
			else team.removeSoldier(character);
		}
		this.map.getTile(character.getX(), character.getY()).removeCharacter();
	}
	
	public Character[] getCharacters(){
		Character[] characters = new Character[this.nbCurrentCharacter];
		int i = 0;
		for (Team team : this.teams){
			for(Character c : team.getCharacters()){
				characters[i] = c;
				i++;
			}
		}
		return characters;
	}
	
	public void printTeams(){
		for (Team t : this.teams){
			System.out.println(t);
		}
	}
	
	public void placeTeams(){
		Random rand = new Random();
		boolean characterSet = false;
		HashMap<Integer, ArrayList<Integer>> tilesUsed = new HashMap<Integer, ArrayList<Integer>>();
		int posX, posY;
		int sizeTeamZoneX = 10;
		int sizeTeamZoneY = 10;
		
		for (Team team : this.teams){
			for (Character c : team.getCharacters()){
				while (!characterSet){
					posX = rand.nextInt(sizeTeamZoneX);
					posY = rand.nextInt(sizeTeamZoneY);
					
					if (!(tilesUsed.containsKey(posX)) ){
						tilesUsed.put(posX, new ArrayList<Integer>());
					}
					
					if (!(tilesUsed.get(posX).contains(posY))){
						if (!(this.map.getTile(posX, posY).getTypeTile() == TypeTile.WATER)){
							if (c.getTeam().getNum() == 0){
								this.map.setCharacterAtTile(c, posX, posY);
							}else {
								this.map.setCharacterAtTile(c, posX + this.map.getNbCols()-sizeTeamZoneX, posY + this.map.getNbRows()-sizeTeamZoneY);
							}
							tilesUsed.get(posX).add(posY);
							characterSet = true;
						}
					}
					
				}
				characterSet = false;
			}
		}
	}

	
	public int getNbTeam(){
		return this.teams.size();
	}
	public void startMatch(){
		this.placeTeams();
		this.setCurrentTeam(0);
	}
	
}
