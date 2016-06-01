package spellEffect.effect;

public class SprintEffect extends spellEffect.Effect{

	public SprintEffect(gameObject.Character character) {
		super(character, 2);
		// TODO Auto-generated constructor stub
	}
	
	public void sprint(){
		this.character.setEnergy(this.character.getEnergy()+2);
	}
	
	
	
}