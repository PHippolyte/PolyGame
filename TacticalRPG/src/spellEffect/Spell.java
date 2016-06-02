package spellEffect;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import gameObject.Character;
import gameObject.Hero;


public abstract class Spell {
	public enum Type {BLESSING, CURSE, DAMAGE, HEAL}
	
	protected int manaCost;
	protected int damage;
	
	protected int range;
	protected int slashRange;
	
	protected Type type;
	protected BufferedImage name;
	
	public Spell(int cost, int damage, int range){
		this.manaCost = cost;
		this.damage =damage;
		this.range = range;
	}

	public int getManaCost() {
		return manaCost;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public int getSlashRange(){
		return this.slashRange;
	}
	
	public int getRange(){
		return this.range;
	}
	protected void load(String name){
		try {
			this.name = ImageIO.read(new File("ressources/spells/"+name));
		} catch (Exception e) {
			System.out.println("Erreur lecture image : "+ name);
		}
	}
	
	public BufferedImage getNameImage(){
		return this.name;
	}
	
	public abstract void action(Character character, Hero caster);
}
