package spellEffect.effect;

public class RangeBoostEffect extends spellEffect.Effect{

	public RangeBoostEffect(gameObject.Character character) {
		super(character, 2);
		// TODO Auto-generated constructor stub
	}
	
	public void range(){
		this.character.setRange(this.character.getRange()+2);
	}
	
	public void remise(){
		this.character.setRange(this.character.getRange()-2);
	}
	
}