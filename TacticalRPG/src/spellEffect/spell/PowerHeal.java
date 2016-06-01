package spellEffect.spell;

import java.util.List;

import spellEffect.Spell.TypeSpell;

public class PowerHeal extends spellEffect.Spell{

	public PowerHeal() {
		super(100, 5, 4, TypeSpell.POWERHEAL);
		// TODO Auto-generated constructor stub
	}

	public void pHeal(List<gameObject.Character> List){
		for(gameObject.Character character : List){
			character.setHealth(damage);
		}
	}

}
