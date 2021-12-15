package fr.ensem.acl.Maze.model;

public class Piege extends Entite{
	
	Piege(int x, int y){ 
		super(x,y);
	}
	
	
	public boolean isTriggered(int xh,int yh){
		return (this.getPosX()==xh && this.getPosY()==yh);
	}

}