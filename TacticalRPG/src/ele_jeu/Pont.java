package ele_jeu;

public class Pont extends Case{
	public Pont(){
		this.att=0;
		this.def=0;
		this.esq=0;
		this.pre=0;
		this.porte=0;
		this.type=Type_terrain.pont;
		this.conso=1;
	}
}
