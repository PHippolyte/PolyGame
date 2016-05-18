package terrain;
import java.util.Random;
import ele_jeu.*;

public class Terrain {
	private int taille;
	private int choix;
	private Case terrain[][];
	private Random rand=new Random();

	public Terrain(int taille){
		this.taille= taille;
		this.terrain= new Case[taille][taille];
		GenerationTerrain();
	}

	private void GenerationTerrain() {
		GenerationPlaine();
		GenerationEau();
		GenerationMontagne();
		GenerationBatiment();
		/*GenerationPont();
		GenerationForet();*/
	}

	private void GenerationBatiment() {
		// TODO Auto-generated method stub
		int vald=(int) (rand.nextInt(3))+1;
		int cont,j,i,nb=0;
		int debutx,debuty;

		while(nb<vald){
			int type = (int) (rand.nextInt(3));
			cont=0;
			int case_courantex=(int)(rand.nextInt(30));
			int case_courantey=(int)(rand.nextInt(30));
			if (type==0){
				debuty=case_courantey-1;
				debutx=case_courantex-1;
				for(j=debuty;j<=debuty+3;j++){
					for(i=debutx;i<=debutx+2;i++){
						if((j>=0 & j<taille)&(i>=0 & i<taille)){
							if(terrain[j][i].getType()!= Type_terrain.plaine){
								cont=1;
							}
						}
						if (cont==1){
							break;
						}
					}
					if (cont==1){
						break;
					}
				}
				if(cont==0){
					for(j=debuty;j<=debuty+2;j++){
						for(i=debutx;i<=debutx+1;i++){
							if((j>=0 & j<taille)&(i>=0 & i<taille)){
								terrain[j][i]= new Batiment();
							}
						}
					}
					nb++;
				}
			}
			if (type==1){
				debuty=case_courantey-1;
				debutx=case_courantex-1;
				for(j=debuty;j<=debuty+3;j++){
					for(i=debutx;i<=debutx+4;i++){
						if((j>=0 & j<taille)&(i>=0 & i<taille)){
							if(terrain[j][i].getType()!= Type_terrain.plaine){
								cont=1;
							}
						}
						if (cont==1){
							break;
						}
					}
					if (cont==1){
						break;
					}
				}
				if(cont==0){
					for(j=debuty;j<=debuty+1;j++){
						for(i=debutx;i<=debutx+2;i++){
							if((j>=0 & j<taille)&(i>=0 & i<taille)){
								terrain[j][i]= new Batiment();
							}
						}
					}
					nb++;
				}
			}
			if (type==2){
				debuty=case_courantey-1;
				debutx=case_courantex-1;
				for(j=debuty;j<=debuty+3;j++){
					for(i=debutx;i<=debutx+3;i++){
						if((j>=0 & j<taille)&(i>=0 & i<taille)){
							if(terrain[j][i].getType()!= Type_terrain.plaine){
								cont=1;
							}
						}
						if (cont==1){
							break;
						}
					}
					if (cont==1){
						break;
					}
				}
				if(cont==0){
					for(j=debuty;j<=debuty+1;j++){
						for(i=debutx;i<=debutx+1;i++){
							if((j>=0 & j<taille)&(i>=0 & i<taille)){
								terrain[j][i]= new Batiment();
							}
						}
					}
					nb++;
				}
			}
		}
	}

	private void GenerationPont() {
		// TODO Auto-generated method stub

	}

	private void GenerationForet() {
		// TODO Auto-generated method stub

	}

	private void GenerationMontagne() {
		// TODO Auto-generated method stub
		int vald=(int) (rand.nextInt(3))+1;
		int cont,j,i,nb=0;

		while(nb<vald){
			int type = (int) (rand.nextInt(2));
			cont=0;
			int case_courantex=(int)(rand.nextInt(30));
			int case_courantey=(int)(rand.nextInt(30));
			if (type==0){
				for(j=case_courantey-2;j<=case_courantey+3;j++){
					int debut,max;
					if (j==case_courantey-2 || j==case_courantey+3){
						debut=case_courantex-1;
						max=debut+3;
					}
					else{
						debut=case_courantex-2;
						max=debut+5;
					}
					for (i=debut ; i<= max ;i++){
						if((j>=0 & j<taille)&(i>=0 & i<taille)){
							if(terrain[j][i].getType()!= Type_terrain.plaine){
								cont=1;
							}
						}
						if (cont==1){
							break;
						}
					}
					if (cont==1){
						break;
					}
				}
				if(cont==0){
					for(j=case_courantey-1;j<=case_courantey+2;j++){
						int debut,max;
						if (j==case_courantey-1 || j==case_courantey+2){
							debut=case_courantex;
							max=debut+1;
						}
						else{
							debut=case_courantex-1;
							max=debut+3;
						}
						for (i=debut ; i<=max ;i++){
							if((j>=0 & j<taille)&(i>=0 & i<taille)){
								terrain[j][i]= new Montagne();
							}
						}
					}
					nb++;
				}
			}
			if (type==1){
				for(j=case_courantey-3;j<=case_courantey+3;j++){
					int debut,max;
					if (j==case_courantey-3 || j==case_courantey+3){
						debut=case_courantex-1;
						max=debut+2;
					}
					else if(j==case_courantey-2 || j==case_courantey+2){
						debut=case_courantex-2;
						max=debut+4;
					}
					else{
						debut=case_courantex-3;
						max=debut+6;
					}
					for (i=debut ; i<= max ;i++){
						if((j>=0 & j<taille)&(i>=0 & i<taille)){
							if(terrain[j][i].getType()!= Type_terrain.plaine){
								cont=1;
							}
						}
						if (cont==1){
							break;
						}
					}
					if (cont==1){
						break;
					}
				}
				if(cont==0){
					for(j=case_courantey-2;j<=case_courantey+2;j++){
						int debut,max;
						if((j==case_courantey-2 || j==case_courantey+2)&(j>=0 & j<taille)&(case_courantex>=0 & case_courantex<taille)){
							terrain[j][case_courantex]= new Montagne();
						}
						else if (j==case_courantey-1 || j==case_courantey+1){
							debut=case_courantex-1;
							max=debut+2;
							for (i=debut ; i<=max ;i++){
								if((j>=0 & j<taille)&(i>=0 & i<taille)){
									terrain[j][i]= new Montagne();
								}
							}
						}
						else{
							debut=case_courantex-2;
							max=debut+4;
							for (i=debut ; i<=max ;i++){
								if((j>=0 & j<taille)&(i>=0 & i<taille)){
									terrain[j][i]= new Montagne();
								}
							}
						}
						nb++;
					}
				}
			}
		}
	}

	private void GenerationEau() {
		int nbcase=(int)(rand.nextInt(15))+35;
		int case_courantex=0;
		int case_courantey=0;
		int x,y,choix2;
		char dir=' ';
		choix=rand.nextInt(4);
		if (choix==0){
			case_courantex = (int)(rand.nextInt(30));
			case_courantey = 0;
		}
		else if (choix==1){
			case_courantex = (int)(rand.nextInt(30));
			case_courantey = 29;
		}
		else if (choix==2){
			case_courantex = 0;
			case_courantey = (int)(rand.nextInt(30));
		}
		else if (choix==3){
			case_courantex = 29;
			case_courantey = (int)(rand.nextInt(30));
		}
		int i=0;
		while(i<=nbcase){
			choix2=rand.nextInt(2);
			x = case_courantex;
			y = case_courantey;
			// && terrain[y][x--].getType()!=Type_terrain.eau
			if(choix==0){
				if(choix2==0 && dir!='d' && x!=0){
					if(y>0 && y<taille-1){
						if( terrain[y--][x--].getType()!=Type_terrain.eau && terrain[y++][x--].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='g';
							case_courantex--;
							i++;
						}
					}
					else if(y==taille-1){
						if( terrain[y--][x--].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='g';
							case_courantex--;
							i++;
						}
					}
					else{
						terrain[case_courantey][case_courantex]=new Eau();
						dir='g';
						case_courantex--;
						i++;
					}
				}
				else if(choix2==1 && dir!='g' && x!=taille-1){
					if(y>0 && y<taille-1){
						if( terrain[y--][x++].getType()!=Type_terrain.eau && terrain[y++][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='d';
							case_courantex++;
							i++;
						}
					}
					else if(y==taille-1){
						if( terrain[y--][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='d';
							case_courantex++;
							i++;
						}
					}
					else{
						terrain[case_courantey][case_courantex]=new Eau();
						dir='d';
						case_courantex++;
						i++;
					}
				}
				else{
					terrain[case_courantey][case_courantex]=new Eau();
					dir=' ';
					case_courantey++;
					i++;
				}
			}

			else if(choix==1){
				if(choix2==0 && dir!='d' && x!=0){
					if(y>0 && y<taille-1){
						if( terrain[y--][x--].getType()!=Type_terrain.eau && terrain[y++][x--].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='g';
							case_courantex--;
							i++;
						}
					}
					else if(y==0){
						if( terrain[y++][x--].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='g';
							case_courantex--;
							i++;
						}
					}
					else{
						terrain[case_courantey][case_courantex]=new Eau();
						dir='g';
						case_courantex--;
						i++;
					}
				}
				else if(choix2==1 && dir!='g' && x!=taille-1){
					if(y>0 && y<taille-1){
						if( terrain[y--][x++].getType()!=Type_terrain.eau && terrain[y++][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='d';
							case_courantex++;
							i++;
						}
					}
					else if(y==0){
						if( terrain[y++][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='d';
							case_courantex++;
							i++;
						}
					}
					else{
						terrain[case_courantey][case_courantex]=new Eau();
						dir='d';
						case_courantex++;
						i++;
					}
				}
				else if(y!=0){
					terrain[case_courantey][case_courantex]=new Eau();
					dir=' ';
					case_courantey--;
					i++;
				}
			}
			else if(choix==2){
				if(choix2==0 && dir!='b' && y!=0){
					if(x>0 && x<taille-1){
						if( terrain[y--][x--].getType()!=Type_terrain.eau && terrain[y--][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='h';
							case_courantey--;
							i++;
						}
					}
					else if(x==taille-1){
						if( terrain[y--][x--].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='h';
							case_courantey--;
							i++;
						}
					}
					else{
						terrain[case_courantey][case_courantex]=new Eau();
						dir='h';
						case_courantey--;
						i++;
					}
				}
				else if(choix2==1 && dir!='h' && y!=taille-1){
					if(x>0 && x<taille-1){
						if( terrain[y++][x--].getType()!=Type_terrain.eau && terrain[y++][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='b';
							case_courantey++;
							i++;
						}
					}
					else if(x==taille-1){
						if( terrain[y++][x--].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='b';
							case_courantey++;
							i++;
						}
					}
					else{
						terrain[case_courantey][case_courantex]=new Eau();
						dir='b';
						case_courantey++;
						i++;
					}
				}
				else if(x!=taille-1){
					terrain[case_courantey][case_courantex]=new Eau();
					dir=' ';
					case_courantex++;
					i++;
				}
			}
			else if(choix==3){
				if(choix2==0 && dir!='b' && y!=0){
					if(x>0 && x<taille-1){
						if( terrain[y--][x--].getType()!=Type_terrain.eau && terrain[y--][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='h';
							case_courantey--;
							i++;
						}
					}
					else if(x==0){
						if( terrain[y--][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='h';
							case_courantey--;
							i++;
						}
					}
					else{
						terrain[case_courantey][case_courantex]=new Eau();
						dir='h';
						case_courantey--;
						i++;
					}
				}
				else if(choix2==1 && dir!='h' && y!=taille-1){
					if(x>0 && x<taille-1){
						if( terrain[y++][x--].getType()!=Type_terrain.eau && terrain[y++][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='b';
							case_courantey++;
							i++;
						}
					}
					else if(x==0){
						if( terrain[y++][x++].getType()!=Type_terrain.eau){
							terrain[case_courantey][case_courantex]=new Eau();
							dir='b';
							case_courantey++;
							i++;
						}
					}
					else{
						terrain[case_courantey][case_courantex]=new Eau();
						dir='b';
						case_courantey++;
						i++;
					}
				}
				else if(x!=0){
					terrain[case_courantey][case_courantex]=new Eau();
					dir=' ';
					case_courantex--;
					i++;
				}
			}
			//&& terrain[y][x++].getType()!=Type_terrain.eau 
			/*else if(choix2==1 && x!=29 && choix!=3&& terrain[x++][y++].getType()!=Type_terrain.eau && terrain[x++][y--].getType()!=Type_terrain.eau){
			terrain[case_courantey][case_courantex]=new Eau();
			case_courantex++;
			i++;
		}
		// && y!=0 && terrain[y--][x].getType()!=Type_terrain.eau
		else if(choix2==2 && y!=0&& choix!=0&& terrain[x--][y--].getType()!=Type_terrain.eau && terrain[x++][y--].getType()!=Type_terrain.eau){
			terrain[case_courantey][case_courantex]=new Eau();
			case_courantey--;
			i++;
		}
		//&& terrain[y++][x].getType()!=Type_terrain.eau
		else if(choix2==3 && y!=29 && choix!=1&& terrain[x--][y++].getType()!=Type_terrain.eau && terrain[x++][y++].getType()!=Type_terrain.eau){
			terrain[case_courantey][case_courantex]=new Eau();
			case_courantey++;
			i++;
		}*/
		}
	}

	private void GenerationPlaine() {
		// TODO Auto-generated method stub
		int i,j;
		for(j=0;j<30;j++){
			for(i=0;i<30;i++){
				terrain[j][i]= new Plaine();
			}
		}
	}

	public void Affiher(){
		int j,i;
		char type='a';
		for (j=0;j<taille;j++){
			for (i=0;i<taille;i++){
				if(terrain[j][i].getType()==Type_terrain.eau){
					type='E';
				}
				else if(terrain[j][i].getType()==Type_terrain.montagne){
					type='M';
				}
				else if(terrain[j][i].getType()==Type_terrain.plaine){
					type='P';
				}
				else if(terrain[j][i].getType()==Type_terrain.batiment){
					type='B';
				}
				System.out.print(type);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Terrain terrain= new Terrain(30);
		terrain.Affiher();
	}

}
