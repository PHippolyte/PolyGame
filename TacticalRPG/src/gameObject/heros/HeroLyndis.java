package gameObject.heros;

import spellEffect.spell.MultiArrow;
import spellEffect.spell.RangeBoost;
import spellEffect.spell.Root;
import gameObject.Hero;

public class HeroLyndis extends Hero{ //Archer
	
	public HeroLyndis(){
		super(0, 0, 11, 0, 5, 6, 85, 0, 20, 0, 20, 20, 6, 3, 15, 0, TypeAttack.PHYSICAL,300, new Root(), new MultiArrow(), new RangeBoost(), new LessAction());
		this.name = "Lyndis";
		this.icone = "L";
	}
	
	public HeroLyndis(int x, int y) {
		super(x, y, 8, 0, 4, 5, 70, 0, 10, 0, 10, 10, 6, 1, 10, 0, TypeAttack.PHYSICAL,50, null, null, null, null);
		this.name = "Lyndis";
		this.icone = "L";
	}
}
