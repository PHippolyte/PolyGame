package team;

import gameObject.Character;
import gameObject.Hero;
import gameObject.Soldier;

import java.util.ArrayList;

public class Team {
	private ArrayList<Character> team;
	private Player player;
	private int nbHero;
	private int nbSoldier;
	private int num;
	
	public Team(int i){
		this.num = i;
		this.team = new ArrayList<Character>();
	}
	
	private void addCharacter(Character character){
		this.team.add(character);
	}
	
	public void addHero(Hero hero){
		this.nbHero++;
		this.addCharacter(hero);
	}
	
	public void addSoldier(Soldier soldier){
		this.nbSoldier++;
		this.addCharacter(soldier);
	}
	
	public void removeHero(Character character){
		this.team.remove(character);
		this.nbHero--;
	}
	public void removeSoldier(Character character){
		this.team.remove(character);
		this.nbSoldier--;
	}
	
	public boolean isAlly(Character character){
		return this.team.contains(character);
	}
	
	public void setPlayer(Player player){
		this.player = player;
	}
	public Player getPlayer(){
		return this.player;
	}
	
	public int getNbHero(){
		return this.nbHero;
	}
	public int getNbSoldier(){
		return this.nbSoldier;
	}
	
	public int getNum(){
		return this.num;
	}
	
	public ArrayList<Character> getCharacters(){
		return this.team;
	}
	
	public String toString(){
		String str = "Team "+ (this.num+1)+" :\n";
		for (Character character : this.team){
			str += character.toString()+"\n";
		}
		return str;
	}
}
