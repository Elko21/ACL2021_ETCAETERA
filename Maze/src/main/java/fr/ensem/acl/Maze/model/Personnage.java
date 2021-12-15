package fr.ensem.acl.Maze.model;

public class Personnage extends Entite{
	Personnage(int x, int y){
		super(x,y);
	}
	public void moveTo(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
	}
	
	public int [] posVoisineRandom() {
		int x,y;
		int[] direction= {-50,0,50};
		int i =(int) (3*Math.random());
		x=this.getPosX()+direction[i];
		int j =(int) (3*Math.random());
		y=this.getPosY()+direction[j];
		int [] pos = {x,y};
		return pos;
	}
}

