package model;

public class Player {
	public static int counter=0;
	public int ID;
    public String name; 
    public String password; 
    public int highscore; 

    public Player(String name, String password) {
		super();
     	++counter;
     	this.ID=counter;
		this.name = name;
		this.password = password;
		this.highscore = 0;
	}

	public int getID() {
		return ID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}	
    
}

