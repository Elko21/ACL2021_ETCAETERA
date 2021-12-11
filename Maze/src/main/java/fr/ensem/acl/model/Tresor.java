package model;



public class Tresor extends Entite{
	
	Tresor(int x, int y) {
		super(x,y);
	}
	
	public boolean isEnd(int x, int y) {
		if (this.getX() == x && this.getY() == y)
			return true;
		else
			return false;
	}
}
