package model;

import utils.Constants;

public class  Banana extends Fruit {
	public Cell bananaPos;	

	
	public Banana () {
		super(Constants.bnanaAppearAfterSEC,Constants.pointsAddedBnana,Constants.lenghtAddedBnana);
		bananaPos=new Cell();
		bananaPos.RandomPostions();
	}
	
	
	
	public void setPos() {
		bananaPos.RandomPostions();

	}
}
