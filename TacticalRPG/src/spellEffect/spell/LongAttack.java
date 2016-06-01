package spellEffect.spell;

import gameObject.Character;

import java.util.List;

import spellEffect.Spell.TypeSpell;

public class LongAttack extends spellEffect.Spell {

	public LongAttack() {
		super(300, 10, 8, TypeSpell.LONGATTACK);
		// TODO Auto-generated constructor stub
	}

	public void LongDamage(int caseAx, int caseAy, int caseBx, int caseBy, List<Character> List){
		int max = Math.abs(caseAx-caseBx);
		if(max<Math.abs(caseAy-caseBy)){
			max = Math.abs(caseAy-caseBy);
		}
		for(gameObject.Character character : List){
			character.doDamage(this.damage+max/2);
		}
	}
}
