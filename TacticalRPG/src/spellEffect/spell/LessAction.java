package spellEffect.spell;

import java.util.List;

import gameObject.Character;
import spellEffect.Effect;
import spellEffect.effect.LessActionEffect;

public class LessAction extends spellEffect.Spell{

	public LessAction() {
		super(300, 0, 0, TypeSpell.LESSACTION);	
	}
	
	public void magic(List<Character> List){
		for(gameObject.Character character : List){
			Effect effect = new LessActionEffect(character);
			((LessActionEffect) effect).lessAction();
		}
		
	}

}