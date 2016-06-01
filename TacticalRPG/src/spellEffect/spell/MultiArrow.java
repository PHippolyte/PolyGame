package spellEffect.spell;

import gameObject.Character;

import java.util.List;

public class MultiArrow extends spellEffect.Spell{

	public MultiArrow(List<Character> List) {
		super(150, 3, 3);
		// TODO Auto-generated constructor stub
	}

	void multi(List<Character> List){
		for(gameObject.Character character : List){
			character.doDamage(this.damage);
		}
	}
}