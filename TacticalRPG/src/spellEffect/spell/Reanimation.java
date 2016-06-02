package spellEffect.spell;

import gameObject.Character;
import gameObject.Hero;
import team.Team;

public class Reanimation extends spellEffect.Spell {

	public Reanimation() {
		super(500, 0, 0);
		this.type = Type.HEAL;
		this.slashRange = 0;
		// TODO Auto-generated constructor stub
	}
	
	public void rea(Character character){
		Team team = character.getTeam();
		character = team.getLastDieCharacter();
		character.setHealth(character.getMaxHealth());
	}

	@Override
	public void action(Character character, Hero caster) {
		character = character.getTeam().getLastDieCharacter();
		character.setHealth(character.getMaxHealth());
	}

}
