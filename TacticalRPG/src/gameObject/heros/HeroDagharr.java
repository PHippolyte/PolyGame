package gameObject.heros;

import spellEffect.spell.DodgeBoost;
import spellEffect.spell.MoreAction;
import spellEffect.spell.MultiAttack;
import spellEffect.spell.UnstopableAttack;
import gameObject.Hero;

public class HeroDagharr extends Hero{ //Sword
	
	public HeroDagharr(){
		super(0, 0, 10, 0, 6, 6, 85, 0, 15, 20, 35, 15, 5, 1, 16, 0, TypeAttack.PHYSICAL,300, new UnstopableAttack(), new MultiAttack(), new DodgeBoost(), new MoreAction());
		this.name = "Dagharr";
		this.icone = "D";
	}
	
	public HeroDagharr(int x, int y) {
		super(x, y,  10, 0, 6, 6, 85, 0, 15, 20, 35, 15, 5, 1, 16, 0, TypeAttack.PHYSICAL,300, new UnstopableAttack(), new MultiAttack(), new DodgeBoost(), new MoreAction());
		this.name = "Dagharr";
		this.icone = "D";
	}
}
