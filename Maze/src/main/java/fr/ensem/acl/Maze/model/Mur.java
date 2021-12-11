package fr.ensem.acl.Maze.model;

public class Mur extends Entite{
	private int posX;
	private int posY;
	
	Mur(int x, int y){ 
		super(x,y);
	}
	
	public boolean isFree(int x, int y) {
		if (this.posX == x && this.posY == y)
			return false;
		else
			return true;
	}
}
