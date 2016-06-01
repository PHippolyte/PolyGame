package spellEffect.spell;

import gameObject.Character;
import spellEffect.Effect;
import spellEffect.Spell.TypeSpell;
import spellEffect.effect.MagicBoostEffect;

public class MagicBoost extends spellEffect.Spell{

	public MagicBoost () {
		super(150, 0, 0, TypeSpell.MAGICBOOST);	
	}
	
	public void magic(Character character){
		Effect effect = new MagicBoostEffect(character);
		((MagicBoostEffect) effect).boost();
	}

}