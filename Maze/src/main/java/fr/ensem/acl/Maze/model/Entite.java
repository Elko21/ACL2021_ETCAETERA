package fr.ensem.acl.Maze.model;
public class Entite {
	private int posX;
	private int posY;
	
	Entite(int X,int Y){
		this.posX = X;
		this.posY = Y;
	}
	
	public int getPosX() {
		return this.posX;
	}
	public int getPosY() {
		return this.posY;
	}
	public void setPosX(int x) {
		this.posX = x;
	}
	public void setPosY(int y) {
		this.posY = y;
	}
}
