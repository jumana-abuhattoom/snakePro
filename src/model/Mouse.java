package model;

import utils.Constants;

public class Mouse {

	public int appearAfterSec;
	public int addedPoints;
	public int addedLenght;
	public int addedLife;
	
	
	public Mouse() {
		super();
		this.appearAfterSec = Constants.mouseAppearAfterSEC;
		this.addedPoints = Constants.pointsAddedMouse;
		this.addedLenght = Constants.lenghtAddedMouse;
		this.addedLife = Constants.lifeAddedMouse;
		
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
	
	public int getAddedLife() {
		return addedLife;
	}
	
	
}
