package spellEffect.effect;

public class DivineShieldEffect extends spellEffect.Effect{

	public DivineShieldEffect(gameObject.Character character) {
		super(character, 2);
		// TODO Auto-generated constructor stub
	}
	
	public void shield(){
		this.character.setDefense(this.character.getDefense()+2);
		this.character.setDefenseMagic(this.character.getDefenseMagic()+2);
	}

	
}
