package ele_jeu;

public class Batiment extends Case {
	public Batiment(){
		this.att=0;
		this.def=0;
		this.esq=0;
		this.pre=0;
		this.porte=-50;
		this.type=Type_terrain.batiment;
		this.conso=50;
	}
}
