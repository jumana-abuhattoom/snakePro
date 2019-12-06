package model;

public  abstract class Fruit {
	public int appearAfterSec;
	public int addedPoints;
	public int addedLenght;
	
	
	public Fruit(int appearAfterSec, int addedPoints, int addedLenght) {
		super();
		this.appearAfterSec = appearAfterSec;
		this.addedPoints = addedPoints;
		this.addedLenght = addedLenght;
	}


	public int getAppearAfterSec() {
		return appearAfterSec;
	}


	public int getAddedPoints() {
		return addedPoints;
	}


	public int getAddedLenght() {
		return addedLenght;
	}
	
	
	
	
	
	
}
