package fr.ensem.acl.Maze.model;



public class Tresor extends Entite{
	
	Tresor(int x, int y) {
		super(x,y);
	}
	
	public boolean isEnd(int x, int y) {
		if (this.getPosX() == x && this.getPosY() == y)
			return true;
		else
			return false;
	}
}
