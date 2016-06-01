package spellEffect.spell;


import spellEffect.Effect;
import spellEffect.Spell.TypeSpell;
import spellEffect.effect.DodgeBoostEffect;

public class DodgeBoost extends spellEffect.Spell{

	public DodgeBoost () {
		super(150, 0, 0, TypeSpell.DODGEBOOST);
	}
	
	public void dodge(gameObject.Character character){
		Effect effect = new DodgeBoostEffect(character);
		((DodgeBoostEffect) effect).dodge();
	}

}