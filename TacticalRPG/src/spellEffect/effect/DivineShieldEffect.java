package spellEffect.effect;
import gameObject.Character;
import spellEffect.Effect;

public class DivineShieldEffect extends Effect{

	public DivineShieldEffect() {
		super(2);
	}

	public void action(Character character){
		character.setDefense(character.getDefense()+2);
		character.setDefenseMagic(character.getDefenseMagic()+2);
	}

	public void remise(Character character){
		character.setDefense(character.getDefense()-2);
		character.setDefenseMagic(character.getDefenseMagic()-2);
	}
}
