package fr.ensem.acl.Maze.model;

public class Teleportail extends Entite {
	Teleportail(int x,int y){
		super(x,y);
	}
	public boolean canTeleport(int x,int y) {
		return(x == this.getPosX() && y==this.getPosY());
	}
}
