package gameObject;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.File;

import javax.imageio.ImageIO;

import Sound.soundManager;
import team.Team;

public abstract class Character extends MapObject{
	public enum Type {SOLDIER, HERO}
	public enum TypeAttack {PHYSICAL, MAGICAL, HEAL}
	
	private boolean done;
	
	protected Team team;
	protected Type type;
	protected TypeAttack typeAttack;
	
	protected int energy;
	
	protected int maxHealth;
	protected int health;
	
	protected int precisionMagic;
	protected int resistance;
	protected int block;
	protected int critique;
	protected int heal;
	
	
	protected BufferedImage grayImage;
	
	public Character(){
		
	}
	
	public Character(int x, int y, int attack, int attackMagic, int defense, int defenseMagic, int precision, int precisionMagic, int dodge, int block, int resistance, int critique, int energy, int range, int health, int heal, TypeAttack typeAttack){
		super(x, y);
		// TODO Auto-generated constructor stub
		this.done = false;
		this.attack = attack;
		this.attackMagic = attackMagic;
		this.defense = defense;
		this.defenseMagic = defenseMagic;
		this.precision = precision;
		this.precisionMagic = precisionMagic;
		this.dodge = dodge;
		this.block = block;
		this.resistance = resistance;
		this.critique = critique;
		this.energy = energy;
		this.range = range;
		this.health = health;
		this.maxHealth = health;
		this.heal = heal;
		this.typeAttack = typeAttack;
	}
	
	public String toString(){
		return this.name+" ("+this.x+","+this.y+") , TEAM "+(this.team.getNum()+1)+", LIFE "+this.health+"/"+this.maxHealth+", ATT "+this.attack+", DEF "+this.defense+", NRG "+this.energy+", RNG "+this.range;
	}
	
	public void setHealth(int health){
		if (health > 0){
			if (health < this.maxHealth){
				this.health = health;
			} else {
				this.health = this.maxHealth;
			}
		}
	}
	
	public void setDone(boolean done){
		this.done = done;
	}
	
	public boolean getDone(){
		return this.done;
	}
	
	public void doDamage(int damage){
		
		this.health -= damage;
		if (this.health < 0){
			this.health = 0;
		}
	}
	
	public void getHeal(int heal){
		this.health += heal;
		if (this.health > this.maxHealth){
			this.health = this.maxHealth;
		}	
	}
	
	public void load(String path){
		try {
			this.sprite = ImageIO.read(new File(path));
			this.grayImage = this.grayRender(this.sprite);
			
		} catch (Exception e) {
			
			System.out.println("Erreur lecture fichier : "+path);
		}
	}
	
	protected BufferedImage grayRender(BufferedImage img){
		if (img != null){
			ColorConvertOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY),null);
			return op.filter(img, null);
		} else {
			return null;
		}
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public Team getTeam(){
		return this.team;
	}
	
	public void setTeam(Team team){
		this.team = team;
	}
	
	public Type getType(){
		return this.type;
	}

	public TypeAttack getTypeAttack() {
		return typeAttack;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getBlock() {
		return block;
	}

	public int getCritique() {
		return critique;
	}

	public int getHeal() {
		return heal;
	}
	public int getPrecisionMagic() {
		return precisionMagic;
	}

	public int getResistance() {
		return resistance;
	}
	
	public int getEnergy(){
		return energy;
	}

	public int getRange(){
		return range;
	}

	public BufferedImage getGrayImage() {
		return this.grayImage;
	}
}
