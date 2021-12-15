package fr.ensem.acl.Maze.model;

public class Personnage extends Entite{
	Personnage(int x, int y){
		super(x,y);
	}
	public void moveTo(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
	}
}

