package spellEffect.spell;


import spellEffect.Effect;
import spellEffect.effect.DodgeBoostEffect;

public class DodgeBoost extends spellEffect.Spell{

	public DodgeBoost () {
		super(150, 0, 0);
	}
	
	void dodge(gameObject.Character character){
		Effect effect = new DodgeBoostEffect(character);
		((DodgeBoostEffect) effect).dodge();
	}

}