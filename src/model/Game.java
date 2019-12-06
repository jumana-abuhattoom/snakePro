package model;

import java.util.ArrayList;
import utils.Constants;

public class Game {

	public static int counter=0;
	public int ID;
	public Player player;
	public int life;
	public int points;
    public ArrayList<Question> askedQues;
    
    
    public Game(Player player) {
		super();
		++counter;
		this.ID=counter;
		this.life=Constants.initialLifeInGame;
		this.points=Constants.initialPointsInGame;
		this.player = player;
	}
    
	public int getID() {
		return ID;
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public ArrayList<Question> getAskedQues() {
		return askedQues;
	}
	public void setAskedQues(ArrayList<Question> askedQues) {
		this.askedQues = askedQues;
	}
	  
}
