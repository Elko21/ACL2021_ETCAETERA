package fr.ensem.acl.Maze;

public class Hero {
	
	
	Hero(int x, int y){
		super(x,y);
	}
	
	
	
	public void moveTo(int x, int y) {
		this.setY(y);
		this.setX(x);
	}
}
