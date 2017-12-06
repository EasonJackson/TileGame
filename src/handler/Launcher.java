package handler;
import display.Display;

public class Launcher {
	public static void main(String[] args){
		Game game = new Game("Shoot me if you can!",600,600);
		game.start();
	}
}
