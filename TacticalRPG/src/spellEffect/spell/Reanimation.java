package spellEffect.spell;

import gameObject.Character;
import spellEffect.Spell.TypeSpell;
import team.Team;

public class Reanimation extends spellEffect.Spell {

	public Reanimation() {
		super(500, 0, 0, TypeSpell.REANIMATION);
		// TODO Auto-generated constructor stub
	}
	
	public void rea(Character character){
		Team team = character.getTeam();
		character = team.getLastDieCharacter();
		character.setHealth(character.getMaxHealth());
	}

}
