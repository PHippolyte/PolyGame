package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;
import spellEffect.effect.MagicBoostEffect;

public class MagicBoost extends spellEffect.Spell{

	public MagicBoost () {
		super(150, 0, 1);	
		this.type = Type.BLESSING;
		this.slashRange = 0;
	}

	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.setEffect(new MagicBoostEffect());
		
	}

}