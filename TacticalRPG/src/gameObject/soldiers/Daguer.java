package gameObject.soldiers;

import gameObject.Soldier;

public class Daguer extends Soldier {

	public Daguer() {
		super(0, 0,  6, 0, 4, 5, 90, 0, 40, 0, 10, 40, 6, 1, 8, 0, TypeAttack.PHYSICAL);
		this.load("ressources/soldier/Daguer.png");
		this.name = "Daguer";
		this.icone = "d";
	}

	public Daguer(int x, int y) {
		super(x, y,  6, 0, 4, 5, 90, 0, 40, 0, 10, 40, 6, 1, 8, 0, TypeAttack.PHYSICAL);
		this.load("ressources/soldier/Daguer.png");
		this.name = "Daguer";
		this.icone = "d";
	}

}