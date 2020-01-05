package model;

import java.io.Serializable;

import javafx.scene.paint.Color;

public class Obstacle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	 * How many obstacles from beginning
	 */
	public final static int OBSTACLES_START_NUMBER = 15;
}
