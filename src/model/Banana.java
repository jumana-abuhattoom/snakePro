package model;
import utils.Constants;

public class Banana extends Fruit{
	
	public static final int SIZE = 20;
	protected int X, Y;


	public Banana(int x, int y) {
		super(Constants.bnanaAppearAfterSEC,Constants.pointsAddedBnana,Constants.lenghtAddedBnana);
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


