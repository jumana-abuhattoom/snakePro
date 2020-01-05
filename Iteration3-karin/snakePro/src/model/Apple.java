package model;

import java.io.Serializable;

import utils.Constants;

public class Apple extends Fruit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int SIZE = 20;
	protected int X, Y;

	
	public Apple(int x, int y) {
		super(Constants.appleAppearAfterSEC,Constants.pointsAddedApple,Constants.lenghtAddedApple);
		this.X=x;
		this.Y=y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public static int getSize() {
		return SIZE;
	}

	
}
