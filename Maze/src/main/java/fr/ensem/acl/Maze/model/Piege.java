package fr.ensem.acl.Maze.model;

public class Piege extends Entite{
	
	Piege(int x, int y){ 
		super(x,y);
	}
	
	
	public boolean isTriggered(int x,int y){
		return (this.getPosX()==x && this.getPosY()==y);
	}

}