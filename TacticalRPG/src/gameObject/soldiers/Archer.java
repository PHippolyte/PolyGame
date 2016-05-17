package gameObject.soldiers;

import gameObject.Soldier;

public class Archer extends Soldier{

	public Archer(){
		super();
		this.setParemeters();
	}
	
	
	public Archer(int x, int y) {
		super(x, y);
		this.setParemeters();
	}
	
	private void setParemeters(){
		this.load("ressources/Heros/Lyndis.png");
		this.name = "Archer";
		this.maxHealth = 18;
		this.health = 18;
		this.attack = 5;
		this.defense = 2;
		this.energy = 5;
		this.range = 3;
		this.icone = "a";
	}
}
