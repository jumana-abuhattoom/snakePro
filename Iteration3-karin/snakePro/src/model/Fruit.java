package model;

import java.io.Serializable;

public  abstract class Fruit  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
