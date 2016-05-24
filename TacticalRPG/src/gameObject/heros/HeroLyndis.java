package gameObject.heros;

import gameObject.Hero;

public class HeroLyndis extends Hero{
	
	public HeroLyndis(){
		super(0, 0, 8, 0, 4, 5, 70, 0, 10, 0, 10, 10, 6, 1, 10, 0, TypeAttack.PHYSICAL);
		this.load("ressources/Heros/Lyndis.png");
		this.name = "Lyndis";
		this.icone = "L";
	}
	
	public HeroLyndis(int x, int y) {
		super(x, y, 8, 0, 4, 5, 70, 0, 10, 0, 10, 10, 6, 1, 10, 0, TypeAttack.PHYSICAL);
		this.load("ressources/Heros/Lyndis.png");
		this.name = "Lyndis";
		this.icone = "L";
	}
}
