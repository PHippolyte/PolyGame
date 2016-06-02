package spellEffect.spell;

import spellEffect.Spell;

import gameObject.Character;
import gameObject.Hero;
import spellEffect.effect.DodgeBoostEffect;

public class DodgeBoost extends Spell{

	public DodgeBoost () {
		super(150, 0, 1);
		this.type = Type.BLESSING;
		this.slashRange = 0;
	}

	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.setEffect(new DodgeBoostEffect());
		
	}

}