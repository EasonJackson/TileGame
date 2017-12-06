package state;
import java.awt.Graphics;

import entities.creatures.player;
import gfx.Assets;
import handler.Game;
import handler.Handler;
import tile.Tile;
import world.World;

public class GameState extends State{
	private player player1;
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		player1 = new player(handler,100,100);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		player1.tick();
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		player1.render(g);

	}

}
