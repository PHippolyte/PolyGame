package gameObject.heros;


import spellEffect.spell.Charge;
import spellEffect.spell.LongAttack;
import spellEffect.spell.Sprint;
import spellEffect.spell.Throws;
import gameObject.Hero;

public class HeroOlgred extends Hero{ //Knight
	
	public HeroOlgred(){
		super(0, 0, 10, 0, 6, 6, 80, 0, 0, 0, 35, 20, 8, 1, 15, 0, TypeAttack.PHYSICAL,300, new Throws(), new Charge(), new Sprint(), new LongAttack());
		this.name = "Olgred";
		this.icone = "O";
	}
	
	public HeroOlgred(int x, int y) {
		super(x, y,  10, 0, 6, 6, 80, 0, 0, 0, 35, 20, 8, 1, 15, 0, TypeAttack.PHYSICAL,300, new Throws(), new Charge(), new Sprint(), new LongAttack());
		this.name = "Olgred";
		this.icone = "O";
	}
}
