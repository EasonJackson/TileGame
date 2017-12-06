package handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import display.Display;
import gfx.Assets;
import gfx.GameCamera;
import gfx.ImageLoader;
import gfx.SpriteSheet;
import input.KeyManager;
import state.GameState;
import state.MenuState;
import state.State;

public class Game implements Runnable {
	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State gameState;
	private State menuState;
	
	private KeyManager keyManager;
	//private BufferedImage testImage;
	//private SpriteSheet sheet;
	
	private GameCamera gameCamera;
	
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	private void init(){
		display = new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameCamera = new GameCamera(this, 0,0);
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
		//testImage = ImageLoader.loadImage("/textures/sarah_hyland_nude.jpg");
		//sheet = new SpriteSheet(testImage);
	}
	
	int x = 0;
	
	private void tick(){
		keyManager.tick();
		if(State.getState() != null)
			State.getState().tick();
		x += 1;
	}
	
	private void render(){
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		if(State.getState() != null)
			State.getState().render(g);
		//g.drawImage(sheet.crop(50, 50, 400, 600), 0, 0 , null);
		//Start Drawing
		//g.drawImage(Assets.grass,x,10, null );
		//g.drawImage(Assets.player, 100, 10, null );
		//g.drawImage(Assets.stone, 150, 10, null );
		//g.setColor(Color.RED);
		//g.drawRect(10, 50, 50, 70);
		//g.setColor(Color.GREEN);
		//g.fillRect(0, 0, 10, 10);
		//End Drawing
		bs.show();
		g.dispose();
	}
	
	public void run(){
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now  = System.nanoTime();
			delta += (now-lastTime)/timePerTick;
			timer += now-lastTime;
			lastTime = now;
			
			if(delta>=1){
			tick();
			render();
			ticks++;
			delta--;
			}
			if(timer >= 1000000000){
				System.out.println("Ticks and Frames: "+ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	public KeyManager getKeyManager(){
		return keyManager;
	}
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setGameCamera(GameCamera gameCamera) {
		this.gameCamera = gameCamera;
	}

	public synchronized void start(){
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
