package model;

import javafx.scene.paint.Color;
import utils.Constants;

public class Pear extends Fruit{
	
	public static final int SIZE = 20;
	protected int X, Y;

	
	
	public Pear(int x, int y) {
		super(Constants.pearAppearAfterSEC,Constants.pointsAddedPear,Constants.lenghtAddedPear);
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