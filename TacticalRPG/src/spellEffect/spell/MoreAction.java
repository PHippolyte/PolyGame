package spellEffect.spell;

import java.util.List;

import gameObject.Character;
import spellEffect.Effect;
import spellEffect.effect.MoreActionEffect;

public class MoreAction extends spellEffect.Spell{

	public MoreAction() {
		super(300, 0, 0, TypeSpell.MOREACTION);	
	}
	
	public void magic(List<Character> List){
		for(gameObject.Character character : List){
			Effect effect = new MoreActionEffect(character);
			((MoreActionEffect) effect).moreAction();
		}
		
	}

}