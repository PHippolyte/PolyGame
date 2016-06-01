package spellEffect.effect;

public class RootEffect extends spellEffect.Effect{
	int energy;

	public RootEffect(gameObject.Character character) {
		super(character, 2);
		// TODO Auto-generated constructor stub
	}
	
	public void root(){
		this.energy = this.character.getEnergy();
		this.character.setEnergy(0);
	}
	
	public void remise(){
		this.character.setEnergy(energy);
	}
	
}