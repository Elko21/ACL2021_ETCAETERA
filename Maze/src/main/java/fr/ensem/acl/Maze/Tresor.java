package fr.ensem.acl.Maze;

public class Tresor {
	private int posX;
	private int posY;
	
	Tresor(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public boolean isEnd(int x, int y) {
		if (this.posX == x && this.posY == y)
			return true;
		else
			return false;
	}
}
