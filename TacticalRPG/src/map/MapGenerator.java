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
		System.out.println("Land generated");
		WaterGenerator();
		System.out.println("Water generated");
		MountainGenerator();
		System.out.println("Moutain generated");
		BuildingGenerator();
		System.out.println("Building generated");
		BridgeGenerator();
		System.out.println("Bridge generated");
		ForestGenerator();
		System.out.println("Forest generated");
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
//*
	private void BridgeGenerator() {
		int nbBridge=5;
		int bridgeX[] = new int[size*size];
		int bridgeY[] = new int[size*size];
		int n=0;
		for(int x=0; x<size; x++) {
			for(int y=0; y<size; y++) {
				if(map[x][y].getTypeTile() == TypeTile.WATER) {
					boolean horiz = true, vert = true;
					if(x==0 || map[x-1][y].getTypeTile() == TypeTile.WATER) horiz=false; else vert=false;
					if(x==size-1 || map[x+1][y].getTypeTile() == TypeTile.WATER) horiz=false; else vert=false;
					if(y==0 || map[x][y-1].getTypeTile() == TypeTile.WATER) vert=false; else horiz=false;
					if(y==size-1 || map[x][y+1].getTypeTile() == TypeTile.WATER) vert=false; else horiz=false;
					
					if(horiz || vert) {
						bridgeX[n]=x; bridgeY[n++]=y;
					}
				}
			}
		}
		if(nbBridge>n) nbBridge=n; 
		for(int i=0; i<nbBridge; i++) {
			int j = (int)(rand.nextInt(n));
			map[bridgeX[j]][bridgeY[j]] = new BridgeTile(bridgeX[j],  bridgeY[j]);
			bridgeX[j] = bridgeX[--n];
			bridgeY[j] = bridgeY[n];
		}
		
	}
	/*/
	private void BridgeGenerator() {
		// TODO Auto-generated method stub
		int nbBridge=5,i,j,nb=0;
		int build,end=0;
		if (choice==0 || choice==1){
			while(nb<nbBridge){
				for(j=0;j<size;j++){
					build=(int) (rand.nextInt(4));
					for(i=0;i<size;i++){
						if(map[i][j].getTypeTile()== TypeTile.WATER && build==0){
							map[i][j]= new BridgeTile(i,j);
							end=1;
						}
						else if (map[i][j].getTypeTile()== TypeTile.LAND && end==1){
							end=0;
							build=1;
							nb++;
						}
					}
				}
			}
		}
		else if (choice==2 || choice==3){
			while(nb<nbBridge){
				for(i=0;i<size;i++){
					build=(int) (rand.nextInt(4));
					for(j=0;j<size;j++){
						if(map[i][j].getTypeTile()== TypeTile.WATER && build==0){
							map[i][j]= new BridgeTile(i,j);
							end=1;
						}
						else if (map[i][j].getTypeTile()== TypeTile.LAND && end==1){
							end=0;
							build=1;
							nb++;
						}
					}
				}
			}
		}
	}
	//*/
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
						if(map[j][currentTilex].getTypeTile()!=TypeTile.WATER){
							map[j][currentTilex]= new MountainTile(j, currentTilex);
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
		int x,y,choice2;
		char dir=' ';
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
		System.out.println("Generating water");
		while(i<=nbTile){
			choice2=rand.nextInt(2);
			x = currentTilex;
			y = currentTiley;
			// && map[y][x--].getTypeTile()!=TypeTile.WATER
			if(choice==0){
				if(choice2==0 && dir!='d' && x!=0){
					if(y>0 && y<size-1){
						if( map[y--][x--].getTypeTile()!=TypeTile.WATER && map[y++][x--].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='g';
							currentTilex--;
						}
					}
					else if(y==size-1){
						if( map[y--][x--].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='g';
							currentTilex--;
						}
					}
					else{
						map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
						dir='g';
						currentTilex--;
					}
				}
				else if(choice2==1 && dir!='g' && x!=size-1){
					if(y>0 && y<size-1){
						if( map[y--][x++].getTypeTile()!=TypeTile.WATER && map[y++][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='d';
							currentTilex++;
						}
					}
					else if(y==size-1){
						if( map[y--][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='d';
							currentTilex++;
						}
					}
					else{
						map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
						dir='d';
						currentTilex++;
					}
				}
				else{
					map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
					dir=' ';
					currentTiley++;
				}
			}

			else if(choice==1){
				if(choice2==0 && dir!='d' && x!=0){
					if(y>0 && y<size-1){
						if( map[y--][x--].getTypeTile()!=TypeTile.WATER && map[y++][x--].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='g';
							currentTilex--;
						}
					}
					else if(y==0){
						if( map[y++][x--].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='g';
							currentTilex--;
						}
					}
					else{
						map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
						dir='g';
						currentTilex--;
					}
				}
				else if(choice2==1 && dir!='g' && x!=size-1){
					if(y>0 && y<size-1){
						if( map[y--][x++].getTypeTile()!=TypeTile.WATER && map[y++][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='d';
							currentTilex++;
						}
					}
					else if(y==0){
						if( map[y++][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='d';
							currentTilex++;
						}
					}
					else{
						map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
						dir='d';
						currentTilex++;
					}
				}
				else if(y!=0){
					map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
					dir=' ';
					currentTiley--;
				}
			}
			else if(choice==2){
				if(choice2==0 && dir!='b' && y!=0){
					if(x>0 && x<size-1){
						if( map[y--][x--].getTypeTile()!=TypeTile.WATER && map[y--][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='h';
							currentTiley--;
						}
					}
					else if(x==size-1){
						if( map[y--][x--].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='h';
							currentTiley--;
						}
					}
					else{
						map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
						dir='h';
						currentTiley--;
					}
				}
				else if(choice2==1 && dir!='h' && y!=size-1){
					if(x>0 && x<size-1){
						if( map[y++][x--].getTypeTile()!=TypeTile.WATER && map[y++][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='b';
							currentTiley++;
						}
					}
					else if(x==size-1){
						if( map[y++][x--].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='b';
							currentTiley++;
						}
					}
					else{
						map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
						dir='b';
						currentTiley++;
					}
				}
				else if(x!=size-1){
					map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
					dir=' ';
					currentTilex++;
				}
			}
			else if(choice==3){
				if(choice2==0 && dir!='b' && y!=0){
					if(x>0 && x<size-1){
						if( map[y--][x--].getTypeTile()!=TypeTile.WATER && map[y--][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='h';
							currentTiley--;
						}
					}
					else if(x==0){
						if( map[y--][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='h';
							currentTiley--;
						}
					}
					else{
						map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
						dir='h';
						currentTiley--;
					}
				}
				else if(choice2==1 && dir!='h' && y!=size-1){
					if(x>0 && x<size-1){
						if( map[y++][x--].getTypeTile()!=TypeTile.WATER && map[y++][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='b';
							currentTiley++;
						}
					}
					else if(x==0){
						if( map[y++][x++].getTypeTile()!=TypeTile.WATER){
							map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
							dir='b';
							currentTiley++;
						}
					}
					else{
						map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
						dir='b';
						currentTiley++;
					}
				}
				else if(x!=0){
					map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
					dir=' ';
					currentTilex--;
				}
			}
			//&& map[y][x++].getTypeTile()!=TypeTile.WATER
			/*else if(choice2==1 && x!=29 && choice!=3&& map[x++][y++].getTypeTile()!=TypeTile.WATER && map[x++][y--].getTypeTile()!=TypeTile.WATER){
			map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
			currentTilex++;
			i++;
		}
		// && y!=0 && map[y--][x].getTypeTile()!=TypeTile.WATER
		else if(choice2==2 && y!=0&& choice!=0&& map[x--][y--].getTypeTile()!=TypeTile.WATER && map[x++][y--].getTypeTile()!=TypeType.WATER){
			map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
			currentTiley--;
			i++;
		}
		//&& map[y++][x].getTypeTile()!=TypeTile.WATER
		else if(choice2==3 && y!=29 && choice!=1&& map[x--][y++].getTypeTile()!=TypeTile.WATER && map[x++][y++].getTypeTile()!=TypeTile.WATER){
			map[currentTiley][currentTilex]=new WaterTile(currentTilex, currentTiley);
			currentTiley++;
			i++;
		}*/
			i++;
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
				System.out.print(type);
			}
			System.out.println();
		}
	}

	public Tile[][] getMap(){
		return this.map;
	}

}

