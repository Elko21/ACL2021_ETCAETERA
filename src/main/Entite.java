package main;

public class Entite {
	private int posX;
	private int posY;
	
	Entite(int x,int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public int getX() {
		return this.posX;
	}
	public int getY() {
		return this.posY;
	}
	public void setX(int n) {
		this.posX = n;
	}
	public void setY(int n) {
		this.posY = n;
	}
}
