package spellEffect.spell;

import spellEffect.Effect;
import spellEffect.effect.DivineShieldEffect;

public class DivineShield extends spellEffect.Spell{

	public DivineShield() {
		super(250, 0, 0);
		// TODO Auto-generated constructor stub
		
	}
	
	void shield(gameObject.Character character){
		Effect effect = new DivineShieldEffect(character);
		((DivineShieldEffect) effect).shield();
	}
	
}