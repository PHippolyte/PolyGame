package spellEffect;

import java.util.ArrayList;
import java.util.List;

public abstract class Effect {
	protected gameObject.Character character;
	public int nbtour;
	
	public Effect(gameObject.Character character, int nb){
		this.character = character;
		this.nbtour =nb;
	}
}
