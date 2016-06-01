package spellEffect.effect;

public class SlowEffect extends spellEffect.Effect{

	public SlowEffect(gameObject.Character character) {
		super(character, 2);
		// TODO Auto-generated constructor stub
	}
	
	public void slow(){
		this.character.setEnergy(this.character.getEnergy()-2);
	}
	
	public void remise(){
		this.character.setEnergy(this.character.getEnergy()+2);
	}
	
}