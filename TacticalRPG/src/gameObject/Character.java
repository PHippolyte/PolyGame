package gameObject;

import team.Team;

public abstract class Character extends MapObject{
	public enum Type {SOLDIER, HERO}
	
	protected Team team;
	protected Type type;
	
	protected int energy;
	
	protected int maxHealth;
	protected int health;
	
	public Character(){
		
	}
	
	public Character(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return this.name+" ("+this.x+","+this.y+") , TEAM "+(this.team.getNum()+1)+", LIFE "+this.health+"/"+this.maxHealth+", ATT "+this.attack+", DEF "+this.defense+", NRG "+this.energy+", RNG "+this.range;
	}
	
	public void setHealth(int health){
		if (health > 0){
			if (health < this.maxHealth){
				this.health = health;
			} else {
				this.health = this.maxHealth;
			}
		}
	}
	
	public void doDamage(int damage){
		this.health -= damage;
		if (this.health < 0){
			this.health = 0;
		}
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public Team getTeam(){
		return this.team;
	}
	
	public void setTeam(Team team){
		this.team = team;
		System.out.println("Team changed"+this);
	}
	
	public Type getType(){
		return this.type;
	}
}
