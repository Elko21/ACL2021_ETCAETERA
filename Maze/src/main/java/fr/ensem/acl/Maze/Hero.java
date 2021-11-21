package fr.ensem.acl.Maze;

public class Hero {
	private int posX;
	private int posY;
	
	Hero(int x, int y){
		posX = x;
		posY = y;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public void moveTo(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
}
