package gameObject.soldiers;

import gameObject.Soldier;

public class Daguer extends Soldier {

	public Daguer() {
		// TODO Auto-generated constructor stub
	}

	public Daguer(int x, int y) {
		super(x, y,  6, 0, 4, 5, 90, 0, 40, 0, 10, 40, 6, 1, 8, 0, TypeAttack.PHYSICAL);
		this.name = "Daguer";
		this.icone = "d";
	}

}