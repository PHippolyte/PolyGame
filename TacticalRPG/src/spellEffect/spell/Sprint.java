package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;
import spellEffect.Effect;
import spellEffect.effect.SprintEffect;

public class Sprint extends spellEffect.Spell{
	

	public Sprint () {
		super(150, 0, 1);
		this.type = Type.BLESSING;
		this.slashRange = 0;
	}
	

	public void action(Character character, Hero caster) {
		character.setEffect(new SprintEffect());
		
	}

}