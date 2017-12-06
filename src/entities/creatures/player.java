package entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Assets;
import handler.Game;
import handler.Handler;

public class player extends Creature{

	public player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.playerKiyoshi, (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		//if(handler.getKeyManager().up)
			//g.drawImage(Assets.grass, (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		//if(handler.getKeyManager().down)
			//g.drawImage(Assets.stone, (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		//if(handler.getKeyManager().left)
			//g.drawImage(Assets.tree, (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		//if(handler.getKeyManager().right)
			//g.drawImage(Assets.dirt, (int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),width,height, null);
		//g.setColor(Color.RED);
		//g.fillRect((int)(x+bounds.x-handler.getGameCamera().getxOffset()),(int)(y+bounds.y-handler.getGameCamera().getyOffset()),bounds.width,bounds.height);
	}

}
