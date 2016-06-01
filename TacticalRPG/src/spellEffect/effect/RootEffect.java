package spellEffect.effect;

public class RootEffect extends spellEffect.Effect{

	public RootEffect(gameObject.Character character) {
		super(character, 1);
		// TODO Auto-generated constructor stub
	}
	
	public void root(){
		this.character.setEnergy(0);
	}
	
	
	
}