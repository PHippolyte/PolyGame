package spellEffect.spell;

import gameObject.Character;

import spellEffect.Effect;
import spellEffect.effect.MagicBoostEffect;

public class MagicBoost extends spellEffect.Spell{

	public MagicBoost () {
		super(150, 0, 0);	
	}
	
	void dodge(Character character){
		Effect effect = new MagicBoostEffect(character);
		((MagicBoostEffect) effect).boost();
	}

}