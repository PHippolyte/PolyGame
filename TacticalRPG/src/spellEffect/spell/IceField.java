package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;
import spellEffect.Spell;
import spellEffect.effect.SlowEffect;

public class IceField extends Spell{

	public IceField() {
		super(250, 0, 0);
		this.type = Type.CURSE;
		this.slashRange = 2;
	}

	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.setEffect(new SlowEffect());
	}

}