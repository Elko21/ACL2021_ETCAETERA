package model;

public class Hero extends Entite{
	
	Hero(int x, int y){
		super(x,y);
	}
	
	public void moveTo(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
}
