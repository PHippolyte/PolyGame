package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Effect;
import spellEffect.Spell.TypeSpell;
import spellEffect.effect.RootEffect;

public class Root extends spellEffect.Spell{

	public Root () {
		super(100, 1, 3, TypeSpell.ROOT);
		
	}
	
	public void root(List<Character> List){
		 Effect effect = new RootEffect(List.get(0));
		 List.get(0).doDamage(this.damage);
		((RootEffect) effect).root();
	}

}