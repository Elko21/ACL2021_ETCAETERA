package model;
public class Entite {
	private int posX;
	private int posY;
	
	Entite(int X,int Y){
		this.posX = X;
		this.posY = Y;
	}
	
	public int getX() {
		return this.posX;
	}
	public int getY() {
		return this.posY;
	}
	public void setX(int x) {
		this.posX = x;
	}
	public void setY(int y) {
		this.posY = y;
	}
}
