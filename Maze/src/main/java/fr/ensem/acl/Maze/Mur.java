package fr.ensem.acl.Maze;

public class Mur {
	private int posX;
	private int posY;
	
	Mur(int x, int y){ 
		posX = x; 
		posY = y; 
	}
	
	public boolean isFree(int x, int y) {
		if (this.posX == x && this.posY == y)
			return false;
		else
			return true;
	}
}
