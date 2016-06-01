package spellEffect.spell;

import gameObject.Character;
import team.Team;

public class Reanimation extends spellEffect.Spell {

	public Reanimation() {
		super(500, 0, 0);
		// TODO Auto-generated constructor stub
	}
	
	void rea(Character character){
		Team team = character.getTeam();
		character = team.getLastDieCharacter();
		character.setHealth(character.getMaxHealth());
	}

}
