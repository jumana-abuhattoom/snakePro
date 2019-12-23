package model;

import java.util.Random;

public class Cell {

	private int x;
	private int y;

	public Cell() {

	}

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void RandomPostions() {
		Random random = new Random();
		int[] xPostions = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475,
				500, 425, 450, 475, 500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825 ,850};
		int[] yPostions = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
				425, 450, 475, 500, 525, 550, 575, 600, 625 };
		int randomx = random.nextInt(34);
		int randomy = random.nextInt(23);

		this.x = xPostions[randomx];
		this.y = yPostions[randomy];
	}
	
	
	public Cell pearPostion() {
		Cell newPos=new Cell();
		Random random = new Random();
		int[] xPostions = { 25,850 };
		int[] yPostions = { 75, 625 };
		int randomx = random.nextInt(2);
		int randomy = random.nextInt(2);
		newPos.x = xPostions[randomx];
		newPos.y = yPostions[randomy];
		return newPos;
	}
	
	
	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	

}