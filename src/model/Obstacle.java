package model;

import javafx.scene.paint.Color;

public class Obstacle{
	public static final int SIZE = 20;
	private int X, Y;
	
	public Obstacle(int x, int y){
		
		this.X = x;
		this.Y = y;
	}

	public int getX() {
		return X;
	}

	public int getY() {
		return Y;
	}

	public void setX(int x) {
		X = x;
	}

	public void setY(int y) {
		Y = y;
	}
	/**
	 * Color of obstacles
	 */
	public static final Color OBSTACLE_COLOR = Color.BROWN;
	
	/**
	 * How many obstacles from beginning
	 */
	public final static int OBSTACLES_START_NUMBER = 3;
	
	

}
