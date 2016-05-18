package gameObject.soldiers;

import gameObject.Soldier;

public class Mage extends Soldier {
	
	public Mage(){
		super();
	}
		
	public Mage(int x, int y) {
		super(x, y, 0, 8, 4, 6, 0, 70, 5, 0, 80, 20, 5, 3, 9, 0, TypeAttack.MAGICAL);
		//this.load("ressources/Heros/Lyndis.png");
		this.name = "Mage";
		this.icone = "m";
	}
}
