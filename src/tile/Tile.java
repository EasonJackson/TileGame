package tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	//STATIC STUFF
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(1);
	public static Tile dirtTile = new DirtTile(2);
	public static Tile rockTile = new RockTile(0);
	public static Tile riverTile = new RiverTile(3);
	public static Tile barTile = new BarTile(4);
	public static Tile flowerTile = new FlowerTile(5);
	public static Tile bridgeTile = new BridgeTile(6);
	public static Tile treeTile = new TreeTile(7);
	
	//CLASS
	public static final int TILEWIDTH = 60, TILEHEIGHT = 60;
	
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(texture, x, y, TILEWIDTH,TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
}
