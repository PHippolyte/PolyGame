package gameObject.soldiers;

import gameObject.Soldier;

public class Sword extends Soldier {
	public Sword(){
		super();
	}
		
	public Sword(int x, int y) {
		super(x, y, 8, 0, 5, 5, 85, 0, 10, 0, 20, 15, 5, 1, 11, 0, TypeAttack.PHYSICAL);
		//this.load("ressources/Heros/Lyndis.png");
		this.name = "Sword";
		this.icone = "s";
	}
}
