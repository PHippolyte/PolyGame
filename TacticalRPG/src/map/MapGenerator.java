package map;

import gameObject.Tile;
import gameObject.Tile.TypeTile;
import gameObject.tiles.BridgeTile;
import gameObject.tiles.BuildingTile;
import gameObject.tiles.ForestTile;
import gameObject.tiles.LandTile;
import gameObject.tiles.MountainTile;
import gameObject.tiles.WaterTile;

import java.util.Random;

public class MapGenerator {

	private int size;
	private int choice;
	private Tile map[][];
	private Random rand=new Random();
	private int number;

	public MapGenerator(int size){
		this.size= size;
		this.number=size/10;
		this.map= new Tile[size][size];
		GenerationTerrain();
	}

	private void GenerationTerrain() {
		LandGenerator();
		WaterGenerator();
		MountainGenerator();
		BuildingGenerator();
		BridgeGenerator();
		ForestGenerator();
	}

	private void BuildingGenerator() {
		// TODO Auto-generated method stub
		int cont,j,i,nb=0;
		int beginx,beginy;

		while(nb<number){
			int type = (int) (rand.nextInt(3));
			cont=0;
			int currentTilex=(int)(rand.nextInt(size));
			int currentTiley=(int)(rand.nextInt(size));
			if (type==0){
				beginy=currentTiley-1;
				beginx=currentTilex-1;
				for(j=beginy;j<=beginy+3;j++){
					for(i=beginx;i<=beginx+2;i++){
						if((j>=0 & j<size)&(i>=0 & i<size)){
							if(map[i][j].getTypeTile()!= TypeTile.LAND){
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
					for(j=beginy;j<=beginy+2;j++){
						for(i=beginx;i<=beginx+1;i++){
							if((j>=0 & j<size)&(i>=0 & i<size)){
								map[i][j]= new BuildingTile(i,j);
							}
						}
					}
					nb++;
				}
			}
			if (type==1){
				beginy=currentTiley-1;
				beginx=currentTilex-1;
				for(j=beginy;j<=beginy+3;j++){
					for(i=beginx;i<=beginx+4;i++){
						if((j>=0 & j<size)&(i>=0 & i<size)){
							if(map[i][j].getTypeTile()!= TypeTile.LAND){
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
					for(j=beginy;j<=beginy+1;j++){
						for(i=beginx;i<=beginx+2;i++){
							if((j>=0 & j<size)&(i>=0 & i<size)){
								map[i][j]= new BuildingTile(i,j);
							}
						}
					}
					nb++;
				}
			}
			if (type==2){
				beginy=currentTiley-1;
				beginx=currentTilex-1;
				for(j=beginy;j<=beginy+3;j++){
					for(i=beginx;i<=beginx+3;i++){
						if((j>=0 & j<size)&(i>=0 & i<size)){
							if(map[i][j].getTypeTile()!= TypeTile.LAND){
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
					for(j=beginy;j<=beginy+1;j++){
						for(i=beginx;i<=beginx+1;i++){
							if((j>=0 & j<size)&(i>=0 & i<size)){
								map[i][j]= new BuildingTile(i,j);
							}
						}
					}
					nb++;
				}
			}
		}
	}

	private void BridgeGenerator() {
		int nbBridge=size/2;
		int bridgeX[] = new int[size*size];
		int bridgeY[] = new int[size*size];
		int n=0;
		for(int x=0; x<size; x++) {
			for(int y=0; y<size; y++) {
				if(map[x][y].getTypeTile() == TypeTile.WATER) {
					boolean horiz = true, vert = true;
					int cx=x,cy=y;
					if(x==0 || map[cx-1][cy].getTypeTile() == TypeTile.WATER) horiz=false; else vert=false;
					cx=x;cy=y;
					if(x==size-1 || map[cx+1][cy].getTypeTile() == TypeTile.WATER) horiz=false; else vert=false;
					cx=x;cy=y;
					if(y==0 || map[cx][cy-1].getTypeTile() == TypeTile.WATER) vert=false; else horiz=false;
					cx=x;cy=y;
					if(y==size-1 || map[cx][cy+1].getTypeTile() == TypeTile.WATER) vert=false; else horiz=false;

					if(horiz || vert) {
						bridgeX[n]=x; 
						bridgeY[n]=y;
						n++;
					}
				}
			}
		}
		if(nbBridge>n) nbBridge=n;
		boolean tab[]=new boolean[n];
		int i=0;
		for(i=0;i<n;i++){
			tab[i]=true;
		}
		i=0;
		while( i<nbBridge) {
			int j = (int)(rand.nextInt(n));
			if(tab[j]){
				System.out.println(1);
				map[bridgeX[j]][bridgeY[j]] = new BridgeTile(bridgeX[j],  bridgeY[j]);
				tab[j]=false;
				i++;
			}
		}

	}

	private void ForestGenerator() {
		// TODO Auto-generated method stub
		int nb_title=size*number+(int)rand.nextInt(16);
		int creat;
		int nb=0;
		int i,j;
		while(nb<nb_title){
			for(j=0;j<size;j++){
				for(i=0;i<size;i++){
					if(map[i][j].getTypeTile()==TypeTile.LAND){
						creat = (int)rand.nextInt(10);
						if(creat==0){
							map[i][j] = new ForestTile(i, j);
							nb++;
						}
					}
					if(nb>=nb_title){
						break;
					}
				}
				if(nb>=nb_title){
					break;
				}
			}
		}
	}

	private void MountainGenerator() {
		// TODO Auto-generated method stub
		int j,i,nb=0;

		while(nb<number){
			int type = (int) (rand.nextInt(2));
			int currentTilex=(int)(rand.nextInt(size));
			int currentTiley=(int)(rand.nextInt(size));
			if (type==0){
				for(j=currentTiley-1;j<=currentTiley+2;j++){
					int debut,max;
					if (j==currentTiley-1 || j==currentTiley+2){
						debut=currentTilex;
						max=debut+1;
					}
					else{
						debut=currentTilex-1;
						max=debut+3;
					}
					for (i=debut ; i<=max ;i++){
						if((j>=0 & j<size)&(i>=0 & i<size)){
							if(map[i][j].getTypeTile()!=TypeTile.WATER){
								map[i][j]= new MountainTile(i,j);
							}
						}
					}
				}
				nb++;
			}
			if (type==1){
				for(j=currentTiley-2;j<=currentTiley+2;j++){
					int debut,max;
					if((j==currentTiley-2 || j==currentTiley+2)&(j>=0 & j<size)&(currentTilex>=0 & currentTilex<size)){
						if(map[currentTilex][j].getTypeTile()!=TypeTile.WATER){
							map[currentTilex][j]= new MountainTile( currentTilex,j);
						}
					}
					else if (j==currentTiley-1 || j==currentTiley+1){
						debut=currentTilex-1;
						max=debut+2;
						for (i=debut ; i<=max ;i++){
							if((j>=0 & j<size)&(i>=0 & i<size)){
								if(map[i][j].getTypeTile()!=TypeTile.WATER){
									map[i][j]= new MountainTile(i,j);
								}
							}
						}
					}
					else{
						debut=currentTilex-2;
						max=debut+4;
						for (i=debut ; i<=max ;i++){
							if((j>=0 & j<size)&(i>=0 & i<size)){
								if(map[i][j].getTypeTile()!=TypeTile.WATER){
									map[i][j]= new MountainTile(i,j);
								}
							}
						}
					}
				}
				nb++;
			}
		}
	}

	private void WaterGenerator() {
		int nbTile=(int)(rand.nextInt(size))+size;
		int currentTilex=0;
		int currentTiley=0;
		int x,y,choice2,count=0;
		boolean test1 = true,test2=true;
		int j;
		for(j=0;j<number;j++){
			choice=rand.nextInt(4);
			if (choice==0){
				currentTilex = (int)(rand.nextInt(size));
				currentTiley = 0;
			}
			else if (choice==1){
				currentTilex = (int)(rand.nextInt(size));
				currentTiley = size-1;
			}
			else if (choice==2){
				currentTilex = 0;
				currentTiley = (int)(rand.nextInt(size));
			}
			else if (choice==3){
				currentTilex = size-1;
				currentTiley = (int)(rand.nextInt(size));
			}
			int i=0;
			while(i<=nbTile){
				choice2=rand.nextInt(2);
				x = currentTilex;
				y = currentTiley;
				if(choice==0){
					if(choice2==0 && test1 && x!=0){

						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						test2=false;
						currentTilex--;

						count=0;
					}
					else if(choice2==1 && test2 && x!=size-1){

						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						test1=false;
						currentTilex++;

						count=0;
					}
					else{
						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						currentTiley++;
						count++;
						if(count>=2){
							test1=test2=true;
						}
					}
				}

				else if(choice==1){
					if(choice2==0 && test1 && x!=0){

						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						test2=false;
						currentTilex--;
						count=0;

					}
					else if(choice2==1 && test2 && x!=size-1){

						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						test1=false;
						currentTilex++;
						count=0;

					}
					else if(y!=0){
						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						currentTiley--;
						count++;
						if(count>=2){
							test1=test2=true;
						}
					}
				}
				else if(choice==2){
					if(choice2==0 && test1 && y!=0){

						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						test2=false;
						currentTiley--;
						count=0;

					}
					else if(choice2==1 && test2 && y!=size-1){

						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						test1=false;
						currentTiley++;
						count=0;

					}
					else if(x!=size-1){
						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						currentTilex++;
						if(count>=2){
							test1=test2=true;
						}
					}
				}
				else if(choice==3){
					if(choice2==0 && test1 && y!=0){

						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						test2=false;
						currentTiley--;
						count=0;

					}
					else if(choice2==1 && test2 && y!=size-1){

						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						test1=false;
						currentTiley++;
						count=0;

					}
					else if(x!=0){
						map[currentTilex][currentTiley]=new WaterTile(currentTilex, currentTiley);
						currentTilex--;
						if(count>=2){
							test1=test2=true;
						}
					}
				}
				i++;
			}
		}
	}

	private void LandGenerator() {
		// TODO Auto-generated method stub
		int i,j;
		for(j=0;j<size;j++){
			for(i=0;i<size;i++){
				map[i][j]= new LandTile(i, j);
			}
		}
	}

	public void Print(){
		int j,i;
		char type='a';
		for (j=0;j<size;j++){
			for (i=0;i<size;i++){
				if(map[i][j].getTypeTile()==TypeTile.WATER){
					type='E';
				}
				else if(map[i][j].getTypeTile()==TypeTile.BRIDGE){
					type='K';
				}
				else if(map[i][j].getTypeTile()==TypeTile.MOUNTAIN){
					type='M';
				}
				else if(map[i][j].getTypeTile()==TypeTile.LAND){
					type='P';
				}
				else if(map[i][j].getTypeTile()==TypeTile.BUILDING){
					type='B';
				}
				else if(map[i][j].getTypeTile()==TypeTile.FOREST){
					type='F';
				}
			}
		}
	}

	public Tile[][] getMap(){
		return this.map;
	}

}

