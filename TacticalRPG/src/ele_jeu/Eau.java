package ele_jeu;

public class Eau extends Case{
	public Eau(){
		this.att=0;
		this.def=0;
		this.esq=0;
		this.pre=0;
		this.porte=-50;
		this.type=Type_terrain.eau;
		this.conso=50;
	}
}
