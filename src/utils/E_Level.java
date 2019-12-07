package utils;

public enum E_Level {
	
	EASY(1),MEDIUM(2) , HARD(3);
	
	private final int level;

	private E_Level(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
	
	
}
