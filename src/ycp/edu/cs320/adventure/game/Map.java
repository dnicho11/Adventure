package ycp.edu.cs320.adventure.game;

import java.util.Random;

public class Map {
	//A collection of tiles that contain all actors and map objects.
	private Tile[][] map;
	private int height;
	private int width;
	private int[][] mapData;	//the tile type for every space in the map.
	
	private int gameId;		//what account the map is connected to
	
	public Map(){
		
	}
	//if new map is being made, call buildDefault().
	//When edits are made, set new width and height, set mapData or singleMapData to edit tile types, then rebuildMap()
	//or when pulled from the database.


	public void rebuildMap(){
		//call after making edits.  Does not delete mapData outside map bounds.
		map = new Tile[height][width];
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				map[i][j] = new Tile();
				map[i][j].setType(mapData[i][j]);
				map[i][j].setX(j);
				map[i][j].setY(i);
			}
		}
	}

	public int getGameId(){
		return gameId;
	}
	
	public void setGameId(int i){
		gameId = i;
	}
	
	public Tile[][] getMap(){
		return map;
	}
	
	public void setMap(Tile[][] map){
		this.map = map;
	}

	public void setTile(int i, int j, Tile t){	//i=column(height)		j = row(width)
		map[i][j] = t;
	}
	
	public Tile getTile(int i, int j){
		return map[i][j];
	}

	public int[][] getMapData(){
		return mapData;
	}

	public void setMapData(int[][] data){
		mapData = data;
	}

	public void setSingleMapData(int height, int width, int data){	//expected to be used during map editing
		mapData[height][width] = data;
	}

	public int getHeight(){
		return height;
	}

	public void setHeight(int h){
		height = h;
	}

	public int getWidth(){
		return width;
	}

	public void setWidth(int w){
		width = w;
	}
	
	//small map for testing
	public void buildSmallDefault(GameEngine engine){
		height = 2;
		width = 2;
		map = new Tile[height][width];
		mapData = new int[height][width];

		mapData[0][0] = 1;
		mapData[0][1] = 2;
		mapData[1][0] = 1;
		mapData[1][1] = 1;

		for(int i = 0; i < height; i++){	//setting rest of tiles to type 0
			for(int j = 0; j < width; j++){
				if(mapData[i][j] != 1 && mapData[i][j] != 2){
					mapData[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				map[i][j] = new Tile();
				map[i][j].setType(mapData[i][j]);
				map[i][j].setX(j);
				map[i][j].setY(i);
			}
		}
		map[0][1].addItem(engine.createItem(0));
		map[0][0].setDescription("The entrance.");
		map[0][1].setDescription("A dangerous place. Why would you ever bring me here?");
		map[1][0].setDescription("This space is plain.");
		map[1][1].setDescription("I can exit through here.");
	}
	
	//default map before editing
		public void buildDefault(){
			height = 20;
			width = 20;
			map = new Tile[height][width];
			mapData = new int[height][width];
			for(int i = 0; i < width; i++){
				for(int j = 0; j < height; j++){
					map[i][j] = new Tile();
				}
			}
			mapData[0][0] = 1;
			map[0][0].setDescription("The entrance. The doors have closed and wild growth prevents them from reopening.");
			mapData[0][1] = 1;
			map[0][1].setDescription("This area has several thick trees, the path is thin and the lighting is dim.");
			mapData[0][2] = 1;
			map[0][2].setDescription("This area has several thick trees, the path is thin and the lighting is dim. There is an opening to the south.");
			mapData[0][3] = 1;
			map[0][3].setDescription("You are in a large opening, large trees make a thick wall around the perimeter. "
					+ "There is a path to the north that leads into the forest. "
					+ "There is a short obelisk in front of the path, it's purpose is unknown.");
			mapData[0][4] = 1;
			map[0][4].setDescription("You are in a large opening, large trees make a thick wall around the perimeter.");
			mapData[0][5] = 1;
			map[0][5].setDescription("You are in a large opening, large trees make a thick wall around the perimeter. "
					+ "To the south, there is a path leading through the trees. ");
			mapData[0][6] = 1;
			map[0][6].setDescription("This area is thick with trees and other growth. The vegetation dwarfs those that grow "
					+ "deeper in the forest.");
			mapData[0][7] = 1;
			map[0][7].setDescription("This area is thick with trees and other growth. The vegetation dwarfs those that grow "
					+ "deeper in the forest. an opening is seen ahead");
			mapData[0][8] = 1;
			mapData[0][9] = 1;
			mapData[0][10] = 1;
			mapData[0][16] = 1;
			mapData[0][17] = 1;
			mapData[0][18] = 1;
			mapData[0][19] = 1;
			mapData[1][0] = 1;
			mapData[1][4] = 1;
			mapData[1][9] = 1;
			mapData[1][10] = 1;
			mapData[1][12] = 1;
			mapData[1][16] = 1;
			mapData[1][17] = 1;
			mapData[1][18] = 1;
			mapData[1][19] = 1;
			mapData[2][0] = 1;
			mapData[2][4] = 1;
			mapData[2][5] = 2;
			mapData[2][6] = 1;
			mapData[2][9] = 2;
			mapData[2][10] = 1;
			mapData[2][12] = 1;
			mapData[2][14] = 1;
			mapData[2][16] = 1;
			mapData[2][17] = 1;
			mapData[2][18] = 1;
			mapData[2][19] = 1;
			mapData[3][0] = 1;
			mapData[3][1] = 1;
			mapData[3][2] = 1;
			mapData[3][6] = 1;
			mapData[3][7] = 1;
			mapData[3][10] = 1;
			mapData[3][11] = 1;
			mapData[3][12] = 1;
			mapData[3][13] = 1;
			mapData[3][14] = 1;
			mapData[3][15] = 1;
			mapData[3][16] = 1;
			mapData[3][17] = 1;
			mapData[3][18] = 1;
			mapData[3][19] = 1;
			mapData[4][0] = 1;
			mapData[4][1] = 1;
			mapData[4][2] = 1;
			mapData[4][6] = 1;
			mapData[4][7] = 1;
			mapData[4][10] = 1;
			mapData[4][11] = 1;
			mapData[4][13] = 1;
			mapData[4][17] = 2;
			mapData[4][18] = 2;
			mapData[5][0] = 1;
			mapData[5][1] = 1;
			mapData[5][2] = 1;
			mapData[5][3] = 2;
			mapData[5][4] = 1;
			mapData[5][7] = 1;
			mapData[5][13] = 2;
			mapData[5][17] = 1;
			mapData[5][18] = 1;
			mapData[6][0] = 1;
			mapData[6][7] = 1;
			mapData[6][8] = 1;
			mapData[6][13] = 1;
			mapData[6][17] = 1;
			mapData[6][18] = 1;
			mapData[7][0] = 1;
			mapData[7][8] = 1;
			mapData[7][11] = 1;
			mapData[7][12] = 1;
			mapData[7][13] = 1;
			mapData[7][16] = 1;
			mapData[7][17] = 1;
			mapData[7][18] = 1;
			mapData[7][19] = 1;
			mapData[8][0] = 1;
			mapData[8][1] = 1;
			mapData[8][2] = 1;
			mapData[8][3] = 1;
			mapData[8][4] = 1;
			mapData[8][5] = 1;
			mapData[8][6] = 1;
			mapData[8][7] = 1;
			mapData[8][8] = 1;
			mapData[8][13] = 1;
			mapData[8][15] = 1;
			mapData[8][16] = 1;
			mapData[8][17] = 1;
			mapData[8][19] = 1;
			mapData[9][0] = 1;
			mapData[9][1] = 1;
			mapData[9][4] = 1;
			mapData[9][5] = 1;
			mapData[9][6] = 1;
			mapData[9][7] = 1;
			mapData[9][10] = 1;
			mapData[9][11] = 1;
			mapData[9][13] = 1;
			mapData[9][14] = 1;
			mapData[9][15] = 1;
			mapData[9][16] = 1;
			mapData[9][19] = 1;
			mapData[10][0] = 1;
			mapData[10][6] = 2;
			mapData[10][10] = 1;
			mapData[10][11] = 1;
			mapData[10][14] = 1;
			mapData[10][19] = 1;
			mapData[11][0] = 1;
			mapData[11][1] = 1;
			mapData[11][4] = 1;
			mapData[11][5] = 1;
			mapData[11][6] = 1;
			mapData[11][10] = 1;
			mapData[11][14] = 1;
			mapData[11][19] = 1;
			mapData[12][1] = 1;
			mapData[12][5] = 1;
			mapData[12][6] = 1;
			mapData[12][10] = 2;
			mapData[12][11] = 1;
			mapData[12][12] = 1;
			mapData[12][13] = 1;
			mapData[12][14] = 1;
			mapData[12][19] = 1;
			mapData[13][1] = 1;
			mapData[13][5] = 1;
			mapData[13][12] = 1;
			mapData[13][19] = 1;
			mapData[14][12] = 1;
			mapData[14][14] = 1;
			mapData[14][15] = 1;
			mapData[14][16] = 1;
			mapData[14][19] = 1;
			mapData[15][12] = 1;
			mapData[15][13] = 1;
			mapData[15][14] = 1;
			mapData[15][15] = 1;
			mapData[15][16] = 1;
			mapData[15][19] = 1;
			mapData[16][0] = 1;
			mapData[16][1] = 1;
			mapData[16][2] = 1;
			mapData[16][3] = 1;
			mapData[16][4] = 1;
			mapData[16][5] = 1;
			mapData[16][6] = 1;
			mapData[16][7] = 1;
			mapData[16][8] = 1;
			mapData[16][14] = 1;
			mapData[16][15] = 1;
			mapData[16][16] = 1;
			mapData[16][17] = 1;
			mapData[17][0] = 1;
			mapData[17][2] = 1;
			mapData[17][3] = 1;
			mapData[17][4] = 1;
			mapData[17][5] = 1;
			mapData[17][8] = 1;
			mapData[17][9] = 1;
			mapData[17][15] = 1;
			mapData[17][17] = 1;
			mapData[17][18] = 1;
			mapData[17][19] = 1;
			mapData[18][2] = 1;
			mapData[18][3] = 1;
			mapData[18][4] = 1;
			mapData[18][7] = 1;
			mapData[18][8] = 1;
			mapData[18][9] = 1;
			mapData[19][3] = 1;
			mapData[19][4] = 1;
			mapData[19][5] = 1;
			mapData[19][6] = 1;
			mapData[19][7] = 1;

			for(int i = 0; i < height; i++){	//setting rest of tiles to type 0
				for(int j = 0; j < width; j++){
					if(mapData[i][j] != 1 && mapData[i][j] != 2){
						mapData[i][j] = 0;
						map[i][j].setDescription("This area has dangerous vegetation. There's nothing of interest here.");
					}
				}
			}
			Random rand = new Random();
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j++){
					//map[i][j] = new Tile();
					map[i][j].setType(mapData[i][j]);
					map[i][j].setX(j);
					map[i][j].setY(i);
					
					if(map[i][j].getType() == 2){
						//question 0 to 2
						map[i][j].setQuestion(rand.nextInt(3));
						map[i][j].setDamage(10);
						map[i][j].setHidden(true);
						map[i][j].setActive(true);
					}
				}
			}
			map[0][0].setVisible(true);
			map[0][1].setVisible(true);
			map[1][0].setVisible(true);
			map[1][1].setVisible(true);
			
			//exit
			map[15][17].setType(3);
		}
}
