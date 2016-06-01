package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Effect;
import spellEffect.Spell.TypeSpell;
import spellEffect.effect.RangeBoostEffect;

public class RangeBoost extends spellEffect.Spell{

	public RangeBoost () {
		super(150, 0, 0, TypeSpell.RANGEBOOST);
		
	}
	
	public void rBoost(Character character){
		Effect effect = new RangeBoostEffect(character);
		((RangeBoostEffect) effect).range();
	}

}