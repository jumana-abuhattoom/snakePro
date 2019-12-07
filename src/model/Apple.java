package model;

import utils.Constants;

public class Apple extends Fruit {
	public Cell applePos;	

	public Apple () {
		super(Constants.appleAppearAfterSEC,Constants.pointsAddedApple,Constants.lenghtAddedApple);
		applePos=new Cell();
		applePos.RandomPostions();
		
		
	}
	
	
	public void setPos() {
		applePos.RandomPostions();

	}

}
