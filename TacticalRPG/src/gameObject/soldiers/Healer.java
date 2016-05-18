package gameObject.soldiers;

import gameObject.Soldier;

public class Healer extends Soldier {
	
	public Healer(){
		super(0, 0, 0, 0, 4, 6, 0, 70, 5, 0, 80, 20, 5, 3, 9, 3, TypeAttack.HEAL);
		this.load("ressources/soldier/Healer.png");
		this.name = "Healer";
		this.icone = "h";
	}
		
	public Healer(int x, int y) {
		super(x, y, 0, 0, 4, 6, 0, 70, 5, 0, 80, 20, 5, 3, 9, 3, TypeAttack.HEAL);
		this.load("ressources/soldier/Healer.png");
		this.name = "Healer";
		this.icone = "h";
	}
}
