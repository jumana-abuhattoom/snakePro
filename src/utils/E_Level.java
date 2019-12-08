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
	
	public static E_Level getLevelbyNumber(int lev) { 
		if(lev ==1) return EASY; 
		if(lev ==2) return MEDIUM; 
		return HARD; 
	}
	
}
