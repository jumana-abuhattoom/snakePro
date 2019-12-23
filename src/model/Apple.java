package model;

import javafx.scene.paint.Color;
import utils.Constants;

public class Apple extends Fruit{
	
	public static final int SIZE = 20;
	protected int X, Y;

	/**
	 * Color of normal fruit
	 */
	public static final Color FRUIT_COLOR = Color.RED;
	
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

	public static Color getFruitColor() {
		return FRUIT_COLOR;
	}
}
