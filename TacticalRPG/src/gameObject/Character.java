package gameObject;

import team.Team;

public abstract class Character extends MapObject{
	public enum Type {SOLDIER, HERO}
	public enum TypeAttack {PHYSICAL, MAGICAL, HEAL}
	
	protected Team team;
	protected Type type;
	protected TypeAttack typeAttack;
	
	protected int energy;
	
	protected int maxHealth;
	protected int health;
	
	protected int block;
	protected int critique;
	protected int heal;
	
	public Character(){
		
	}
	
	public Character(int x, int y, int attack, int attackMagic, int defense, int defenseMagic, int precision, int precisionMagic, int dodge, int block, int resistance, int critique, int energy, int range, int health, int heal, TypeAttack typeAttack){
		super(x, y);
		// TODO Auto-generated constructor stub
		this.attack = attack;
		this.attackMagic = attackMagic;
		this.defense = defense;
		this.defenseMagic = defenseMagic;
		this.precision = precision;
		this.precisionMagic = precisionMagic;
		this.dodge = dodge;
		this.block = block;
		this.resistance = resistance;
		this.critique = critique;
		this.energy = energy;
		this.range = range;
		this.maxHealth = health;
		this.heal = heal;
		this.typeAttack = typeAttack;
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
