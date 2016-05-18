package gameObject.soldiers;

import gameObject.Soldier;

public class KnightArcher extends Soldier {

	public KnightArcher() {
		// TODO Auto-generated constructor stub
	}

	public KnightArcher(int x, int y) {
		super(x, y,  9, 0, 4, 5, 65, 0, 0, 0, 20, 10, 8, 3, 10, 0, TypeAttack.PHYSICAL);
		this.name = "KnightArcher";
		this.icone = "ka";
	}

}