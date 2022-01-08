package fr.ensem.acl.Maze.model;

public class Personnage extends Entite{
	private int hp;
	private int attaque;
	private int speed;
	private char dir;
	
	public void setDirection(char c) { this.dir = c; }
	public char getDirection() { return this.dir; }
	public void setHP(int h) { this.hp = h; }
	public int getHP() { return this.hp; }
	
	public Personnage(int x, int y, int h){
		super(x,y);
		this.hp = h;
		this.dir = 'd';
	}
	
	public void moveTo(int x, int y) {
		this.setPosX(x);
		this.setPosY(y);
	}
	
	public void attack(Personnage ennemi) {
		if (this.canAttack(ennemi)) ennemi.hp--; //this.attaque;
	}
	
	public int [] posVoisineRandom() { //Renvoie une position aléatoire au voisinnage de la position courante (U/D/R/L)
		int x=this.getPosX(),y=this.getPosY();
		int i =(int) (4*Math.random());
		switch (i) {
		case 0 : 
			x =this.getPosX()-50;
			break;
		case 1 : 
			x = this.getPosX()+50;
			break;
		case 2 : 
			y=this.getPosY()-50;
			break;
		case 3 :
			y=this.getPosY()+50;
			break;
		}

		int [] pos = {x,y};
		return pos;
	}
	
	public boolean canAttack(Personnage ennemi) {
		// Position x,y du personnage
		int x = this.getPosX()/50;
		int y = this.getPosY()/50;
		
		// Position x,y de l'ennemi
		int xo = ennemi.getPosX()/50;
		int yo = ennemi.getPosY()/50;
		
		boolean att = false;
		switch(this.dir) {
			case 'z':
				att = ((x == xo && y-1 == yo) || (x-1 == xo && y-1 == yo) || (x+1 == xo && y-1 == yo));
			case 's':
				att = ((x == xo && y+1 == yo) || (x-1 == xo && y+1 == yo) || (x+1 == xo && y+1 == yo));
			case 'q':
				att = ((x-1 == xo && y == yo) || (x-1 == xo && y-1 == yo) || (x-1 == xo && y+1 == yo));
			case 'd':
				att = ((x+1 == xo && y == yo) || (x+1 == xo && y-1 == yo) || (x+1 == xo && y+1 == yo));
		}
		
		return att;
	}
}

