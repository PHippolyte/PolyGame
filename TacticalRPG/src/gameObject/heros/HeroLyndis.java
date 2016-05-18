package gameObject.heros;

import gameObject.Hero;

public class HeroLyndis extends Hero{
	
	public HeroLyndis(){
		super();
		this.setParameters();
	}
	
	public HeroLyndis(int x, int y) {
		super(x, y);
		this.setParameters();
	}
	
	private void setParameters(){
		this.load("ressources/Heros/Lyndis.png");
		this.name = "Lord Lyndis";
		this.maxHealth = 49;
		this.health = 49;
		this.attack = 18;
		this.defense = 25;
		this.energy = 9;
		this.range = 1;
		this.icone = "L";
	}
}
