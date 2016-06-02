package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;

import java.util.List;

import spellEffect.Effect;
import spellEffect.effect.RangeBoostEffect;

public class RangeBoost extends spellEffect.Spell{

	public RangeBoost () {
		super(150, 0, 0);
		this.type = Type.BLESSING;
		this.slashRange = 0;
	}
	
	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.setEffect(new RangeBoostEffect());
	}

}