package model;

import java.io.Serializable;

public abstract class GameObject  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int SIZE = 20;
	protected int X, Y;
	
	public GameObject(int x, int y){
		
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
	
	
	
	
}
