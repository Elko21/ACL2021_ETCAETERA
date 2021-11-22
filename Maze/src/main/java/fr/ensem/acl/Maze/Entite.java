package fr.ensem.acl.Maze;
public class Entite{
	private int posX;
	private int posY;
	
	Entite(int x,int y){
		this.posX = x;
		this.posY = y;
	}
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	public void setX(int x) {
		this.posX=x;
	}
	public void setY(int y) {
		this.posY=y;
	}
}
