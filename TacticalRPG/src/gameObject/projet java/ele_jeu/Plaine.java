package ele_jeu;

public class Plaine extends Case{
	public Plaine(){
		this.att=0;
		this.def=0;
		this.esq=0;
		this.pre=0;
		this.porte=1;
		this.type=Type_terrain.plaine;
		this.conso=1;
	}
}
