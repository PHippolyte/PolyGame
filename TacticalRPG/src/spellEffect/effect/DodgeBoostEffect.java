package spellEffect.effect;

public class DodgeBoostEffect extends spellEffect.Effect{

	public DodgeBoostEffect(gameObject.Character character) {
		super(character, 2);
		// TODO Auto-generated constructor stub
	}
	
	public void dodge(){
		this.character.setDodge(this.character.getDodge()+2);
	}
	
	public void remise(){
		this.character.setDodge(this.character.getDodge()-2);
	}
	
}