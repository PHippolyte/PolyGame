package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Effect;
import spellEffect.effect.RangeBoostEffect;

public class RangeBoost extends spellEffect.Spell{

	public RangeBoost () {
		super(150, 0, 0);
		
	}
	
	void dodge(Character character){
		Effect effect = new RangeBoostEffect(character);
		((RangeBoostEffect) effect).range();
	}

}