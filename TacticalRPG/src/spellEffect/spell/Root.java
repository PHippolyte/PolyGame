package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;

import spellEffect.effect.RootEffect;

public class Root extends spellEffect.Spell{

	public Root () {
		super(100, 1, 3);
		this.type = Type.CURSE;
		this.slashRange = 0;
		this.load("immobilisation.png");
	}

	@Override
	public void action(Character character, Hero caster) {
		character.setEffect(new RootEffect());
		
	}

}