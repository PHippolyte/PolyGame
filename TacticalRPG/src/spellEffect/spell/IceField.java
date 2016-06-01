package spellEffect.spell;

import java.util.List;

import gameObject.Character;
import spellEffect.Effect;
import spellEffect.effect.LessActionEffect;
import spellEffect.effect.SlowEffect;

public class IceField extends spellEffect.Spell{

	public IceField() {
		super(250, 0, 0, TypeSpell.ICEFIELD);	
	}
	
	public void magic(List<Character> List){
		for(gameObject.Character character : List){
			Effect effect = new SlowEffect(character);
			((SlowEffect) effect).slow();
		}
		
	}

}