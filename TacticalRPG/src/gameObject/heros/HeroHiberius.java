package gameObject.heros;

import spellEffect.spell.DivineShield;
import spellEffect.spell.PowerHeal;
import spellEffect.spell.Reanimation;
import spellEffect.spell.ZoneHeal;
import gameObject.Hero;

public class HeroHiberius extends Hero{ //Heal
	
	public HeroHiberius(){
		super(0, 0, 0, 0, 5, 7, 0, 85, 10, 0, 90, 30, 5, 3, 15, 3, TypeAttack.HEAL, 500, new PowerHeal(), new ZoneHeal(), new DivineShield(), new Reanimation());
		this.name = "Hiberius";
		this.icone = "H";
	}
	
	public HeroHiberius(int x, int y) {
		super(x, y, 0, 0, 5, 7, 0, 85, 10, 0, 90, 30, 5, 3, 15, 3, TypeAttack.HEAL,500, new PowerHeal(), new ZoneHeal(), new DivineShield(), new Reanimation());
		this.name = "Hiberius";
		this.icone = "H";
	}
}
