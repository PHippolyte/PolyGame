package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;
import spellEffect.effect.DivineShieldEffect;
import spellEffect.Spell;


public class DivineShield extends Spell{

	public DivineShield() {
		super(250, 0, 1);
		this.type = Type.BLESSING;
		this.slashRange = 0;
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.setEffect(new DivineShieldEffect());
		
	}
	
}