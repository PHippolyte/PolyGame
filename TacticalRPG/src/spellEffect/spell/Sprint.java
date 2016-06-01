package spellEffect.spell;

import gameObject.Character;
import spellEffect.Effect;
import spellEffect.effect.SprintEffect;

public class Sprint extends spellEffect.Spell{
	

	public Sprint () {
		super(150, 0, 0);
	}
	
	void dodge(Character character){
		Effect effect = new SprintEffect(character);
		((SprintEffect) effect).sprint();
	}

}