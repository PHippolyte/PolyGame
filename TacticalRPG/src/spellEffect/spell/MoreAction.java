package spellEffect.spell;


import gameObject.Character;
import gameObject.Hero;
import spellEffect.effect.MoreActionEffect;

public class MoreAction extends spellEffect.Spell{

	public MoreAction() {
		super(300, 0, 1);	
		this.type = Type.BLESSING;
		this.slashRange = 0;
	}
	@Override
	public void action(Character character, Hero caster) {
		// TODO Auto-generated method stub
		character.setEffect(new MoreActionEffect());
	}

}