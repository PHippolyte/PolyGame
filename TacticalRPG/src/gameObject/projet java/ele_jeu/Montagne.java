package ele_jeu;

public class Montagne extends Case{
	public Montagne(){
		this.att=-5;
		this.def=+5;
		this.esq=-5;
		this.pre=+5;
		this.porte=0;
		this.type=Type_terrain.montagne;
		this.conso=3;
	}
}
