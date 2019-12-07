package model;

import utils.Constants;

public  class Pear extends Fruit {
	
	private Cell pearPos;
	private Cell lastPos;
	
	
	public Pear () {
		super(Constants.pearAppearAfterSEC,Constants.pointsAddedPear,Constants.lenghtAddedPear);
		pearPos=new Cell();
		pearPos.pearPostion();
		lastPos=pearPos;
	}
	
	
	
	
	public void setPos() {
		
		Cell pos=new Cell();
		pos=pos.pearPostion();
		while (pos.equals(lastPos)) {
			pos=pos.pearPostion();
			
		}
		lastPos=pearPos;
		pearPos=pos;
	}
}
