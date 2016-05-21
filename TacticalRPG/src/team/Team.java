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
	
	private boolean done;
	
	public Team(int i){
		this.done = true;
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
	
	public void setTeamDone(boolean b){
		this.done = b;
		for (Character c : this.team){
			c.setDone(b);
		}
	}
	
	public boolean getDone(){
		return this.done;
	}
	
	public boolean isDone(){
		boolean done = true;
		for (Character c : this.team){
			if (c.getDone() == false){
				done = false;
			}
		}
		return done;
	}
	
	public void udpdate(){
		this.done = this.isDone();
	}
	
	public String toString(){
		String str = "Team "+ (this.num+1)+" :\n";
		for (Character character : this.team){
			str += character.toString()+"\n";
		}
		return str;
	}
}
