package gameObject.heros;

import spellEffect.spell.FireBall;
import spellEffect.spell.IceField;
import spellEffect.spell.MagicBoost;
import spellEffect.spell.Meteore;
import gameObject.Hero;

public class HeroIsylwenn extends Hero{ //Mage
	
	public HeroIsylwenn(){
		super(0, 0, 0, 10, 5, 7, 0, 80, 10, 0, 80, 30, 5, 3, 14, 0, TypeAttack.MAGICAL,500, new FireBall(), new IceField(), new MagicBoost(), new Meteore());
		this.name = "Isylwenn";
		this.icone = "I";
	}
	
	public HeroIsylwenn(int x, int y) {
		super(x, y,  0, 10, 5, 7, 0, 80, 10, 0, 80, 30, 5, 3, 14, 0, TypeAttack.MAGICAL,500, new FireBall(), new IceField(), new MagicBoost(), new Meteore());
		this.name = "Isylwenn";
		this.icone = "I";
	}
}
