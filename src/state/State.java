package state;

import java.awt.Graphics;

import handler.Game;
import handler.Handler;


public abstract class State {
	
	private static State currentState = null;
	
	protected Handler handler;
	
	public State(Handler handler){
		this.handler = handler;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public static void setState(State state){
		currentState = state;
	}

	public static State getState(){
		return currentState;
	}
}
