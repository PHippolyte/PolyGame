package spellEffect;
import gameObject.Character;

public abstract class Effect {
	protected int nbtour;
	
	public Effect(int nb){
		this.nbtour =nb;
	}
	
	public int getNbTour(){
		return this.nbtour;
	}
	
	public void decrement(){
		this.nbtour--;
	}
	
	public abstract void action(Character c);
	public abstract void remise(Character c);
}
