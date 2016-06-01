package spellEffect.spell;


import gameObject.Character;
import gameObject.Hero;
import spellEffect.Spell;
import spellEffect.effect.LessActionEffect;

public class LessAction extends Spell{

	public LessAction() {
		super(300, 0, 0);	
		this.type = Type.CURSE;
		this.slashRange = 0;
	}

	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.setEffect(new LessActionEffect());
		
	}

}